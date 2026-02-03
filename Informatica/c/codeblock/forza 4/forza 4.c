#include <stdio.h>
#include <stdlib.h>
#define riga 6
#define colonne 7

void inserimento (char matrice[][colonne],char var)
{
    int righe=5,colonna=0,k=1;

    printf("\nInserire le cordinate di dove si vuole inserire la propria pedina, inserire la colonna da 1 a 7.");;
    printf("\nColonna: ");
    scanf("%d",&colonna);

    do
    {
        if(matrice[righe][colonna-1]==' ')
        {
            matrice[righe][colonna-1]=var;
            k=0;
        }
        else
        {
            righe--;
        }
    }
    while(k==1);
}

int controllo (char matrice[][colonne])
{
    int i,j,ret=0,ri,k;
    int croce=0,cerchio=0;

    //controllo colonne
    for(i=0; i<colonne; i++)
    {
        for(j=0; j<riga; j++)
        {
            if(matrice[j][i]=='X' && matrice[j+1][i]=='X' && matrice[j+2][i]=='X'  && matrice[j+3][i]=='X' )
            {
                croce=1;
            }
            else if(matrice[j][i]=='O' && matrice[j+1][i]=='O' && matrice[j+2][i]=='O' && matrice[j+3][i]=='O')
            {
                cerchio=1;
            }
        }
        if(croce==1)
        {
            ret=1;
            break;
        }
        else if(cerchio==1)
        {
            ret=2;
            break;
        }
    }


    // controllo righe
    for(i=0; i<riga; i++)
    {
        for(j=0; j<colonne; j++)
        {
            if(matrice[i][j]=='X' &&  matrice[i][j+1]=='X' && matrice[i][j+2]=='X' && matrice[i][j+3]=='X')
            {
                croce=1;
            }
            else if(matrice[i][j]=='O' && matrice[i][j+1]=='O' && matrice[i][j+2]=='O' && matrice[i][j+3]=='O')
            {
                cerchio=1;
            }
        }
        if(croce==1)
        {
            ret=1;
            break;
        }
        else if(cerchio==1)
        {
            ret=2;
            break;
        }
    }

    //controllo diagonale princ
    for(i=riga; i>=0; i--)
    {
        ri=i;
        j=6;
        for(k=0; k<6; k++)
        {
            if(matrice[ri][j]=='X')
            {
                croce++;
            }
            else if(matrice[ri][j]=='O')
            {
                cerchio++;
            }

            ri--;
            j--;
        }
        if(croce==4)
        {
            ret=1;
            break;
        }
        else if(cerchio==4)
        {
            ret=2;
            break;
        }

        croce=0;
        cerchio=0;
    }



    //controllo diagonale sec
    for(i=riga; i>=0; i--)
    {
        ri=i;
        j=0;
        for(k=0; k<6; k++)
        {
            if(matrice[ri][j]=='X')
            {
                croce++;
            }
            else if(matrice[ri][j]=='O')
            {
                cerchio++;
            }

            ri--;
            j++;
        }
        if(croce==4)
        {
            ret=1;
            break;
        }
        else if(cerchio==4)
        {
            ret=2;
            break;
        }

        croce=0;
        cerchio=0;
    }
    return ret;
}



int main()
{
    int i,j,a=0,fine=0;
    char matrice[riga][colonne],var;


    for(i=0; i<riga; i++)
    {
        for(j=0; j<colonne; j++)
        {
            matrice[i][j]= ' ';
        }

    }

    for(i=0; i<riga; i++)
    {
        for(j=0; j<colonne-1; j++)
        {
            printf("  %c  |",matrice[i][j]);
        }
        printf("  %c  ",matrice[i][j]);
        if(i<riga-1)
        {
            printf("\n-----+-----+-----+-----+-----+-----+-----\n");
        }

    }
    while(a<42 || fine!=0)
    {
        var='X';
        inserimento(matrice,var);

        for(i=0; i<riga; i++)
        {
            for(j=0; j<colonne-1; j++)
            {
                printf("  %c  |",matrice[i][j]);
            }
            printf("  %c  ",matrice[i][j]);
            if(i<riga-1)
            {
                printf("\n-----+-----+-----+-----+-----+-----+-----\n");
            }
        }
        fine=controllo(matrice);
        if(fine!=0)
        {
            break;
        }


        var='O';
        inserimento(matrice,var);

        for(i=0; i<riga; i++)
        {
            for(j=0; j<colonne-1; j++)
            {
                printf("  %c  |",matrice[i][j]);
            }
            printf("  %c  ",matrice[i][j]);
            if(i<riga-1)
            {
                printf("\n-----+-----+-----+-----+-----+-----+-----\n");
            }
        }
        a+=2;
    }

    if(fine==1)
    {
        printf("\nHA VINTO IL GIOCATORE CON LA x");
    }
    else if(fine==2)
    {
        printf("\nHA VINTO IL GIOCATORE CON LA o");
    }
    else
    {
        printf("\nPAREGGIO!!!");
    }



    return 0;
}
