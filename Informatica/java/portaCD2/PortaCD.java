import java.util.ArrayList;

public class PortaCD {
    private ArrayList<CD> contenitore;
    public PortaCD(int N) {
        this.contenitore = new ArrayList<CD>(N);
        for(int i=0; i<N; i++) {
            contenitore.add(null);
        }
    }
    /**
     * restituisco il CD in base alla sua posizione
     * @param posizione
     * @return
     */
    public CD getCD(int posizione) {
        return contenitore.get(posizione);
    }
    
    /**
     * inserisco un CD all'interno del portaCD
     * @param posizione
     * @param cd
     * @return
     */
    public String setCD(int posizione, CD cd) {
        if(posizione<0 || posizione>=contenitore.size()-1)
            return "Posizione fuori dal contenitore";
        if(contenitore.get(posizione)!=null)
            return "Posizione non disponibile";
        contenitore.set(posizione, cd);
        return "Il CD è stato inserito correttamente";
    }

    /**
     * rimove il cd di indice posizione
     * @param posizione
     * @return
     */
    public String killCD(int posizione) {
        if(contenitore.get(posizione)==null) {
            return "Nessun CD trovato";
        }
        contenitore.remove(posizione);
        return "CD rimosso corettamente";
    }
     /**
      * rimuove l'oggetto cd 
      * @param cd
      */
    public void killCD( CD cd) {
        contenitore.remove(cd);
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
    public CD cercaCDperTitolo(String tit) {
        for(CD cd : contenitore) {
            if(cd.titolo.equals(tit)) 
                return cd;
        }
        return null;
    }

    public String toString() {
        String stamp= "portaCD contiene: \n";
        for(CD cd : contenitore) {
            if(cd!= null)
                stamp+=cd.titolo + "\n";
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

        for(CD cd1 : this.contenitore) {
            if(cd1!=null) {
                for (CD cd2 : portaCD.contenitore) {
                    if(cd2!=null) {
                        if(cd1.titolo.equals(cd2.titolo))
                            com++;
                    }
                    
                }
            }
        }

        return com;
    }
}
