#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int vet1[20],num=0,i,vetmin[20],vetmax[20],j=0,k=0;
    srand(time(NULL));

    printf("inserire un numero: ");
    scanf("%d",&num);

    for(k=0; k<20; k++)
    {
        vetmax[k]=0;
    }
    for(j=0; j<20; j++)
    {
        vetmin[j]=0;
    }

    for (i=0; i<20; i++)
    {
        vet1[i]=(rand()%50)+1;
        printf("%d\t",vet1[i]);
    }
    k=0;
    j=0;
    for(i=0; i<20; i++)
    {
        if(vet1[i]<=num)
        {
            vetmin[j]=vet1[i];
            j++;
        }
        else
        {
            vetmax[k]=vet1[i];
            k++;
        }
    }
    printf("\ni numeri maggiori di %d sono: \n",num);

    for(k=0; k<20; k++)
    {
        printf("%d\t",vetmax[k]);
    }
    printf("\ni numeri minori di %d sono: \n",num);

    for(j=0; j<20; j++)
    {
        printf("%d\t",vetmin[j]);
    }
    return 0;
}
