#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *mac=fopen("mac_list.txt","r");

    //controllo che non ci sia stato un errore nell'apertura del file
    if(mac ==NULL)
    {
        printf("errore di apertura file.");
        return 0;
    }

    int cont=0; //conto il numero di righe
    //stampa a schermo del file
    char line[19];
    while(fgets(line,sizeof(line),mac) != NULL){
        printf("%s",line);
        cont++;
    }
    printf("\nil numero di righe e' %d",cont);
    fclose(mac);
	
	//pulisco il buffer
	int ch;
	while ((ch = getchar()) != '\n' && ch != EOF);
	getchar();


    return 0;
}
