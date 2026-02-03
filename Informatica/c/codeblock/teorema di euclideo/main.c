#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1;
    int num2;
    int appoggio;
    int resto;

    printf("scrivere il primo numero: ");
    scanf("%d",&num1);
    printf("scrivere il secondo numero: ");
    scanf("%d",&num2);

    if (num1<num2){
        appoggio=num1;
        num1=num2;
        num2=appoggio;
    }
    resto=num1%num2;
    while(resto!=0){
        num2=resto;
        resto=num1%num2;

    }
    printf("il minimo comune divisore e' %d",num2);
    return 0;
}
