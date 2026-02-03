#include <stdio.h>

void stampaNumeri(int n) {
    if (n == 0) {
        return;  
    } else {
        stampaNumeri(n - 1);  
        printf("%d ", n);      
    }
}

int main() {
    int N;
    
    printf("Inserisci un numero N: ");
    scanf("%d", &N);
    
    printf("Numeri naturali fino a %d: ", N);
    stampaNumeri(N);
    printf("\n");

    return 0;
}