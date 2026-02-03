public class CD {
    
    public String titolo;
    public String autore;
    public int numbrani;
    public double durata;

    public CD(String titolo, String autore, int numbrani, double durata){
        this.titolo=titolo;
        this.autore=autore;
        this.numbrani=numbrani;
        this.durata=durata;
    }

    public String compareDurata(CD cd1,CD cd2){
        if(cd1.durata > cd2.durata && cd1.durata > this.durata)
            return "il cd di " +cd1.autore+" è quello che dura di più con una durata di "+cd1.durata+" minuti";
        else if(cd2.durata > cd1.durata && cd2.durata > this.durata)
            return "il cd di " +cd2.autore+" è quello che dura di più con una durata di "+cd2.durata+" minuti";
        return "il cd di " +this.autore+" è quello che dura di più con una durata di "+this.durata+" minuti";
    }

    public String toString() {
        return "titolo= "+ titolo + " autore= "+ autore + " numero di brani= "+ numbrani + " durata= "+ durata +" minuti";
    }

    /*public static void main(String[] args) {
        CD cd1=new CD("bella", "gims", 20, 70.26);
        CD cd2=new CD("Pastore","Stromae",13,59.15);
        CD cd3=new CD("viaggio","bellofigo",35,92.35);


        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);

        System.out.println(cd3.compareDurata(cd1, cd2));
        
    }*/
}
