public class Interfaccia {
    // è la classe dove verà inizializzata l'interfaccia
    private String nome;
    private int[] indirizzo;
    private int[] maschera;
    
    public Interfaccia(String nome, int[] indirizzo, int[] maschera) {
        this.nome = nome;
        setIndirizzo(indirizzo);
        setMaschera(maschera);
    }

        /**
         * controlla che il valore inserito sia compreso tra 0 e 255
         * @param valori devono esser 4 e compresi tra 0 e 255
         * @param nomeCampo serve per indicare all'utente quale a che categoria appartiene il campo che a sbagliato a compilare
        */
    private void validaArray(int[] valori, String nomeCampo) {
        if (valori == null || valori.length != 4) {
            throw new IllegalArgumentException(nomeCampo + " deve avere esattamente 4 valori.");
        }
        for (int v : valori) {
            if (v <= 0 || v >= 255) {
                throw new IllegalArgumentException(nomeCampo + " contiene un valore non valido: " + v + " (deve essere tra 0 e 255).");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(int[] indirizzo) {
        validaArray(indirizzo, "indirizzo");
        this.indirizzo = indirizzo;
    }

    public int[] getMaschera() {
        return maschera;
    }
    
    public void setMaschera(int[] maschera) {
        validaArray(maschera, "maschera");
        this.maschera = maschera;
    }

    
    
}
