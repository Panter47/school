#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define righe 5
#define colonne 4

int minimo (int matrice[][colonne])
{
    int i,k,min;

    min=matrice[0][0];
    for(i=0;i<righe;i++)
    {
        for(k=0;k<colonne;k++)
        {
            if(min>matrice[i][k])
            {
                min=matrice[i][k];
            }
        }
    }

    return min;
}

int massimo (int matrice[][colonne])
{
    int i,k,max=0;

    for(i=0;i<righe;i++)
    {
        for(k=0;k<colonne;k++)
        {
            if(max<matrice[i][k])
            {
                max=matrice[i][k];
            }
        }
    }

    return max;
}

int main()
{
    int matrice[righe][colonne],i,k,min,max;
    srand(time(NULL));


    for(i=0; i<righe; i++)
    {
        for(k=0; k<colonne; k++)
        {
            matrice[i][k]=rand()%30+1;
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

    min=minimo(matrice);
    max=massimo(matrice);


    printf("\nil valore piu' piccolo della matrice e': %d",min);
     printf("\nil valore piu' grande della matrice e': %d",max);

    return 0;
}
