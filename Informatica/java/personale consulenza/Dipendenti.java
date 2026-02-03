public abstract class Dipendenti {
    protected int codice;
    protected String cognome;
    protected String nome;
    protected int anno;
    
    public Dipendenti(int codice, String cognome, String nome, int anno) {
        this.codice = codice;
        this.cognome = cognome;
        this.nome = nome;
        this.anno = anno;
    }

    public abstract double costo(int ore);

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }


    
}
