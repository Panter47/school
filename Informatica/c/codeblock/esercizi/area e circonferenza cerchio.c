#include <stdio.h>
#include <stdlib.h>
#define PIGRECO 3.1415

int main()
{
    float raggio;
    float circonferenza;
    float area;
    //const float PIGRECO=3.1415;
    printf("scrivi il raggio del cerchio: ");
    scanf("%f", &raggio);

    circonferenza =2*PIGRECO*raggio;
    area=PIGRECO*raggio*raggio;

    printf("l'area del cerchio e' %.2f e la circonferenza e' %.2f \n", area, circonferenza);

    return 0;
}
