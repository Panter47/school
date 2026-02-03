unsigned int somma_numeri(unsigned int num) {

	if(num>0) {
		return (num+somma_numeri(num-1));
	}
	else {
		return 0;
	}
}

unsigned int somma_numeri_inte(float num){

    if(num!=0){
        return (num*(num+1)/2);
    }
    else {
        return 0;
    }
}


unsigned int somma_cifre(unsigned int num){

    unsigned int temp,n;

    if (num!=0)
    {
        temp=num%10;
        n=num/10;
        return (temp+somma_cifre(n));
    }
    else{
        return 0;
    }
}



