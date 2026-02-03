public class contaArray {

    public static void main(String[] args) {
        

        char[] array1={'a','b','c','i','e','f','u','a','e','a','k','l','e','n','o','p','a','r','s','u'};
        int[] array2= new int[5];

        
       for( int k: array1){
        switch (k) {
            case 'a':
                array2[0]++;
                break;
            case 'e':
                array2[1]++;
                break;
            case 'i':
                array2[2]++;
                break;
            case 'o':
                array2[3]++;
                break;
            case 'u':
                array2[4]++;
                break;
        
            default:
                break;
        }
}

        for(int j: array2)
			System.out.println(j);


    }
    
}


