import java.time.LocalDate;

public class Main {
    
    public static void main(String[] args) {
        
        // Creazione oggetti
        Docente docente1 = new Docente("Mario Rossi", "M", LocalDate.of(1980, 5, 15), 1500.0, 0.0, 120);
        Impiegato impiegato1 = new Impiegato("Laura Bianchi", "F", LocalDate.of(1985, 8, 22), 1200.0, 0.0, 3);
        
        System.out.println("=== SITUAZIONE INIZIALE ===");
        System.out.println("DOCENTE: " + docente1);
        System.out.println("IMPIEGATO: " + impiegato1);
        System.out.println();
        
        // Calcolo straordinario
        System.out.println("=== CALCOLO STRAORDINARI ===");
        System.out.println("Straordinario docente (10 ore): €" + docente1.straordinario(10));
        System.out.println("Straordinario impiegato (15 ore): €" + impiegato1.straordinario(15));
        System.out.println();
        
        // Calcolo stipendio mensile
        System.out.println("=== STIPENDI MENSILI ===");
        System.out.println("Stipendio mensile docente: €" + docente1.stipendioMensile());
        System.out.println("Stipendio mensile impiegato: €" + impiegato1.stipendioMensile());
    }
}