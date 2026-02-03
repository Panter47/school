import java.util.*;

public class CD {
    private String titolo;
    private String autore;
    private int nbrani;
    private double durata;

    public CD(String titolo, String autore, int nbrani, double durata){
        this.titolo = titolo;
        this.autore = autore;
        this.nbrani = nbrani;
        this.durata = durata;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    public void setAutore(String autore){
        this.autore = autore;
    }

    public void setNbrani(int nbrani){
        this.nbrani = nbrani;
    }

    public void setDurata(double durata){
        this.durata = durata;
    }

    public String getTitolo(){
        return this.titolo;
    }

    public String getAutore(){
        return this.autore;
    }

    public int getNbrani(){
        return this.nbrani;
    }

    public double getDurata(){
        return this.durata;
    }

    public String toString(){
        return "Autore: " + this.autore + "\nTitolo: " + this.titolo + "\nNumero brani: " + this.nbrani + "\nDurata: " + this.durata;
    }

    public double compareDurata(CD cd){
        return Math.abs(this.durata - cd.getDurata());
    }

    public static void main(String[] args){
        CD cd1 = new CD("Double White", "Beatles", 20, 45.40);
        CD cd2 = new CD("Sg Pepper", "Beatles", 13, 38.5);
        
        CD vDischi[] = new CD[2];
        vDischi[0] = cd1;
        vDischi[1] = cd2;
        
        ArrayList<CD> aDischi = new ArrayList<CD>();
        aDischi.add(cd1);
        aDischi.add(cd2);
        
        for(CD cd : vDischi)
        	System.out.println(cd);
        	
        System.out.println("\n");
        	
        for(CD cd : aDischi)
        	System.out.println(cd);
    }
}