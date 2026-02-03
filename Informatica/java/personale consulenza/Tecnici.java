public class Tecnici extends Dipendenti {

    private String specializzazione;
    private boolean interno;
    private int pagInf = 50;
    private int pagEl = 60;
    
    public Tecnici(int codice, String cognome, String nome, int anno, String specializzazione, boolean interno) {
        super(codice, cognome, nome, anno);
        this.specializzazione = specializzazione;
        this.interno = interno;
    }

    @Override
    public double costo(int ore) {
        if(this.getSpecializzazione().equalsIgnoreCase("informatica")){
            if(this.isInterno())
                return (this.getPagInf()+(2026-getAnno()))*ore;
            return this.getPagInf()*ore;
        }
        if(this.isInterno())
            return (this.getPagEl()+(2026-getAnno()))*ore;
            return this.getPagEl()*ore;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public boolean isInterno() {
        return interno;
    }

    public void setInterno(boolean interno) {
        this.interno = interno;
    }

    public int getPagInf() {
        return pagInf;
    }

    public void setPagInf(int pagInf) {
        this.pagInf = pagInf;
    }

    public int getPagEl() {
        return pagEl;
    }

    public void setPagEl(int pagEl) {
        this.pagEl = pagEl;
    }
    
    
}
