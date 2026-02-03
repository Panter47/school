#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    FILE *salva_ip=fopen("ip_list.txt","w"); // creo il file ip_list in scrittura

    //controllo che non ci sia stato un errore nel creare il file
    if(salva_ip ==NULL)
    {
        printf("errore di apertura file.");
        return 0;
    }

    //faccio inserire vari indirizzi ip finche non viene inserito fine
    int flag=0;
    do
    {
        char ip[16];
        printf("inserire l'ip: ");
        scanf("%s",ip);
        if(strcmp(ip,"fine")== 0 || strcmp(ip,"FINE")== 0)
        {
            flag++;
        }
        else{
            fprintf(salva_ip,"%s\n",ip);
        }
    }
    while(flag!=1);


    //chiudo il file
    fclose(salva_ip);
    printf("il file e' stato chiuso\n");


    salva_ip=fopen("ip_list.txt","r"); //apro il file in modalità lettura

    //controllo che non ci sia stato un errore nel creare il file
    if(salva_ip ==NULL)
    {
        printf("errore di apertura file.");
        return 0;
    }

    //il file viene stampato riga per riga
    char line[16];
    while(fgets(line,sizeof(line),salva_ip) !=NULL) {
        printf("%s",line);
    }
	
    fclose(salva_ip);
	//pulisco il buffer
	int ch;
	while ((ch = getchar()) != '\n' && ch != EOF);
	getchar();

    return 0;
}
