#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#define BLOCK_SIZE 256

// Struttura per memorizzare le statistiche di copia
typedef struct {
    long bytes_copied;
    int read_errors;
    int write_errors;
} CopyStats;

int main(int argc, char *argv[]) {
    FILE *src = NULL;
    FILE *dst = NULL;
    unsigned char buffer[BLOCK_SIZE];
    size_t bytes_read, bytes_written;
    CopyStats stats = {0, 0, 0};  // Inizializza tutti i campi a 0

    // Verifica numero argomenti
    if (argc != 3) {
        fprintf(stderr, "Uso: %s <file_sorgente> <file_destinazione>\n", argv[0]);
        return 1;
    }

    // Apertura file sorgente in modalità lettura binaria
    src = fopen(argv[1], "rb");
    if (src == NULL) {
        perror("Errore apertura file sorgente");
        return 1;
    }

    // Apertura file destinazione in modalità scrittura binaria
    dst = fopen(argv[2], "wb");
    if (dst == NULL) {
        perror("Errore apertura file destinazione");
        fclose(src);
        return 1;
    }

    // Ciclo di copia a blocchi
    while ((bytes_read = fread(buffer, 1, BLOCK_SIZE, src)) > 0) {
        // Verifica se fread ha fallito (non EOF)
        if (bytes_read < BLOCK_SIZE && !feof(src)) {
            if (ferror(src)) {
                perror("Errore durante la lettura");
                stats.read_errors++;
            }
        }

        // Scrittura sul file destinazione
        bytes_written = fwrite(buffer, 1, bytes_read, dst);

        if (bytes_written < bytes_read) {
            perror("Errore durante la scrittura");
            stats.write_errors++;
        } else {
            stats.bytes_copied += bytes_written;
        }
    }

    // Verifica errore finale di lettura
    if (ferror(src)) {
        perror("Errore finale di lettura");
        stats.read_errors++;
    }

    // Chiusura file
    if (fclose(src) != 0) {
        perror("Errore chiusura file sorgente");
    }

    if (fclose(dst) != 0) {
        perror("Errore chiusura file destinazione");
    }

    // Stampa resoconto su stdout
    printf("=== Resoconto Copia File ===\n");
    printf("File sorgente: %s\n", argv[1]);
    printf("File destinazione: %s\n", argv[2]);
    printf("Byte copiati: %ld\n", stats.bytes_copied);
    printf("Errori di lettura: %d\n", stats.read_errors);
    printf("Errori di scrittura: %d\n", stats.write_errors);
    printf("Stato: ");

    if (stats.read_errors == 0 && stats.write_errors == 0) {
        printf("SUCCESSO\n");
    } else {
        printf("COMPLETATO CON ERRORI\n");
    }

    // Stampa anomalie su stderr se presenti
    if (stats.read_errors > 0) {
        fprintf(stderr, "ANOMALIA: Rilevati %d errori di lettura durante la copia\n",
                stats.read_errors);
    }

    if (stats.write_errors > 0) {
        fprintf(stderr, "ANOMALIA: Rilevati %d errori di scrittura durante la copia\n",
                stats.write_errors);
    }

    return (stats.read_errors > 0 || stats.write_errors > 0) ? 1 : 0;
}
