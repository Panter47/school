import java.util.ArrayList;

public class Progetto {
    
    private ArrayList<Dipendenti> progetto;

    public Progetto() {
        this.progetto = new ArrayList<>();
    }

    public void aggiungiDipendente(Dipendenti dipendente) {
        progetto.add(dipendente);
    }

    public void rimuoviDipendente(Dipendenti dipendente) {
        progetto.remove(dipendente);
    }

    public double calcolaCostoTotale(int ore) {
        double costoTotale = 0.0;
        for (Dipendenti dipendente : progetto) {
            costoTotale += dipendente.costo(ore);
        }
        return costoTotale; 
    }
    



}
