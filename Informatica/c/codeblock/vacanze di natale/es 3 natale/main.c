#include <stdio.h>
#include <stdlib.h>

int cifra(int num)
{
    int superiore=0,appoggio;

    while(num>0)
    {
        appoggio=num%10;

        if(appoggio>superiore)
        {
            superiore=appoggio;
        }
        num=num/10;
    }

    return superiore;

}

int main()
{
    int num,alta;

    printf("inserire un numero: ");
    scanf("%d",&num);

    alta=cifra(num);

    printf("la cifra piu' alta del numero %d e' %d",num,alta);

    return 0;
}
