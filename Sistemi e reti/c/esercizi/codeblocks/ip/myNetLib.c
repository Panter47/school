#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "myNetLib.h"


char* ipToBinary(char* ip){
    int values[4]={0}, i=0;

    char* token=strtok(ip, ".");
    values[0]=atoi(token);

    for (i=1; i<4; i++)
    {
        token=strtok(NULL, ".");         //here we extract the octet from the sting and thanks to atoi we convert it to int
        values[i]=atoi(token);           //then we add it to our array that will be used later
    }

    for(i=0; i<4; i++)
    {
        int bits[8]={0};

        for(int j=0; j<8; j++)
        {
            bits[j]=values[i]%2;         //here we use the basic method to convert a decimal to a binary number by saving the bits inside an array
            values[i]=values[i]/2;
        }

        for(int j=7; j>=0; j--)
        {
            printf("%d", bits[j]);       //and printing it reversed, because if we don't reverse it, the order is LSB-->MSB and we don't want that
        }

        printf(" ");
    }
}
