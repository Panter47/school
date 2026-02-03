#include <stdio.h>
#include <stdlib.h>

int main()
{
    float base;
   float altezza;
   float area;
   printf("inserisci la base del triangolo: ");
   scanf("%f", &base);

    printf("inserisci l'altezza del triangolo: ");
    scanf("%f", &altezza);

    area=base*altezza/2;

    printf("l'area del triangolo e' %.2f\n",area);

    return 0;
}
