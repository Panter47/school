#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print_menu()
{
    printf("\n------MENU QUESTIONARIO------\n");
    printf("1. esegui il questionario\n");
    printf("2. aggiungi domanda al questionario\n");
    printf("3. rimuovi domanda al questionario\n");
    printf("0. esci dal questionario\n");
    printf("seleziona un'opzione: ");
}

int main()
{
    FILE *quest;
    int scelta;
    do
    {
        print_menu();

        scanf("%d",&scelta);
        switch(scelta)
        {
            case 1:
            {
                quest=fopen("questionario.txt","r");

                //controllo che non ci sia stato un errore nell'aprire il file
                if(quest == NULL)
                {
                    printf("errore di apertura file.");
                    return 0;
                }
                //somministro il questionario
                int cont=1,k=0;
                char line[200],soluzioni[20],risposte[20];
                while(fgets(line,sizeof(line),quest) != NULL)
                {
                    cont++;
                    //cotnrollo se è la rige ove è presente la soluzione e nel caso non la stampo
                    if(strcmp(line,"A\n")==0 || strcmp(line,"B\n")==0 || strcmp(line,"C\n")==0 || strcmp(line,"D\n")==0)
                    {
                        soluzioni[k]=line[0];
                        printf("scegliere tra A,B,C,D: ");
                        scanf("%s",&risposte[k++]);
                    }
                    else
                    {
                        printf("%s",line);
                    }
                }
                //calcolo il punteggio totale
                int punteggio=0;
                for(int i=0; i<(cont/6); i++)
                {
                    if(soluzioni[i]== risposte[i])
                    {
                        punteggio++;
                    }

                }
                fclose(quest);
                printf("\n hai totalizzato %d su %d risposte corrette\n",punteggio,cont/6);

                break;
            }
            case 2:
            {
                quest=fopen("questionario.txt","a");
                int flag=0;
                do
                {
                    //faccio inserire la domanda
                    char domanda[200];
                    printf("inserire il quesito: ");
                    scanf(" %[^\n]",domanda);
                    //controllo che non sia scritto fine per uscire dal aggiungere le domande
                    if(strcmp(domanda,"fine")==0 || strcmp(domanda,"FINE")==0)
                    {
                        flag++;
                    }
                    else
                    {
                        fprintf(quest,"%s\n",domanda);
                        //faccio inserire le risposte
                        for(int i=1; i<=4; i++)
                        {
                            printf("inserire la %d risposta: ",i);
                            scanf(" %[^\n]",domanda);

                            fprintf(quest,"%s\n",domanda);
                        }
                        //faccio inserire la soluzione
                        printf("inserisci l'opzione corretta (A o B o C o D): ");
                        scanf(" %[^\n]",domanda);
                        fprintf(quest,"%s\n\n",domanda);
                    }


                }
                while(flag!=1);
                fclose(quest);
                break;
            }
            case 3:
            {
                quest=fopen("questionario.txt","r");
                int cont=1,costante=1,num=1,elimina;
                char line[200];
                while(fgets(line,sizeof(line),quest)!= NULL)
                {
                    //faccio stampare a schermo solo le domande numerate
                    if(cont==costante)
                    {
                        costante+=7;
                        if(strlen(line)<50)
                        {
                            printf("%d)%s",num,line);
                        }
                        else
                        {
                            //nel caso la domanda sia più lunga di 50 caratteri la taglio e aggiungo "..."
                            line[strcspn(line,"\n")]='\0';//sostituisco il \n con uno spazio vuoto
                            printf("%d)%.48s...\n",num,line);
                            int ch;
                            while ((ch = fgetc(quest)) != '\n' && ch != EOF);//faccio arrivare line alla fine della frase cosi da evitare una stampa sulla riga successiva

                        }
                        num++;
                    }
                    cont++;

                }
                fclose(quest);
                printf("quale quesito cancellare?(scrivere il numero accanto il quesito): ");
                scanf("%d",&elimina);

                quest=fopen("questionario.txt","r");
                FILE *temp=fopen("temp.txt","w");

                //copio su un file temporaneo tutti i quesiti escluso quello da eliminare
                cont=1;
                while(fgets(line,sizeof(line),quest)!=NULL)
                {
                    if(cont==1+(7*(elimina-1)) || cont==2+(7*(elimina-1)) || cont==3+(7*(elimina-1)) || cont==4+(7*(elimina-1)) || cont==5+(7*(elimina-1)) || cont==6+(7*(elimina-1)) || cont==7+(7*(elimina-1)));
                    else
                    {
                        fprintf(temp,"%s",line);
                    }
                    cont++;
                }
                fclose(quest);
                fclose(temp);

                quest=fopen("questionario.txt","w");
                temp=fopen("temp.txt","r");
                // riscrivo il file "questionario.txt" con tutte le domande nuove esclusa quella eliminata
                while(fgets(line,sizeof(line),temp)!=NULL)
                {
                    fprintf(quest,"%s",line);
                }
                fclose(temp);
                fclose(quest);

                printf("\nil quesito %d e' stato eliminato\n",elimina);
                break;
            }
            case 0:
            {
                printf("-----------in uscita dal questionario------------");
                break;
            }
        }
    }while(scelta!=0);
    return 0;
}
