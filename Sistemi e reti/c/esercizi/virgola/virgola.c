#include "virgola.h"

//S EEEEEEE MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM

// s* 1.m * 2^e 
void printflont(float n) {
//int s=((unsigned int) n>>31?-1:+1);

	int s =-2*((unsigned int)n>>31)+1;
	
	int e = ((unsigned int) n>>23) & 0xff;
				 e = e-127;
				 
unsigned int m=(unsigned int)n& 0x007FFFFF;
	
	
printf("%d * 1.%u * 2^%d",s,e,m);
}


void stamp (int numero) {
	
	unsigned int bit, shift;

    printf("la codifica binaria di %d e': ", numero);

    
    for (int i = 31; i >= 0; i--) {

        //eseguo uno shift a destra del numero di "i" posizioni
       shift = numero >> i;
        //faccio il mascheramento con l'and per ricavare il bit
        bit = shift & 1;

        printf("%d", bit); //Stampa del bit
    }

	
	
}