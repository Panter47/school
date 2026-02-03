#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define righe 5
#define colonne 4

int sommariga (int matrice[][colonne],int riga)
{
    int k,somma=0;

        for(k=0;k<colonne;k++)
        {
            somma+=matrice[riga][k];
        }

    return somma;
}

int sommacolonna (int matrice[][colonne],int colonna)
{
     int k,somma=0;

        for(k=0;k<righe;k++)
        {
            somma+=matrice[k][colonna];
        }

    return somma;
}

int main()
{
    int matrice[righe][colonne],i,k,sommari,sommaco;
    srand(time(NULL));


    for(i=0; i<righe; i++)
    {
        for(k=0; k<colonne; k++)
        {
            matrice[i][k]=rand()%10+1;
        }
    }

    for(i=0; i<righe; i++)
    {
        printf("\n");
        for(k=0; k<colonne; k++)
        {
            printf("%d\t",matrice[i][k]);
        }
        printf("\n");
    }

    for(i=0;i<righe;i++)
    {
        sommari=sommariga(matrice,i);
        printf("\nla somma della riga %d e' %d",i,sommari);
    }

     for(i=0;i<colonne;i++)
    {
        sommaco=sommacolonna(matrice,i);
        printf("\nla somma della colonna %d e' %d",i,sommaco);
    }

    return 0;
}
