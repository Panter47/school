#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define N 30
#define M 100
int main()
{
    int vet[N],i,num,k=0,j,x,vetnum[M],conta=0,z;
    srand(time(NULL));

    for(x=0; x<M; x++)
    {
        vetnum[x]=0;
    }
    x=0;
    for(i=0; i<N; i++)
    {
        vet[i]=rand()%20+1;
        printf("%d\t",vet[i]);
    }

    for(j=0; j<N; j++)
    {
        i=1;
        num=vet[k];
        while(i<N)
        {
            if(num==vet[i] && i!=k)
            {
                vetnum[x]=num;
                x++;
            }
            i++;
        }
        k++;
    }
    printf("\n\n");

    for(x=0; x<M; x++)
    {
        printf("%d\t",vetnum[x]);
    }

    return 0;
}
