#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1, num2;
    int i=9;

    printf("scrivi un numero: ");
    scanf("%d",&num1);

    while (i!=0){
        printf("scrivi un numero: ");
        scanf("%d",&num2);
        i=i-1;
        if(num1<num2){
        num1=num2;

    }
 }
    printf("il numero piu' grande e' %d ",num1);

    return 0;
}
