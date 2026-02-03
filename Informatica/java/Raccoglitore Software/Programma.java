public class Programma {
    private String denominazione;
    private String produttore;
    private int versione;
    private String sistemaOperativo;
    private int anno;

    public Programma(String denomizazione, String produttore, int versione, String sistemaOperativo, int anno){
        this.denominazione=denomizazione;
        this.produttore=produttore;
        this.versione=versione;
        this.sistemaOperativo=sistemaOperativo;
        this.anno=anno;
    }

        public String getDenominazione() {
        return denominazione;
    }

    public String getProduttore() {
        return produttore;
    }

    public int getVersione() {
        return versione;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public int getAnno() {
        return anno;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public void setVersione(int versione) {
        this.versione = versione;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String toString() {
        return "Denominazione: " + denominazione + ", Produttore: " + produttore + ", Versione: " + versione + ", Sistema Operativo: " + sistemaOperativo + ", Anno: " + anno;
    }

}
