#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int num,vet[20],i;
    srand(time(NULL));

    for(i=0; i<20; i++)
    {
        vet[i]=rand()%20+1;
    }
    printf("inserire un numero: ");
    scanf("%d",&num);

    i=0;
    while(vet[i]!=num && i<num)
    {
        i++;
    }

    if(i>=num)
    {
        printf("il numero inserito non e' uscito dal generatore casuale di numeri.\n");
    }
    else
    {
        printf("la posizione in cui si trova il numero inserito e' %d\n",i);
    }
    for(i=0; i<20; i++)
    {
        printf("%d\t",vet[i]);
    }

    return 0;
}
