public class Es2 {
    public static void main(String[] args) {
        int[] array1 ={1,5,7,8,9,10,15,18};
        int[] array2 ={2,3,4,6,11,12,14,16,20};
        int[] array3 = new int[17];

        int a=0;
        int b=0; 
        int c=0;
        while(c<=16){
            
            if(a<8 && array1[a]<array2[b]){
                array3[c]=array1[a];
                c++;
                a++;
            }
            else{
                array3[c]=array2[b];
                c++;
                b++;
            }
        }
        for(int k: array3)
            System.out.print(k+"-");
        

    }
    
}
