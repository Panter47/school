#include <stdio.h>	// per le funzioni di printf
#include <stdlib.h>	// per le funzioni di srand e rand
#include <time.h>	//per la funzione time(NULL)

int main() {

srand(time(NULL));
	
int lanci,f,pos,j=1,i,facce,k,num;

printf("a quante facce si vuole il dado? ");
scanf("%d",&facce);

printf("quanti dadi si vogliono usare? ");
scanf("%d",&num);

printf("quanti lanci si vogliono eseguire? ");
scanf("%d",&lanci);

int dadi[num][facce];

for(i=0;i<num;i++)
	{
		
		for(j=0;j<lanci;j++)
		{
			dadi[i][j]=0;
			
		}
	}

for(i=0;i<=num;i++)
{
	for(k=0;k<lanci;k++)
	{
		pos=(rand()%facce)+1;
		dadi[i][pos]++;
	}
}

for(i=1;i<=num;i++)
{	
	j=1;
	for(k=0;k<facce;k++)
	{
		printf("\ndel dado numero %d e' uscito il numero %d e' uscito %d volte",i,k+1,dadi[i][k]);
		j++;
	}
}
	
return 0;
}