#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct frame
{
    char dest[18];
    char src[18];
    char arp[5];
    char payload[4501];

};


int main()
{
    char input[1514]= {0};
    char temp[3]= {'\0'};
    struct frame f1;
    f1.dest[0] = '\0';
    f1.src[0] = '\0';
    f1.arp[0] = '\0';
    f1.payload[0] = '\0';
    int k=-1,x=0,j=0,i=0,flag=0;
    do {
        printf("Inserisci frame in esadecimale (byte separati da spazi o contigui):\n");
        scanf(" %[^\n]",input);

        //tolgo gli spazi da dentro la stringa
        while (input[x] != '\0')
        {
            if (input[x] != ' ')
            {
                input[j++] = input[x];
            }
            x++;
        }
        input[j] = '\0';

        // calcolo la lunghezza della stringa
        int len=strlen(input);

        //divido nei vari pezzi del frame
        if((len>=14 && len-14 <=1500) && len%2==0)
        {
            while(input[i]!='\0')
            {
                if(k==-1)
                {
                    //destinazione
                    for(int z=0; z<6; z++)
                    {
                        temp[0]=input[i];
                        temp[1]=input[++i];
                        strcat(f1.dest,temp);
                        i++;
                        if(z<5)
                            strcat(f1.dest,":");

                    }
                    //sorgente
                    for(int z=0; z<6; z++)
                    {
                        temp[0]=input[i];
                        temp[1]=input[++i];
                        strcat(f1.src,temp);
                        i++;
                        if(z<5)
                            strcat(f1.src,":");

                    }
                    //ethertype
                    for(int z=0; z<2; z++)
                    {
                        temp[0]=input[i];
                        temp[1]=input[++i];
                        strcat(f1.arp,temp);
                        i++;
                    }
                    k++;
                }
                else
                {
                    //payload
                    k++;
                    temp[0]=input[i++];
                    temp[1]=input[i++];
                    strcat(f1.payload,temp);
                    strcat(f1.payload," ");

                }
            }

            printf("=== FRAME ETHERNET DECODIFICATO ===\n");
            printf("Destinazione: %s\n",f1.dest);
            printf("Sorgente    : %s\n",f1.src);
            printf("EtherType   : 0x%s\n",f1.arp);
            printf("Payload size: %d Byte\n\n",k);
            printf("Payload (esadecimale/ASCII):\n %s",f1.payload);
            printf("\n---------------------------------------------\n");
            printf("Frame totale: %d byte",k+14);
            flag=1;
        }
        else
        {
            printf("input non valido.\n\n");
        }
    } while(flag==0);




    return 0;
}
