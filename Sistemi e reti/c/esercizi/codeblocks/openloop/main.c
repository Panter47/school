#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#ifdef _WIN32
    #include <io.h>
    #define GET_FD(fp) _fileno(fp)
    #define GET_HANDLE(fd) _get_osfhandle(fd)
#else
    #include <unistd.h>
    #define GET_FD(fp) fileno(fp)
    #define GET_HANDLE(fd) ((long)(fd))
#endif

// Struttura per memorizzare info su ogni file aperto
typedef struct {
    FILE *fp;              // File pointer
    int index;             // Indice progressivo
    long handle;           // Handle kernel del file
} FileEntry;

// Struttura per le statistiche complessive
typedef struct {
    int total_opened;      // Numero totale di aperture riuscite
    int failed_opens;      // Numero di aperture fallite
    FileEntry *file_list;  // Array dinamico di file aperti
    int list_size;         // Dimensione dell'array
} OpenInfo;

int main() {
    OpenInfo info;
    info.total_opened = 0;
    info.failed_opens = 0;
    info.list_size = 0;
    info.file_list = NULL;

    int capacity = 10;  // Capacità iniziale dell'array
    info.file_list = (FileEntry *)malloc(capacity * sizeof(FileEntry));

    if (info.file_list == NULL) {
        fprintf(stderr, "ERRORE: Impossibile allocare memoria iniziale\n");
        return 1;
    }

    printf("Inizio apertura ripetuta del file 'test.txt'...\n");
    printf("Premi Ctrl+C per interrompere se necessario\n\n");

    // Crea il file test.txt se non esiste
    FILE *test = fopen("test.txt", "w");
    if (test != NULL) {
        fprintf(test, "File di test per openloop\n");
        fclose(test);
    }

    // Ciclo infinito di aperture
    while (true) {
        FILE *fp = fopen("test.txt", "r");

        if (fp == NULL) {
            // Apertura fallita
            perror("fopen");
            info.failed_opens++;
            break;
        }

        // Apertura riuscita
        info.total_opened++;

        // Espandi l'array se necessario
        if (info.list_size >= capacity) {
            capacity *= 2;
            FileEntry *new_list = (FileEntry *)realloc(info.file_list,
                                                       capacity * sizeof(FileEntry));
            if (new_list == NULL) {
                fprintf(stderr, "ERRORE: Impossibile espandere l'array (apertura %d)\n",
                        info.total_opened);
                fclose(fp);
                break;
            }
            info.file_list = new_list;
        }

        // Ottieni il file descriptor e l'handle kernel
        int fd = GET_FD(fp);
        long handle = GET_HANDLE(fd);

        // Memorizza le informazioni
        info.file_list[info.list_size].fp = fp;
        info.file_list[info.list_size].index = info.total_opened;
        info.file_list[info.list_size].handle = handle;
        info.list_size++;

        // Mostra progresso ogni 100 aperture
        if (info.total_opened % 100 == 0) {
            printf("Aperture riuscite: %d\n", info.total_opened);
        }
    }

    printf("\n=== Limite raggiunto ===\n");
    printf("Totale aperture riuscite: %d\n", info.total_opened);
    printf("Aperture fallite: %d\n", info.failed_opens);

    // Mostra alcuni dettagli dei file aperti
    printf("\nPrimi 5 file aperti:\n");
    int show_count = (info.list_size < 5) ? info.list_size : 5;
    for (int i = 0; i < show_count; i++) {
        printf("  [%d] FP=%p, Handle=%ld\n",
               info.file_list[i].index,
               (void*)info.file_list[i].fp,
               info.file_list[i].handle);
    }

    if (info.list_size > 5) {
        printf("  ... (%d file in totale)\n", info.list_size);
        printf("\nUltimi 5 file aperti:\n");
        for (int i = info.list_size - 5; i < info.list_size; i++) {
            printf("  [%d] FP=%p, Handle=%ld\n",
                   info.file_list[i].index,
                   (void*)info.file_list[i].fp,
                   info.file_list[i].handle);
        }
    }

    // Chiusura di tutti i file
    printf("\n=== Chiusura file ===\n");
    int close_errors = 0;

    for (int i = 0; i < info.list_size; i++) {
        if (fclose(info.file_list[i].fp) != 0) {
            fprintf(stderr, "ANOMALIA: Impossibile chiudere il file [%d]\n",
                    info.file_list[i].index);
            close_errors++;
        }

        // Mostra progresso ogni 100 chiusure
        if ((i + 1) % 100 == 0) {
            printf("File chiusi: %d/%d\n", i + 1, info.list_size);
        }
    }

    printf("Tutti i file sono stati chiusi.\n");

    if (close_errors > 0) {
        fprintf(stderr, "ANOMALIA: %d errori durante la chiusura dei file\n", close_errors);
    }

    // Report finale su stdout
    printf("\n=== REPORT FINALE ===\n");
    printf("File aperti con successo: %d\n", info.total_opened);
    printf("Tentativi falliti: %d\n", info.failed_opens);
    printf("Errori in chiusura: %d\n", close_errors);
    printf("Memoria allocata per lista: %d byte\n", capacity * (int)sizeof(FileEntry));

    // Libera la memoria
    free(info.file_list);

    printf("\nRisorse rilasciate correttamente.\n");

    return (info.failed_opens > 0 || close_errors > 0) ? 1 : 0;
}
