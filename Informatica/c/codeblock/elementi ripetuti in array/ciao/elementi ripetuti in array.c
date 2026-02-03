#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define N 30
int main()
{
    int vet1[N],i,j,duplicato[21]={0};

    srand(time(NULL));

    for(i=0;i<N;i++)
    {
        vet1[i]=rand()%20+1;
        printf("%d  ",vet1[i]);
    }
    for(i=0;i<N;i++)
    {
        duplicato[vet1[i]]++;
    }

    printf("\ni numeri che si ripetono sono: \n");

    for(i=0;i<21;i++)
    {
        if(duplicato[i]>1)
        {
            printf("%d  ",i);
        }
    }

    return 0;
}

