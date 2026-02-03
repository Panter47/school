#include <stdio.h>
#include <stdlib.h>

int differenzaMaxMin(int num1, int num2, int num3)
{
    int max,min,dif;
    if(num1>num2 && num2>num3 && num1>num3)
    {
        max=num1;
        min=num3;
    }
    else if(num2>num1 && num1>num3 && num2>num3)
    {
        max=num2;
        min=num3;
    }
    else if(num3>num2 && num2>num1 && num3>num1)
    {
        max=num3;
        min=num1;
    }
    else if(num3>num1 && num1>num2 && num3>num2)
    {
        max=num3;
        min=num2;
    }
    else if(num1>num3 && num3>num2 && num1> num2)
    {
        max=num1;
        min=num2;
    }
    else if(num2>num3 && num2>num1 && num3>num1)
    {
        max=num2;
        min=num1;
    }
    dif=max-min;
    return dif;
}

int main()
{
   int num1,num2,num3,differenza;

    printf("inserire il primo numero: ");
    scanf("%d",&num1);

    printf("inserire il secondo numero: ");
    scanf("%d",&num2);

    printf("inserire il terzo numero: ");
    scanf("%d",&num3);

    differenza=differenzaMaxMin(num1,num2,num3);

    printf("la differenza %d",differenza);

    return 0;
}
