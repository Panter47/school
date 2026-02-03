#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define righe 5
#define colonne 4

void ruotamatrice(int matrice[][colonne],int matrice2[][righe])
{
    int i,k;

    for(i=0; i<righe;i++)
    {
        for(k=0; k<colonne; k++)
        {
            matrice2[k][righe-i-1]=matrice[i][k];
        }
    }
}


int main()
{
    int matrice[righe][colonne],i,k,matriceruota[colonne][righe];
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
        for(k=0; k<colonne; k++)
        {
            printf("%d\t",matrice[i][k]);
        }
        printf("\n");
    }

    ruotamatrice(matrice,matriceruota);

    printf("\n\n\n\n\n");

    for(i=0; i<colonne; i++)
    {
        for(k=0; k<righe; k++)
        {
            printf("%d\t",matriceruota[i][k]);
        }
        printf("\n");
    }

    return 0;
}
