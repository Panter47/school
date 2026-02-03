#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1;
    int num2;
    int num3;

    printf("scrivere il primo numero: ");
    scanf("%d",&num1);
    printf("scrivere il secondo numero: ");
    scanf("%d",&num2);
    printf("scrivere il terzo numero: ");
    scanf("%d",&num3);

    if((num1*num1)+(num2*num2)==num3*num3 || (num2*num2)+(num3*num3)==num1*num1 || (num3*num3)+(num1*num1)==num2*num2){
        printf("i tre numeri scritti formano una terna pitagorica");
    }
    else {
        printf("i tre numeri inseriti non formano una terna pitagorica");
    }
    return 0;
}
