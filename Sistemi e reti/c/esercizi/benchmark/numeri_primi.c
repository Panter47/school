#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#define N 1000000
#define DIM 100000000

unsigned long long arrayera[N];
unsigned long long arrayprim[DIM]={0};


//funzione numeri primi con metodo standard 
unsigned long long isPrimo(unsigned long long n){
    unsigned long long i;

	if (n>=1 && n<=3) {
		return 1;
	}

	if (n % 2 == 0)
		return 0; /* no perche' numeri pari */

	for(i=3; i <= (int)sqrt(n); i += 2)
		if (n % i == 0)
			return 0; /* no, perche' e' stato trovato */

	return 1;

}

//funzione numeri primi con metodo crivello di eratostene
void crivello_eratostene(unsigned long long indice)
{
	unsigned long long j,k;
	//controlla che il numero non sia già un multiplo di un'altro
	if (arrayera[indice]==indice)
	{
		for (j=2;j<N;j++)
		{
			//trova tutti i multipli di un numero al suo posto gli mette 0 come valore
			if(indice*j<N)
			{
				k=indice*j;
				arrayera[k]=0;
			}
		}
	}
}

int main() {

	clock_t start = clock();	
	unsigned long long i,j=0,f;
	
	//usa le funzione isPrimo e se il numero è primo lo aggiunge all'arrayprim
	for(i=2;i<N;i+=1){
		f=0;
		f=isPrimo(i);
		if(f==1){
			arrayprim[j]=i;
			j++;
		}
	}
	
	clock_t end = clock();
	double time_spend=(double) (end-start)/CLOCKS_PER_SEC;
	printf("il tempo di processo e' %fsecondi",time_spend);
	printf("\n i numeri primi sono' %I64d",j);


	clock_t start2= clock();
	
	for (i=0;i<N;i++)
	{
		arrayera[i]=i;
	}
	
	//chiama la funzione crivello_eratostene per ogni numero fino a N
	for (i=2;i<N;i++)
	{
		crivello_eratostene(i);
	}
	
	//tiene conta quanti numeri non sono stati cancellati (tutti i numeri non primi) 
	j=-1;
	for (i=0;i<N;i++)
	{
		if (arrayera[i]!=0)
		{
			j++;
		}
	}
	
	clock_t end2 = clock();
	double time_spend2=(double) (end2-start2)/CLOCKS_PER_SEC;
		printf("\nil tempo di processo e' %fsecondi",time_spend2);
		printf("\n i numeri primi sono' %I64d",j);
	return 0;
}