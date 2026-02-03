import java.util.ArrayList;

public class Raccoglitore {
    private ArrayList<Programma> cartella;

    public Raccoglitore(int N) {
        this.cartella = new ArrayList<Programma>(N);
        for (int i = 0; i < N; i++) {
            cartella.add(null);
        }
    }

    /**
     * restituisco il programma in base alla poszione
     * 
     * @param posizione
     * @return
     */
    public Programma getProgramma(int posizione) {
        if (posizione < 0 || posizione >= cartella.size())
            return null;
        return cartella.get(posizione);
    }

    /**
     * inserisco il programma all'interno della cartella
     * 
     * @param posizione
     * @param programma
     * @return
     */
    public String setProgramma(int posizione, Programma programma) {
        if (posizione < 0 || posizione >= cartella.size())
            return "Posizione fuori dalla cartella";
        if (cartella.get(posizione) != null)
            return "Posizione non disponibile";
        cartella.set(posizione, programma);
        return "Il programma è stato inserito correttamente";
    }

    /**
     * elimino il programma dalla cartella
     * 
     * @param posizione
     * @return
     */
    public String killProgramma(int posizione) {
        if (cartella.get(posizione) == null) {
            return "Nessun programma trovato";
        }
        cartella.remove(posizione);
        return "programma rimosso corettamente";
    }

    /**
     * dico quanti programmi sono presenti all'interno della cartella
     * 
     * @return
     */
    public int getN() {
        int n = 0;
        for (Programma k : cartella) {
            if (k != null) {
                n++;
            }
        }
        return n;
    }

    /**
     * cerco un programma all'interno della cartella tramite la denominazione
     * 
     * @param den
     * @return
     */
    public Programma cercaProgrammaPerDenominazione(String den) {
        for (Programma programma : cartella) {
            if (programma.getDenominazione().equals(den))
                return programma;
        }
        return null;
    }

    public String toString() {
        String stamp = "la cartella contiene: \n";
        for (Programma programma : cartella) {
            if (programma != null)
                stamp += programma.getDenominazione() + "\n";
        }
        return stamp;
    }

    /**
     * confronto 2 cartelle
     * 
     * @param p1
     * @return
     */
    public int confrontaContenitore(Raccoglitore p1) {
        int com = 0;

        for (Programma pr1 : this.cartella) {
            if (pr1 != null) {
                for (Programma pr2 : p1.cartella) {
                    if (pr2 != null) {
                        if (pr1.getDenominazione().equals(pr2.getDenominazione()))
                            com++;
                    }

                }
            }
        }
        return com;
    }
}
