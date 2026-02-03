import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AritmeticaDate {
    public static void main(String[] args) {
        // Creiamo due date
        LocalDate dataInizio = LocalDate.of(2025, 1, 10);
        LocalDate dataFine = LocalDate.now();  // data di oggi

        // 1️⃣ Calcolo differenza in giorni
        long giorniTra = ChronoUnit.DAYS.between(dataInizio, dataFine);
        System.out.println("Giorni tra le due date: " + giorniTra);

        // 2️⃣ Aggiungere o sottrarre giorni, mesi, anni
        LocalDate piuDieciGiorni = dataInizio.plusDays(10);
        LocalDate menoDueMesi = dataFine.minusMonths(2);

        System.out.println("Data di inizio + 10 giorni: " + piuDieciGiorni);
        System.out.println("Data di fine - 2 mesi: " + menoDueMesi);

        // 3️⃣ Differenza in mesi o anni
        long mesiTra = ChronoUnit.MONTHS.between(dataInizio, dataFine);
        long anniTra = ChronoUnit.YEARS.between(dataInizio, dataFine);

        System.out.println("Mesi tra le due date: " + mesiTra);
        System.out.println("Anni tra le due date: " + anniTra);

        // 4️⃣ Confronto tra date
        if (dataFine.isAfter(dataInizio)) {
            System.out.println("La data di fine è successiva alla data di inizio.");
        }
    }
}