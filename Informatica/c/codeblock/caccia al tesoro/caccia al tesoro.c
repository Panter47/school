#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define ordine 5

int caccia (char matrice[][ordine], int rig, int col, int i, int j )
{
    int ret=0,diffri,diffco;

    diffri=i-rig;
    diffco=j-col;

    if (diffco==0 && diffri==0)
    {
        ret=8;
    }
    else if ((diffri<=1 && diffri>=-1)&&(diffco<=1 && diffco>=-1))
    {
        ret=1;
    }
    else if ((diffri<=2 && diffri>=-2)&&(diffco<=2 && diffco>=-2))
    {
        ret=2;
    }
    else
    {
        ret=3;
    }

    return ret;
}

int main()
{
    int i,j,riga,colonna,flag=1,z=0;
    char matrice[ordine][ordine];
    srand(time(NULL));

    for(i=0; i<ordine; i++)
    {
        for(j=0; j<ordine; j++)
        {
            matrice[i][j]= ' ';
        }
    }

    i=rand()% ordine;
    j=rand()% ordine;
    matrice[i][j]='X';

    while(flag!=0)
    {
        printf("inserire le cordinate della caccia al tesoro da 1 a 5: \nriga: ");
        scanf("%d",&riga);
        printf("colonna: ");
        scanf("%d",&colonna);
        z++;
        riga--;
        colonna--;

        flag=caccia(matrice,riga,colonna,i,j);

        if(flag==8)
        {
            printf("VITTORIA!!!\n");
            break;
        }
        else if(flag==1)
        {
            printf("Molto vicino riprovare.\n");
        }
        else if(flag==2)
        {
            printf("Vicino riprovare.\n");
        }
        else
        {
            printf("lontano.\n");
        }
    }

     for(i=0; i<ordine; i++)
        {
            for(j=0; j<ordine-1; j++)
            {
                printf("  %c  |",matrice[i][j]);
            }
            printf("  %c  ",matrice[i][j]);
            if(i<ordine-1)
            {
                printf("\n-----+-----+-----+-----+-----\n");
            }
        }


    printf("\nsono stati impiegati %d tentativi.\n",z);


    return 0;
}
