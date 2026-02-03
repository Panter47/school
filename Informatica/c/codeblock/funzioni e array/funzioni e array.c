#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define N 10

void generaArray(int vet[])
{
    int i;

    for(i=0;i<N;i++)
    {
        vet[i]=rand()%10+1;
    }
}

void invertiarray(int vet[])
{
    int i,j=N-1,temp;

    for(i=0;i<N/2;i++)
    {
        temp=vet[i];
        vet[i]=vet[j];
        vet[j]=temp;
        j-=1;
    }
}

void stampaArray(int vet[])
{
    int i;

    for(i=0;i<N;i++)
    {
        printf("%d\t",vet[i]);
    }
}

int sommaArray(int vet[])
{
    int i,somma=0;
    for(i=0;i<N;i++)
    {
        somma=somma+vet[i];
    }

    return somma;

}

int main()
{
    int vet[N];

    srand(time(NULL));

    generaArray(vet);
    stampaArray(vet);
    invertiarray(vet);
    printf("\n");
    stampaArray(vet);

    return 0;
}
