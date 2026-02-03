public class PortaCD {
    private CD[] contenitore;
    private int N;

    public PortaCD(int N) {
        this.N=N;
        contenitore = new CD[N];
    }
    /**
     * restituisco il CD in base alla sua posizione
     * @param posizione
     * @return
     */
    public CD getCD(int posizione) {
        return contenitore[posizione];
    }
    
    /**
     * inserisco un CD all'interno del portaCD
     * @param posizione
     * @param cd
     * @return
     */
    public String setCD(int posizione, CD cd) {
        if(posizione<0 || posizione>=N)
            return "Posizione fuori dal contenitore";
        if(contenitore[posizione]!=null)
            return "Posizione non disponibile";
        contenitore[posizione]=cd;
        return "Il CD è stato inserito correttamente";
    }

    /**
     * elimino un cd dal portaCD
     * @param posizione
     * @return
     */
    public String killCD(int posizione) {
        if(contenitore[posizione]==null) {
            return "Nessun CD trovato";
        }
        contenitore[posizione]=null;
        return "CD rimosso corettamente";
    }
    
    /**
     * dico quanti CD sono presenti all'interno del CD
     * @return
     */
    public int getN(){
        int n=0;
        for(CD k : contenitore){
            if (k!=null) {
                n++;
            }

        }
        return n;
    }

    /**
     * cerco un Cd nel portaCD per il titolo
     * @param tit
     * @return
     */
    public int cercaCDperTitolo(String tit) {
        for(int k=0; k<N;k++) {
            if(contenitore[k].titolo == tit) 
                return k;
        }
        return -1;
    }

    public String toString() {
        String stamp= "portaCD contiene: \n";
        for(int k=0;k<N; k++) {
            if(contenitore[k]!= null)
                stamp+=contenitore[k].titolo + "\n";
        }
        return stamp;
    }

    /**
     * confronto 2 PortaCD
     * @param portaCD
     * @return
     */
    public int confrontaCollezione(PortaCD portaCD) {

        int com=0;

        for( int k=0;k<this.N;k++) {
            if (this.contenitore[k]!= null){
                for(int j=0;j<N;j++) {
                    if (portaCD.contenitore[j]!=null) {
                        if(this.contenitore[k].titolo.equals(portaCD.contenitore[j].titolo))
                            com++;
                    }
                
                }
            
            }
        }
        return com;
    }

    public static void main(String[] args) {

        CD cd1 = new CD("Bella", "Gims", 12, 70.26);
        CD cd2 = new CD("Pastore", "Stromae", 10, 59.15);
        CD cd3 = new CD("Viaggio", "Bellofigo", 15, 92.35);
        CD cd4 = new CD("Notte", "Tiziano Ferro", 11, 65.50);
        CD cd5 = new CD("Sogni", "Vasco Rossi", 14, 80.20);
        CD cd6 = new CD("Amore", "Laura Pausini", 13, 75.10);
        CD cd7 = new CD("Festa", "Jovanotti", 16, 88.40);
        CD cd8 = new CD("Cuore", "Eros Ramazzotti", 12, 72.30);
        CD cd9 = new CD("Libertà", "Måneskin", 10, 60.50);

    
        PortaCD portacd1 = new PortaCD(5);

        System.out.println(portacd1.setCD(0, cd1));
        System.out.println(portacd1.setCD(1, cd2));
        System.out.println(portacd1.setCD(1, cd3));
        System.out.println(portacd1.setCD(2, cd4));
        System.out.println(portacd1.setCD(3, cd5));
        System.out.println(portacd1.getCD(0));;
        System.out.println(portacd1);
        System.out.println("Il numero di CD presenti all'interno del contitore è " + portacd1.getN());
        System.out.println("Il CD con titolo Notte si trova nella poszione " + portacd1.cercaCDperTitolo("Notte"));
        System.out.println(portacd1.killCD(2));
        System.out.println("Il numero di CD presenti all'interno del contitore è " + portacd1.getN());
        System.out.println(portacd1);

        PortaCD portacd2 = new PortaCD(5);

        System.out.println(portacd2.setCD(0, cd1)); 
        System.out.println(portacd2.setCD(1, cd6));
        System.out.println(portacd2.setCD(2, cd7));
        System.out.println(portacd2.setCD(3, cd8));
        System.out.println(portacd2.setCD(4, cd9));

        System.out.println("Il numero di CD presenti in entrambi in portaCD è " + portacd1.confrontaCollezione(portacd2));

}

}
