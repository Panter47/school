#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    FILE *arp_table=fopen("arp_table.txt","w");

    //controllo che non ci sia stato un errore nel creare il file
    if(arp_table ==NULL)
    {
        printf("errore di apertura file.");
        return 0;
    }
    //faccio inserire la coppia ip-mac e la salvo nel file txt
    int flag=0;
    do{
        char ip_mac[50];
        printf("inserire la coppia ip-mac: ");
        fgets(ip_mac,sizeof(ip_mac),stdin);

    if(strcmp(ip_mac,"fine\n")== 0 || strcmp(ip_mac,"FINE\n")==0){//controllo per uscire dal ciclo
        flag++;
    }
    else{
        fprintf(arp_table,"%s\n",ip_mac);
    }

    }while(flag!=1);

    fclose(arp_table);
    printf("chiusura del file\n");

    //lettura del file txt e stampa a schermo
    arp_table=fopen("arp_table.txt","r");
    if(arp_table ==NULL){//controllo apertura file
        printf("errore di apertura file.");
        return 0;
    }
    char line[50];
    while(fgets(line,sizeof(line),arp_table) != NULL){
        printf("%s",line);
    }
    fclose(arp_table);
	
	//pulisco il buffer
	int ch;
	while ((ch = getchar()) != '\n' && ch != EOF);
	getchar();


    return 0;
}
