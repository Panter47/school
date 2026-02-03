#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num,i=0,c=0,k=0,j=1;

    printf("scrivere un numero: ");
    scanf("%d",&num);
    i=num-2;

    while(i!=num){
            while(c!=num){
            printf("* ");
            c++;
            }
       printf("\n");
      while(k<num){
        if(j==1){
            printf("* ");
        }
        else if (j==num){
            printf("*\n");
        }
        else {
            printf("  ");
        }
        k++;
        j++;
      }
      k=0;
      c=0;
      i++;
      j=1;
    }
    return 0;
}
