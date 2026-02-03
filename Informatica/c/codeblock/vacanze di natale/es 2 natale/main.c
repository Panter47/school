#include <stdio.h>
#include <stdlib.h>

float calcolatrice(int num1, int num2, char segno)
{
    float risultato;

    if (segno=='+')
    {
        risultato=num1+num2;
    }
    else if(segno=='-')
    {
        risultato=num1-num2;
    }
    else if(segno=='*')
    {
        risultato=num1*num2;
    }
    else if(segno=='/' && num2!=0)
    {
        risultato=(float)num1/num2;
    }
    else
    {
        printf("impossibile eseguire il calcolo\n");
    }
    return risultato;
}

int main()
{
    int num1,num2;
    char segno;
    float calcolo;

    printf("inserire il primo numero: ");
    scanf("%d",&num1);
    printf("inserire il segno che si vuole appliccare: ");
    scanf(" %c",&segno);
    printf("inserire il secondo numero: ");
    scanf("%d",&num2);

    calcolo=calcolatrice(num1,num2,segno);

    printf("il riultato del calcolo e' %.2f ",calcolo);

    return 0;
}
