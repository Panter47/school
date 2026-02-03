public class Funzionari extends Dipendenti {

    private int pagSenior = 85;
    private int pagJunior = 75;

    public Funzionari(int codice, String cognome, String nome, int anno) {
        super(codice, cognome, nome, anno);
    }

    @Override
    public double costo(int ore) {
        if(2026-this.getAnno()>10)
            return this.getPagSenior()*ore;
        return this.getPagJunior()*ore;
    }

    public int getPagSenior() {
        return pagSenior;
    }

    public void setPagSenior(int pagSenior) {
        this.pagSenior = pagSenior;
    }

    public int getPagJunior() {
        return pagJunior;
    }

    public void setPagJunior(int pagJunior) {
        this.pagJunior = pagJunior;
    }

    
    
}
