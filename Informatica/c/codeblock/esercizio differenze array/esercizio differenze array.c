#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define N 10

int main()
{
    int vet1[N],vet2[N],i,k;
    srand(time(NULL));

    for(i=0; i<N; i++)
    {
        vet1[i]=rand()%20+1;
        printf("%d\t",vet1[i]);
    }

    printf("\n");

    for(i=0; i<N; i++)
    {
        vet2[i]=rand()%20+1;
        printf("%d\t",vet2[i]);
    }

    for(i=0; i<N; i++)
    {
        for(k=0; k<N; k++)
        {
            if(vet1[i]==vet2[k])
            {
                vet1[i]=0;
            }
        }
    }

    printf("\n");

    for(i=0; i<N; i++)
    {
        if(vet1[i]!=0)
        {
            printf("%d\t",vet1[i]);
        }
    }

    return 0;
}
