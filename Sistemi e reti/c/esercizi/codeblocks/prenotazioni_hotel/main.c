//gestire le prenotazioni di un hotel.

#include <stdio.h>
#include <stdlib.h>

#define MAX_NOME 30
#define MAX_PRENOTAZIONI 100

int numeroPrenotazioni = 0;
char* nomi[MAX_PRENOTAZIONI];
int tipi[MAX_PRENOTAZIONI];
double prezzi[MAX_PRENOTAZIONI];


// inizializzo l'array dei nomi
void inizializza() {
    for (int i = 0; i < MAX_PRENOTAZIONI; i++) {
        nomi[i] = malloc(MAX_NOME * sizeof(char));
    }
}

void inserisciPrenotazione() {
    if (numeroPrenotazioni >= MAX_PRENOTAZIONI) {
        printf("\nLimite massimo raggiunto!\n");
    }
    else{
        // faccio inserire nomi e tipo di stanza
        printf("\n--- Inserisci prenotazione %d ---\n", numeroPrenotazioni + 1);
        printf("Nome cliente: ");
        scanf(" %29[^\n]", nomi[numeroPrenotazioni]);

        printf("Tipo camera (0=Singola 50, 1=Doppia 80, 2=Suite 120): ");
        scanf("%d", &tipi[numeroPrenotazioni]);

        // Prezzo calcolato in base al tipo di stanza scelto
        if (tipi[numeroPrenotazioni] == 0)
            prezzi[numeroPrenotazioni] = 50.0;
        else if (tipi[numeroPrenotazioni] == 1)
            prezzi[numeroPrenotazioni] = 80.0;
        else
            prezzi[numeroPrenotazioni] = 120.0;

        numeroPrenotazioni++;
        printf("Prenotazione inserita! Prezzo: %.2f \n",prezzi[numeroPrenotazioni - 1]);
    }

}


void mostraPrenotazioni() {
    if (numeroPrenotazioni == 0) {
        printf("\nNessuna prenotazione presente.\n");
    }
    else{
       printf("\n--- Elenco prenotazioni ---\n");
        for (int i = 0; i < numeroPrenotazioni; i++) {
            printf("%d) %s - ", i + 1, nomi[i]);

            if (tipi[i] == 0) printf("Singola");
            else if (tipi[i] == 1) printf("Doppia");
            else printf("Suite");

            printf(" - Prezzo: %.2f €\n", prezzi[i]);
        }
    }

}

void liberaMemoria() {
    for (int i = 0; i < MAX_PRENOTAZIONI; i++) {
        free(nomi[i]);
    }
}

void menu() {
    printf("\n--- MENU PRINCIPALE ---\n");
    printf("1. Inserisci prenotazione\n");
    printf("2. Visualizza tutte le prenotazioni\n");
    printf("0. Esci\n");
    printf("Scelta: ");
}

int main() {
    int scelta;
    inizializza();

    do {
        menu();
        scanf("%d", &scelta);

        switch (scelta) {
            case 1:
                inserisciPrenotazione();
                break;
            case 2:
                mostraPrenotazioni();
                break;
            case 0:
                printf("Chiusura programma...\n");
                break;
            default:
                printf("Scelta non valida!\n");
        }
    } while (scelta != 0);

    liberaMemoria();
    return 0;
}
