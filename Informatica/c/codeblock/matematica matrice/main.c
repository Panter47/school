//KPANTE TCHEN AARON
#include <stdio.h>
#include <stdlib.h>

int ordine2(int matrice[][2])
{
    int det;

        det=(matrice[0][0]*matrice[1][1])-(matrice[0][1]*matrice[1][0]);
    return det;
}


int ordine3( int matrice[][3])
{
    int detp,dets,det;

        detp=(matrice[0][0]*matrice[1][1]*matrice[2][2])+(matrice[0][1]*matrice[1][2]*matrice[2][0])+(matrice[0][2]*matrice[1][0]*matrice[2][1]);
        dets=(matrice[0][2]*matrice[1][1]*matrice[2][0])+(matrice[0][0]*matrice[1][2]*matrice[2][1])+(matrice[0][1]*matrice[1][0]*matrice[2][2]);
        det=detp-dets;


    return det;
}

int main()
{
    int i,j,ordine,determinante=0;

    do
    {
        printf("inserire l'ordine della matrice compreso tra 1 e 3: ");
        scanf("%d",&ordine);
    }
    while(ordine>3 || ordine<1);

    int matrice[ordine][ordine];

    for(i=0; i<ordine; i++)
    {
        for(j=0; j<ordine; j++)
        {
            printf("\ninserire il numero della posizione %d;%d :",i,j);
            scanf("%d",&matrice[i][j]);
        }
    }

     for(i=0; i<ordine; i++)
    {
        printf("\n");
        for(j=0; j<ordine; j++)
        {
            printf("%d\t",matrice[i][j]);
        }
        printf("\n");
    }

    if(ordine==1)
    {
        determinante=matrice[ordine-1][ordine-1];
        printf("il determinante della matrice di ordine 1 e' %d",determinante);
    }
    else if(ordine==2)
    {
        determinante=ordine2(matrice);
        printf("il determinante della matrice di ordine 2 e' %d",determinante);

    }
   else
    {
        determinante=ordine3(matrice);
        printf("il determinante della matrice di ordine 3 e' %d",determinante);
    }

    return 0;
}
