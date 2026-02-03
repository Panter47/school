#include <stdio.h>
#include <math.h>
#include <time.h>

#define MAX 1000000  // Puoi cambiare questo valore per un limite superiore diverso

// Dichiarazione dell'array is_prime come variabile globale
int is_prime[MAX];

int main() {
    int i, j;
    clock_t start, end;
    double cpu_time_used;

    // Inizializza l'array, assumendo che tutti i numeri siano primi
    for (i = 2; i < MAX; i++) {
        is_prime[i] = 1;
    }

    // Inizia il timer
    start = clock();

    // Implementazione del Crivello di Eratostene
    for (i = 2; i <= sqrt(MAX); i++) {
        if (is_prime[i]) {
            for (j = i * i; j < MAX; j += i) {
                is_prime[j] = 0;
            }
        }
    }

    // Ferma il timer
    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    // Stampa il tempo impiegato
    printf("\nTempo impiegato: %f secondi\n", cpu_time_used);

    return 0;
}
