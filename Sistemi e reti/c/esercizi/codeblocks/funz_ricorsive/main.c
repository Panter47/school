#include <stdio.h>
#include <stdlib.h>
#include "funz_ricorsive.h"
#include <time.h>

int main()
{
    unsigned int num;

    printf("inserire un numero fino a 43337: ");
    scanf("%d",&num);

    clock_t start=clock();
    printf("la somma dei numeri fino a %d e' %d\n",num,somma_numeri(num));
    clock_t end=clock();
    double time_spend=(double) (end-start)/CLOCKS_PER_SEC;
	printf("il tempo di processo e' %fsecondi",time_spend);

    clock_t start2=clock();
    printf("\n\n\n\nla somma dei numeri fino a %d e'%d utilizzando la funzione interativa",num,somma_numeri_inte(num));
    clock_t end2=clock();
    double time_spend2=(double) (end2-start2)/CLOCKS_PER_SEC;
	printf("\nil tempo di processo e' %fsecondi",time_spend2);

	printf("\n\n\n la somma delle cifre che compongono il numero %d e' %d",num,somma_cifre(num));


    return 0;
}
