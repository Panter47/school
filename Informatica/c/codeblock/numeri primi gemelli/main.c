#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isprimo(int n)
{
    int i;

    if (n>=1 && n<=3)
    {
        return 1;
    }

    if (n % 2 == 0)
        return 0; /* no perche' numeri pari */

    for(i=3; i <= (int)sqrt(n); i += 2)
        if (n % i == 0)
            return 0; /* no, perche' e' stato trovato */

    return 1;

}
int geprimi(int j,int k)
{
    int risultato;

    if(j-k==2 || k-j==2)
    {
        risultato=1;
    }
    else
    {
        risultato=0;
    }

    return risultato;
}

int main()
{
    int num1,num2,risultato1,risultato2,gemelli;

    printf("Inserire il primo numero: ");
    scanf("%d", &num1);

    risultato1 = isprimo(num1);

    printf("inserire il secondo numero: ");
    scanf("%d",&num2);

    risultato2=isprimo(num2);

    if(risultato1!=0 && risultato2!=0)
    {
        gemelli=geprimi(num1,num2);
        if(gemelli==1)
        {
            printf("i numeri %d e %d sono primi gemelli",num1,num2);
        }
        else
        {
            printf("i numeri %d e %d non sono primi gemelli",num1, num2);
        }
    }
    else if(risultato1==0)
    {
        printf("il numero %d non e' un numero primo",num1);
    }
    else
    {
        printf("il numero %d non e' un numero primo",num2);
    }
    return 0;
}
