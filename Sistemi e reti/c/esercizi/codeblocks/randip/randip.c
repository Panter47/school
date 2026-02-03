#include <stdint.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>
#include "randip.h"

char classe='N';
unsigned char ip_subnet[4] = {0,0,0,0};
unsigned char ip_casuale[4];
char mask=0;

int parse_cli(int argc, char* argv[]){
    //gestione caso in cui non viene messo niente o non viene specificato il numero di ip casuali
    if(argc == 1 || strcmp(argv[1],"-n")==0) {
        return 1;
    }
    else if(argc == 2) {
        //presa del numero di ip casuali da fare
        int i=2;
        char* temp= argv[1];
        int num=0;
        if(temp[0]=='-' && temp[1]=='n') {
            while(1) {
                if(temp[i] =='\0' || temp[i]=='\n') {
                    return num;
                }
                else {
                    num=num*10+(temp[i]-0x30);
                    i++;
                }
            }
        }
        else {
            return -1;
        }
    }
    //presa dell'help
    else if(strcmp(argv[1],"-h")==0) {
        return -1;
    }
    else if(argc == 3) {
        //presa del numero di ip casuali da fare
        int i=2;
        char* temp= argv[1];
        uint16_t num=0;
        if(temp[0]=='-' && temp[1]=='n') {
            while(1) {
                if(temp[i] =='\0') {
                    break;
                }
                else {
                    num=num*10+(temp[i]-0x30);
                    i++;
                }
            }
        }
        else {
            return -1;
        }
        //presa della classe
        temp = argv[2];
        if(temp[0] == '-' && temp[1] =='c'){
            classe=temp[2];
            return num;
        }
        //presa del netID e della maschera
        else if(temp[0] =='-' && temp[1] =='i'){
            i=1;
            for(int k=0;k<4;k++) {
                while(temp[++i]!='.' && temp[i]!='/') {
                    ip_subnet[k]=ip_subnet[k]*10+(temp[i]-0x30);
                }
            }
            i++;
            if(temp[i+1]=='\0' || temp[i+1]=='\n')
                mask=temp[i]-0x30;
            else
                mask=(temp[i]-0x30)*10+(temp[i+1]-0x30);

            return num;
        }
        else {
            return -1;
        }
    }
    else {
        return -1;
    }
}

void generate_ip() {

    if(mask==0) {
        //ip random senza specificare la classe
        if(classe =='N'){
            for(int i=0;i<4;i++){
                ip_casuale[i]=rand()%256;
            }
        }
        //ip random specificando la classe
        else if(classe == 'A'){
            ip_casuale[0]=rand()%128;
            for(int i=1;i<4;i++){
                ip_casuale[i]=rand()%256;
            }
        }else if(classe == 'B'){
            ip_casuale[0]=(rand()%64)+128;
            for(int i=1;i<4;i++){
                ip_casuale[i]=rand()%256;
            }

        }else if(classe == 'C'){
            ip_casuale[0]=(rand()%32)+192;
            for(int i=1;i<4;i++){
                ip_casuale[i]=rand()%256;
            }
        }else if(classe == 'D'){
            ip_casuale[0]=(rand()%16)+224;
            for(int i=1;i<4;i++){
                ip_casuale[i]=rand()%256;
            }

        }else if(classe == 'E'){
            ip_casuale[0]=(rand()%16)+240;
            for(int i=1;i<4;i++){
                ip_casuale[i]=rand()%256;
            }
        }
    }
    else {
        //separazione della maschera negli otteti
        int n=mask;
        unsigned char mask_ip[4];
        for (int i = 0; i < 4; i++) {
            if (n >= 8) {
                mask_ip[i] = 255;
                n -= 8;
            } else if (n > 0) {
                mask_ip[i] = (unsigned char)(0xFF << (8 - n));
                n = 0;
            } else {
                mask_ip[i] = 0;
            }
        }
        for (int i = 0; i < 4; i++) {
                //generazione ip casuale secondo la maschera
                unsigned char min_host = ip_subnet[i] & mask_ip[i];
                unsigned char max_host = min_host | (~mask_ip[i] & 0xFF);
                ip_casuale[i] = min_host + (rand() % (max_host - min_host + 1));
            }

    }
}

void print_help() {
    printf("\t\t===HELP===\n");
    printf("-n \tspecifica il numero di ip casuali\n");
    printf("\t-c \tspecifica la classe degli ip\n");
    printf("\t-i \tspeficica la netID e la CIDR\n");
}
