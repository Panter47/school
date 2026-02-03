public class Dirigenti extends Dipendenti{

    private int pagDirigente = 100;

    public Dirigenti(int codice, String cognome, String nome, int anno) {
        super(codice, cognome, nome, anno);
    }

    @Override
    public double costo(int ore) {
        return this.getPagDirigente()*ore;
    }

    public int getPagDirigente() {
        return pagDirigente;
    }

    public void setPagDirigente(int pagDirigente) {
        this.pagDirigente = pagDirigente;
    }

    
    
}
