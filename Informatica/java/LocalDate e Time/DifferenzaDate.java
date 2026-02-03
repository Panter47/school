import java.time.*;
import java.time.temporal.ChronoUnit;
public class DifferenzaDate
{
	public static void main(String[] args) {
	    LocalDate oggi = LocalDate.now();
        LocalDate data = LocalDate.of(1969, 8, 15); // festival Woodstock

		/* Differenza date con Period.between
		 * Period non restituisce il numero totale di giorni, bensì la differenza “calendaria” 
		 * (anni/mesi/giorni), quindi non è adatto se serve un numero totale di giorni.
		*/
		Period period = Period.between(data, oggi);
        System.out.println(period.getDays());
		System.out.println(period.getMonths());
		System.out.println(period.getYears());

		// Differenza date con Duration per calcolare il totale in giorni 
		Duration duration = Duration.between(oggi.atStartOfDay(), data.atStartOfDay()); 
		System.out.println(duration.toDays());

		// Differenza date con ChronoUnit.DAYS per calcolare il totale in giorni
		long differenzaGiorni = ChronoUnit.DAYS.between(oggi, data);
		System.out.println(differenzaGiorni);
	}
}