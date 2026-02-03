#include <stdio.h>
#include <string.h>
#include <stdlib.h>
//#include "htoi.inc"  // funzione htoi()

typedef struct {
    int porta;
    unsigned char MACs[6];
    unsigned char MACa[6];
} TRAFFICO; TRAFFICO* pt0; TRAFFICO* pt;

typedef struct {
    int porta;
    unsigned char MAC[6];
    int age;
} FILTERING; FILTERING* pf0; FILTERING* pf;

int FromMACtosByte(char* szmac, int offs, int idx);
int isMACequal(unsigned char* mac1, unsigned char* mac2);

int htoi(char* strnum) {
    int value = 0; char *p;
    p= strnum;
    while(*p){
        if(*p >= '0' && *p <='9') value = value *16 + *p -'0';
        else value =value * 16 +*p -'a' +10;
        p++;
    }
    return value;
}

FILE* apriFile(char* nomeFile) {
    FILE* fp;

    fp = fopen(nomeFile, "r");
    if (fp == NULL) {
        printf("Errore: impossibile aprire il file %s\n", nomeFile);
        return NULL;
    }

    return fp;
}

int main (int argc, char* argv[])
{
    FILE *fp;
    int i,j, nT, nF;
    char szRiga[80];
    char* nomeFile;

    if (argc > 1) {
        nomeFile = argv[1];
    } else {
        nomeFile = "traffic.txt";
    }

    fp = apriFile(nomeFile);
    if (fp == NULL) return 1;

    printf("%s\n...............................................\n",nomeFile);
    i = 0;
    fgets(szRiga, 80, fp); printf("%s",szRiga);
    while ( fgets(szRiga, 80, fp) != NULL )
    {
        printf("%s",szRiga);
        if (szRiga[0])
        {
            if (i==0) { pt0 = malloc(sizeof(TRAFFICO)); pt = pt0;}
            else { pt0 = realloc(pt0,(i+1)*sizeof(*pt0)); pt = pt0+i;}

            pt->porta = szRiga[0]-'0';
            for (j=0; j<6;j++)
            {
                pt->MACs[j]=(unsigned char)FromMACtosByte(szRiga,2,j);
                pt->MACa[j]=(unsigned char)FromMACtosByte(szRiga,20,j);
            }
            i++; nT = i;
        }
    }
    fclose (fp);

    printf("\nLearning e forwarding\n...............................................\n");
    nF = 0;
    for (i=0;i<nT;i++)
    {
        int trovato;

        trovato = 0;
        for (j=0;j<nF;j++)
        {
            if ((pf0+j)->porta==(pt0+i)->porta)
            {
                if (isMACequal((pf0+j)->MAC,(pt0+i)->MACs))
                {
                    trovato = 1;
                    break;
                }
            }
        }

        if (!trovato)
        {
            if (nF==0) { pf0 = malloc(sizeof(*pf0)); pf = pf0;}
            else { pf0 = realloc(pf0,(nF+1)*sizeof(*pf0)); pf = pf0+nF;}
            nF++;

            pf->porta = (pt0+i)->porta;
            memcpy(pf->MAC,(pt0+i)->MACs,sizeof(pf->MAC));
        }

        trovato = 0;
        for (j=0;j<nF;j++)
        {
            if (isMACequal((pf0+j)->MAC,(pt0+i)->MACa))
            {
                printf("\nTrama ricevuta su %d -> %d",(pt0+i)->porta,(pf0+j)->porta);
                trovato = 1;
            }
        }

        if (!trovato)
        {
            printf("\nTrama ricevuta su %d -> broadcast su ",(pt0+i)->porta);
            for (j=1; j<3; j++)
                if (j!=(pt0+i)->porta) printf("%d ",j);
        }
    }

    printf("\n\nFiltering database\n...............................................\n");
    for (i=0;i<nF;i++)
    {
        printf("\nP: %d MAC: %02X %02X %02X %02X %02X %02X",(pf0+i)->porta,
                (pf0+i)->MAC[0],(pf0+i)->MAC[1],(pf0+i)->MAC[2],
                (pf0+i)->MAC[3],(pf0+i)->MAC[4],(pf0+i)->MAC[5]);
    }

    free(pt0);
    free(pf0);
    return 0;
}

int FromMACtosByte(char* szmac, int offs, int idx)
{
    char szByte[3];

    szByte[0]=szmac[offs+idx*3];szByte[1]=szmac[offs+idx*3+1];szByte[2]=0;
    return htoi(szByte);
}

int isMACequal(unsigned char* mac1, unsigned char* mac2)
{
    int i;

    for (i=0;i<6;i++)
    {
        if (*mac1!=*mac2) return 0;
        mac1++; mac2++;
    }
    return 1;
}
