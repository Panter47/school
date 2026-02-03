#include <stdio.h>
#include <stdlib.h>
/* dare al prgramma 2 frazioni sotto forma di numeratore 1 e denominatore 1 e numeratore 2 denominatore 2 qualsiasi numero
poi calcolare la somma delle frazioni
moltiplicazione dei 2 denominatore */
int main()
{
    int n1;
    int n2;
    int d1;
    int d2;
    int somman;
    int sommad;
    printf("scrivi il primo numeratore della frazione: ");
    scanf("%d",&n1);
    printf("scrivi il primo denominatore della frazione: ");
    scanf("%d",&d1);
    printf("scrivi il secondo numeratore della frazione: ");
    scanf("%d",&n2);
    printf("scrivi il secondo denominatore della frazione: ");
    scanf("%d",&d2);

    somman=(n1*d2)+(n2*d1);
    sommad=d1*d2;

    printf("la somma dei numeratori equivale a %d \n la moltiplicazione tra i denominatori equivale a %d\n",somman,sommad);


    return 0;
}
