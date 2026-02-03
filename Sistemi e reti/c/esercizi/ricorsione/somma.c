#include <stdio.h>

int somma_numeri(int num) {
	
	if(num>0) {
		return (num+somma_numeri(num-1));
	}
	else {
		return 0;
	}	
}


int main() {
	
	int num;
	printf("inserisci un numero: ");
	scanf("%d",&num);
	
	printf("la somma dei numeri prima di %d e' %d",num,somma_numeri(num));
	
	return 0;
}