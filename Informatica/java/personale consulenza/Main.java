public class Main {
    public static void main(String[] args) {
        Dirigenti dirigente = new Dirigenti(1, "Rossi", "Mario", 2015);
        Funzionari funzionario1 = new Funzionari(2, "Bianchi", "Luigi", 2010);
        Funzionari funzionario2 = new Funzionari(6, "Russo", "Carla", 2018);
        Tecnici tecnico1 = new Tecnici(3, "Verdi", "Anna", 2020, "Informatica", true);
        Tecnici tecnico2 = new Tecnici(5, "Gialli", "Sara", 2012, "Informatica", false);
        Tecnici tecnico3 = new Tecnici(4, "Neri", "Paolo", 2018, "Elettronica", false);
        int ore = 10;

        System.out.println("Costo Dirigente: " + dirigente.costo(ore));
        System.out.println("Costo Funzionario1: " + funzionario1.costo(ore));
        System.out.println("Costo Funzionario2: " + funzionario2.costo(ore));
        System.out.println("Costo Tecnico1              : " + tecnico1.costo(ore));
        System.out.println("Costo Tecnico2: " + tecnico2.costo(ore));
        System.out.println("Costo Tecnico3: " + tecnico3.costo(ore));


        Progetto progetto = new Progetto();
        progetto.aggiungiDipendente(dirigente);
        progetto.aggiungiDipendente(funzionario1);
        progetto.aggiungiDipendente(funzionario2);
        progetto.aggiungiDipendente(tecnico1);
        progetto.aggiungiDipendente(tecnico2);
        progetto.aggiungiDipendente(tecnico3);

        System.out.println("Costo Totale Progetto: " + progetto.calcolaCostoTotale(ore));
    }
}