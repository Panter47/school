#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPrimo(int n)
{
    int i;

    if (n>=1 && n<=3)
    {
        return 1;
    }

    if (n % 2 == 0)
        return 0;

    for(i=3; i <= (int)sqrt(n); i += 2)
        if (n % i == 0)
            return 0;

    return 1;

}

int isNumeroPerfetto(int num)
{
    int divisori[10000]= {0},i,conta=0,somma=0;

    for(i=1; i<num; i++)
    {
        if (num % i ==0)
        {
            divisori[conta]=i;
            conta++;
        }
    }

    for(i=0; i<100; i++)
    {
        somma=somma+divisori[i];
    }
    if(somma==num)
    {
        return 1;
    }
    else
    {
        return 0;
    }

}

int main()
{
    int num,risultato1,risultato2;

    printf("inserire un numero: ");
    scanf("%d",&num);

    risultato1=isPrimo(num);

    if (risultato1==1)
    {
        printf("il numero %d e' un numero primo e di consequenza non puo' essere perfetto",num);
    }
    else
    {
        risultato2=isNumeroPerfetto(num);
        if(risultato2==1)
        {
            printf("il numero %d e' un numero perfetto",num);
        }
        else
        {
            printf("il numero %d non e' un numero perfetto",num);
        }
    }

    return 0;
}
