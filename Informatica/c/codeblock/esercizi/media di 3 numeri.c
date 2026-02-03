#include <stdio.h>
#include <stdlib.h>

int main()
{
  int num1;
  int num2;
  int num3;
  float media;

  printf("scrivi tre numeri: ");
  scanf("%d",&num1);
  scanf("%d",&num2);
  scanf("%d",&num3);

  media=(num1+num2+num3)/3;

  printf("la media dei tuoi tre numeri e' %.2f",media);


    return 0;
}
