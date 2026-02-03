#include <stdio.h>
#include <stdlib.h>

int main()
{
    float spesa;
    float sconto;

    printf("scrivere l'importo della spesa: ");
    scanf("%f",&spesa);

    if(spesa<50){
        spesa=spesa/100*95;
        sconto=spesa/100*5;
        printf("le e' stato applicato uno sonto di %.2f euro", sconto);
    }
    else if(spesa<65){
        spesa=spesa/100*94;
        sconto=spesa/100*6;
        printf("le e' stato applicato uno sconto di %.2f euro", sconto);
    }
    else if(spesa<80){
        spesa=spesa/100*93;
        sconto=spesa/100*7;
        printf("le e' stato applicato uno sconto di %.2f euro", sconto);
    }
    else if(spesa>80){
        spesa=spesa/100*90;
        sconto=spesa/100*10;
        printf("le e' stato applicato uno sconto di %.2f euro", sconto);
    }
    printf("\nil suo totale ammonta a %.2f euro\n",spesa);
    return 0;
}
