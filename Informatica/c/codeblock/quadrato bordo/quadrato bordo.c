#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num,i=0,c=1,k=0,j=1;

    printf("scrivere un numero: ");
    scanf("%d",&num);
    printf("\n");

    while(i!=num){
        if(c==1 || c==num){
             while(k!=num){
             printf("* ");
             k++;
             }
             printf("\n");
        }
        else{
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
      }
      k=0;
      i++;
      j=1;
      c++;

    }
    printf("\n");
    return 0;
}
