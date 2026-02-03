import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.TextStyle;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Period;

public class LocalDateTimeDemo {
  public static void main(String[] args) {
    
  /*  LocalDate
     
    LocalDate è la classe che rappresenta le date locali senza ora.
		LocalDate contiene 2 costanti, MAX e MIN,
		che sono rispettivamente la più grande e la più piccola data rappresentabile.
		LocalDate.MAX è +999999999-12-31 e LocalDate.MIN è -999999999-01-01.

		Esempio:
	*/
    
    // Ottiene Data locale odierna
    LocalDate localDate1  = LocalDate.now();
    System.out.println(localDate1);
    // Crea una data
    LocalDate localDate2  = LocalDate.of(2018, Month.JANUARY, 13);
    System.out.println(localDate2);
    // 10000 giorni dopo il 1970-01-01 ("epoch day" (cioè il giorno 0 dell’epoca Unix))
    LocalDate localDate3  = LocalDate.ofEpochDay(10000);
    
    // Formattiamo data in italiano
    // Consultare https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html 
    // per varie possibilità di formattazione
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String s = localDate3.format(formatter);
    System.out.println(s);
    
  // Calcoliamo la differenza in numero giorni tra localDate2 (data oggi) e locaDate1
	// eventualmente
	// long differenzaGiorni = Period.between(localDate2, localDate1).getDays();
	Period p = Period.between(localDate2, localDate1);
	System.out.println("Differenza tra " + localDate1 + " e " + localDate2 + 
		               " = " + p.getDays() + " giorni e " + p.getMonths() + " mesi");
    
    /*
     	Il codice sopra genera questo output

      2018-02-25 (es.)
      2018-01-13
      19-05-1997
      Differenza tra 2018-02-25 e 2018-01-13 = 12 giorni e 1 mesi (es)
    */

	
	/*  Crea le date di Natale nei prossimi 5 anni. 
	    Mostra come combinare Year e MonthDay per ottenerne la data in LocalDate.
		  in pratica crea un MonthDay per 25 Dicembre e ottiene la combinazione con anno 
		  calcolato da inserire in LocalDate.
	*/

    MonthDay dec25 = MonthDay.of(Month.DECEMBER, 25);
    Year anno = Year.now();

    for (int i = 0; i < 5; i++) {
      // ottieni la data dell'anno + i del giorno 25 dicembre....
      LocalDate ld = anno.plusYears(i).atMonthDay(dec25);
      int annoCalcolato = ld.getYear();
      String giornoSettimana = ld.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
      System.out.format("Natale al %d è di %s.%n", annoCalcolato, giornoSettimana);
    }
	/* Il codice sopra genera questo output es:
	 
	 	Natale al 20xx è di martedì.
		Natale al 20xx è di mercoledì.
		Natale al 20xx è di venerdì.
		Natale al 20xx è di sabato.
		Natale al 20xx è di domenica.
	*/

	/*
		LocalTime
		
		LocalTime rappresenta l'ora senza data.
		Time è rappresentato con precisione al nanosecondo.
		La classe LocalTime contiene le costanti
		
		MIN = 00:00, MAX = 23:59:59.999999999, MIDNIGHT = 00:00, NOON = 12:00.
		
		esempio:
	*/

    // ora attuale
    LocalTime  localTime1 = LocalTime.now();
    System.out.println(localTime1);
    // 09:30
    LocalTime  localTime2 = LocalTime.of(9, 30);
    System.out.println(localTime2);
    // 09:30:50
    LocalTime  localTime3 = LocalTime.of(9, 30, 50);
    System.out.println(localTime3);
    // 09:30:50.000005678
    LocalTime  localTime4 = LocalTime.of(9, 30, 50, 5678);
    System.out.println(localTime4);

	/* Output
	 	11:21:21.830656300 (es.)
		09:30
		09:30:50
		09:30:50.000005678
	 */
	
	/*
		LocalDateTime
		LocalDateTime rappresenta sia la data che l'orario.
		
		esempio
	*/

    // Data ora attuali 
    LocalDateTime  localDateTime1 = LocalDateTime.now();
    System.out.println(localDateTime1);
    
    // 2014-06-21T16:12:34
    LocalDateTime  localDateTime2 = LocalDateTime.of(2014, Month.JUNE, 21, 16, 12, 34);
    System.out.println(localDateTime2);
    LocalDate localDate  = LocalDate.of(2014, 5, 10); 
    LocalTime  localTime= LocalTime.of(16, 18,   41);
    // combinare LocalDate con LocalTime
    LocalDateTime  localDateTime3 = LocalDateTime.of(localDate, localTime);
    System.out.println(localDateTime3);
  }
}
	/*
	 output
		2018-02-25T11:29:13.283112200
		2014-06-21T16:12:34
		2014-05-10T16:18:41
	 */