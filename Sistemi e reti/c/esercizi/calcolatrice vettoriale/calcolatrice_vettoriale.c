#include "vectLib.h"
#include "vectLib.c"
#include <stdio.h>
#define DIM 5

void print_menu() {
    printf("\n--- Calcolatrice Vettoriale ---\n");
    printf("1. Somma di due vettori\n");
    printf("2. Aggiunta di uno scalare a un vettore\n");
    printf("3. Sottrazione di due vettori\n");
    printf("4. Moltiplicazione di un vettore per uno scalare\n");
    printf("5. Prodotto scalare di due vettori\n");
    printf("6. Concatenazione di due vettori\n");
    printf("7. Inversione di un vettore\n");
    printf("8. Ordinamento di un vettore\n");
    printf("9. Mescolamento casuale di un vettore\n");
    printf("10. Shift a destra di un vettore\n");
    printf("11. Shift a sinistra di un vettore\n");
    printf("12. Rotazione a destra di un vettore\n");
    printf("13. Rotazione a sinistra di un vettore\n");
    printf("14. Slice di un vettore\n");
    printf("15. Calcolo della norma di un vettore\n");
    printf("16. Media degli elementi di un vettore\n");
    printf("17. Valore minimo di un vettore\n");
    printf("18. Valore massimo di un vettore\n");
    printf("19. Somma degli elementi di un vettore\n");
    printf("20. Confronto di due vettori con tolleranza\n");
    printf("21. Applicazione di una funzione a ogni elemento di un vettore\n");
    printf("0. Esci\n");
    printf("Seleziona un'opzione: ");
}




int main(){
	
	double v1[DIM], v2[DIM], res[DIM], scalare,risultato,media;
	int scelta,step;
	
	do{
		print_menu();
		scanf("%d",&scelta);
		
		switch(scelta) {
			case 1: {
				printf("inserisci %d valori nel primo vettore: ",DIM);
				scanf_vec(v1,DIM);
				printf("inserisci %d valori nel secondo vettore: ",DIM);
				scanf_vec(v2,DIM);
				add_vec(v1,v2,res,DIM);
				printf("il risultato della somma e': ");
				print_vec(res, DIM);
				break;
			}
			case 2: {
				printf("inserire %d valori nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				printf("inserire lo scalare: ");
				scanf("%lf", &scalare);
				adds_vec(v1,scalare,res,DIM);
				printf("la somma e': ");
				print_vec(res,DIM);
				break;	
			}
			case 3: {
				printf("inserire %d valori nel primo vettore: ",DIM);
				scanf_vec(v1,DIM);
				printf("inserire %d valori nel secondo vettore: ",DIM);
				scanf_vec(v2,DIM);
				sub_vec(v1,v2,res,DIM);
				printf("il risultato della sottrazione e': ");
				print_vec(res,DIM);
				break;	
			}
			case 4: {
				printf("inserire %d valori nel primo vettore: ",DIM);
				scanf_vec(v1,DIM);
				printf("inserire lo scalare: ");
				scanf("%lf", &scalare);
				muls_vec(v1,scalare,res,DIM);
				printf("il prodotto e': ");
				print_vec(res,DIM);
				break;
			}
			case 5: {
				printf("inserire %d valori nel primo vettore: ",DIM);
				scanf_vec(v1,DIM);
				printf("inserire %d valori nel secondo vettore: ",DIM);
				scanf_vec(v2,DIM);
				risultato=dot_vec(v1,v2,DIM);
				printf("il prodotto e': %lf",risultato);
				break;
			}
			case 6: {
				printf("inserire %d valori nel primo vettore: ",DIM);
				scanf_vec(v1,DIM);
				printf("inserire %d valori nel secondo vettore: ",DIM);
				scanf_vec(v2,DIM);
				concat_vec(v1,DIM,v2,DIM,res);
				size_t dim2=DIM+DIM;
				print_vec(res,dim2);
				break;
			}
			case 7: {
				printf("inserire %d valori nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				reverse_vec(v1,DIM);
				printf("ecco il vettore invertito: ");
				print_vec(v1,DIM);
				break;
			}
			case 8: {
				printf("inserire %d valori nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				sort_vec(v1,DIM);
				printf("ecco il vettore in ordine crescente: ");
				print_vec(v1,DIM);
				break;
			}
			case 9: {
				
			}
			case 10: {
				printf("inserire %d valori nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				printf("inserire di quando fare lo shift a destra: ");
				scanf("%d", &step);
				//rshft_vec(v1,step,DIM);
				print_vec(v1,DIM);
				break;
			}
			case 11: {
				
			}
			case 12: {
				
			}
			case 13: {
				
			}
			case 14: {
				
			}
			case 15: {
				
			}
			case 16: {
				printf("inserire %d valore nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				media=mean_vec(v1,DIM);
				printf("la media del vettore e': %lf",media);
				break;
			}
			case 17: {
				printf("inserire %d valori nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				double min=min_vec(v1,DIM);
				printf("il valore più piccolo e': %lf",min);
				break;
			}
			case 18: {
				printf("inserire %d valori nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				double max=max_vec(v1,DIM);
				printf("il valore più piccolo e': %lf",max);
				break;	
			}
			case 19: {
				printf("inserire %d valori nel vettore: ",DIM);
				scanf_vec(v1,DIM);
				double sum=sum_vec(v1,DIM);
				printf("il valore più piccolo e': %lf",sum);
				break;	
				
				
			}
			case 20: {
				
			} 
			case 21: {
			
			}
			case 0: {
				printf("uscita dalla calcolatrice.");
			}
		}
		
		
		
		
	} while(scelta!=0);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	return 0;
}