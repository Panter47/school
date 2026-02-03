import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RegistroSpese registro1 = new RegistroSpese(0);

        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 1, 10), 100, "alimentari", "carta"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 1, 12), 50, "trasporto", "contanti"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 1, 15), 200, "svago", "bonifico"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 1, 18), 150, "istruzione", "carta"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 1, 20), 75, "altro", "contanti"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 2, 1), 120, "alimentari", "bonifico"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 2, 5), 60, "trasporto", "carta"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 2, 7), 90, "svago", "contanti"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 2, 10), 130, "istruzione", "bonifico"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 2, 12), 40, "altro", "carta"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 3, 1), 110, "alimentari", "contanti"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 3, 3), 55, "trasporto", "bonifico"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 3, 6), 210, "svago", "carta"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 3, 9), 140, "istruzione", "contanti"));
        registro1.aggiungiSpesa(new Spesa(LocalDate.of(2025, 3, 12), 65, "altro", "bonifico"));
        

        System.out.println(registro1);

        System.out.println("il totale della spesa è "+registro1.spesaTot());
        System.out.println("la spesa media è di "+ registro1.spesaMedia());
        System.out.println("la spesa massima è di "+registro1.spesaMax()+" e quella minima di "+registro1.spesamin());
        System.out.println("la categoria con la spesa media più alta è "+registro1.catMediaMax()+" quella con la spesa media più bassa è "+registro1.catMediamin());
        System.out.println("il pagamento con la spesa totale più alta è "+registro1.pagTotMax()+" e quella con il totale più basso è "+registro1.pagTotMin());

    }

}
