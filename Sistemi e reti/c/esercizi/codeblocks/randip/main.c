#include <stdio.h>
#include <stdlib.h>
#include "randip.h"
#include <time.h>


int main(int argc, char* argv[]) {

    srand(time(NULL));
    int max = parse_cli(argc,argv);
    if(max==-1){
        print_help();
    }
    for(int i=0; i < max; i++){
        generate_ip();
        printf("\nIP casuale numero %d: %u.%u.%u.%u\t",i+1,ip_casuale[0],ip_casuale[1],ip_casuale[2],ip_casuale[3]);
        //classificazione se privato/pubblico/riservato/multicast
        if(ip_casuale[0] <= 127){
            printf(" classe A");
            if(ip_casuale[0]==10)
                printf(" Privato");
            else
                printf(" Pubblico");
        }
        else if(ip_casuale[0] <= 191) {
            printf(" Classe B");
            if(ip_casuale[0]==172 && ip_casuale[1]>=16 && ip_casuale[1]<=31)
                printf(" Privato");
            else
                printf(" Pubblico");
        }
        else if(ip_casuale[0] <= 223) {
            printf(" Classe C");
            if(ip_casuale[0]==192 && ip_casuale[1]==168)
                printf(" Privato");
            else
                printf(" Pubblico");
        }
        else if(ip_casuale[0] <= 239)
            printf(" Classe D Multicast");
        else
            printf(" Classe E Riservato");
    }

    return 0;
}
