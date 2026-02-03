#include <stdio.h>

int main() {

int a,b,c,n;

printf("inserire il valore di numero massimo che devono avere i valori della terna pitagorica: ");
scanf("%d",&n);

for(a=1;a<n;a++)
{
	b=a
	for(b=a;b<n;b++)
	{
		for(c=a;c<n;c++)
		{
			if(a*a+b*b==c*c)
				printf("\nquesta e' una terna pitagorica trovata prima di %d  %d+%d=%d",n,a,b,c);
		}
	}
}

return 0;
}