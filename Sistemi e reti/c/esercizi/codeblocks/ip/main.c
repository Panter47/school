#include <stdio.h>
#include <stdlib.h>
#include "myNetLib.h"

int main()
{
    char ip,temporaneo;
    int scelta;
    do
    {
        printf("MENU:\n");
        printf("1 conversione in binario del ip.\n");
        printf("2\n");
        printf("3\n");
        printf("4\n");
        printf("0 per uscire dal menu\n");
        scanf("%d",&scelta);

        switch(scelta)
        {
        case 1:
            {
                printf("scrivere il codice ip: ");
                scanf(" %c",&ip);
                temporaneo=ipToBinary(ip);
                break;
            }
        case 2:
            {
                break;
            }
        case 3:
            {
                break;
            }
        case 4:
            {
                break;
            }
        case 0:
            {
                printf("uscità dal menu");
            }
        }
    }while(scelta!=0);



    return 0;
}
