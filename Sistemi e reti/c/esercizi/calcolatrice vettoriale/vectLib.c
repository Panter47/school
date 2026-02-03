#include "vectLib.h"
#include <stdio.h>
#include <time.h>
#include <stdlib.h>


// stampa a schermo del vettore
void print_vec(const double *v, size_t dim){
	
	printf("[ ");
	for(size_t i=0; i<dim; i++)
	{
		printf("%g, ",v[i]);
	}
	printf("]\n");	
}

//input del vettore

void scanf_vec(double *v, size_t dim){
	
	for(size_t i=0;i<dim;i++){
	scanf("%lf",&v[i]);
	}
}

//addizione del vettore
void add_vec(const double *v1, const double *v2, double *res, size_t dim){
	
	for(size_t i=0;i<dim;i++){
		
		res[i]=v1[i]+v2[i];
	}
}

//scalare vettore
void adds_vec(const double *v1, double k, double *res, size_t dim){
	
	for(size_t i=0;i<dim;i++){
		
		res[i]=v1[i]+k;
	}
}

// sottrazioni tra vettore
void sub_vec(const double *v1, const double *v2, double *res, size_t dim){
	
	for(size_t i=0;i<dim;i++){
		res[i]=v1[i]-v2[i];
	}
}

// prodotto scalare 2 vettori
double dot_vec(const double *v1, const double *v2, size_t dim){
	
	double res;
	
	for(size_t i=0;i<dim;i++){
		res+=v1[i]*v2[i];
	}
	return res;
}


void concat_vec(const double *v1, size_t dim1, const double *v2, size_t dim2, double *res){
	
	for(size_t i=0; i<dim1;i++){
		res[i]=v1[i];
	}
	for(size_t i=0;i<dim2;i++){
		res[dim1+i]=v2[i];
	}
}


void reverse_vec(double *v, size_t dim){
	
	double temp[dim];
	
	for(size_t i=0;i<dim;i++){
		temp[i]=v[i];
	}
	size_t k=0;
	for(int i=dim-1;i>-1;i--){
		v[k]=temp[i];
		k++;
	}
}


void sort_vec(double *v, size_t dim){
	
	double temp[dim];
	size_t indic;
	
	for(size_t k=0; k<dim;k++){
		double num=999999999999999;
		for (size_t i=0;i<dim;i++){
			if(v[i]<num && v[i]!=0){
				num=v[i];
				indic=i;
			}
		}
		v[indic]=0;
		temp[k]=num;
	}
	for(size_t i=0;i<dim;i++){
		v[i]=temp[i];
	}
}

/*void shuffle_vec(double *v, size_t dim){
	
	double temp[dim];
	
	for(size_t i=0;i<dim;i++){
		
}*/

/*void rshft_vec(double *v, size_t step, size_t dim){
	for(size_t i=0;i<dim;i++){
		v[i]=v[i]>>step;
	}
}*/

void zero_vec(double *v, size_t dim){
	
	for(size_t i=0;i<dim;i++){
		v[i]=0;
	}
}

double mean_vec(const double *v, size_t dim){
	
	double media=0;
	
	for(size_t i=0;i<dim;i++){
		media+=v[i];
	}
	
	return media=media/dim;
	
}

void rand_vec(int *v, size_t dim, int min, int max) {
    srand(time(NULL));
    for (size_t i = 0; i < dim; i++) {
        v[i] = rand() % max + min;
    }
}


double min_vec(const double *v, size_t dim) {
    double min = v[0];
    for (size_t i = 1; i < dim; i++) {
        if (v[i] < min) {
            min = v[i];
        }
    }
    return min;
}


double max_vec(const double *v, size_t dim) {
    double max = v[0];
    for (size_t i = 1; i < dim; i++) {
        if (v[i] > max) {
            max = v[i];
        }
    }
    return max;
}


// moltiplicazioni 2 vettori
void muls_vec(const double *v, double k, double *res, size_t dim){
	
	for(size_t i=0;i<dim;i++){
		res[i]=v[i]*k;
	}
}


double sum_vec(const double *v, size_t dim) {
    double sum = 0;
    for (size_t i = 0; i < dim; i++) {
        sum += v[i];
    }
    return sum;
}


