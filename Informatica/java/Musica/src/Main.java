import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LibreriaMusicale playlist = new LibreriaMusicale();
		
		playlist.aggiungiBrano(new Brano("Position", "Franglish", "pop", 141, LocalDate.of(2024, 2, 16), 98));
		playlist.aggiungiBrano(new Brano("Blinding Lights", "The Weeknd", "pop", 200, LocalDate.of(2020, 11, 29), 87));
		playlist.aggiungiBrano(new Brano("drivers license", "Olivia Rodrigo", "pop", 242, LocalDate.of(2021, 1, 8), 65));
		playlist.aggiungiBrano(new Brano("Levitating", "Dua Lipa", "pop", 203, LocalDate.of(2020, 3, 27), 29));
		playlist.aggiungiBrano(new Brano("Peaches", "Justin Bieber", "r&b", 198, LocalDate.of(2021, 3, 19), 54));
		playlist.aggiungiBrano(new Brano("MONTERO", "Lil Nas X", "rap", 137, LocalDate.of(2021, 3, 26), 76));
		playlist.aggiungiBrano(new Brano("Industry Baby", "Lil Nas X", "rap", 213, LocalDate.of(2021, 7, 23), 33));
		playlist.aggiungiBrano(new Brano("Smoke on the Water", "Deep Purple", "rock", 340, LocalDate.of(1972, 3, 1), 21));
		playlist.aggiungiBrano(new Brano("Sandstorm", "Darude", "elettronica", 230, LocalDate.of(2000, 6, 15), 48));
		playlist.aggiungiBrano(new Brano("Take Five", "Dave Brubeck", "jazz", 324, LocalDate.of(1959, 9, 21), 12));
		playlist.aggiungiBrano(new Brano("Ain't No Sunshine", "Bill Withers", "soul", 150, LocalDate.of(1971, 7, 8), 39));
		playlist.aggiungiBrano(new Brano("Jolene", "Dolly Parton", "country", 160, LocalDate.of(1973, 2, 4), 64));
		playlist.aggiungiBrano(new Brano("Bad Guy", "Billie Eilish", "pop", 194, LocalDate.of(2019, 3, 29), 91));
		playlist.aggiungiBrano(new Brano("Shape of You", "Ed Sheeran", "pop", 233, LocalDate.of(2017, 1, 6), 77));
		playlist.aggiungiBrano(new Brano("Lose Yourself", "Eminem", "rap", 326, LocalDate.of(2002, 10, 28), 58));
		playlist.aggiungiBrano(new Brano("Lose Yourself", "Eminem", "rap", 326, LocalDate.of(2002, 10, 28), 58));

    
        playlist.getBrani().get(0).incrementaAscolti();
        playlist.getBrani().get(1).incrementaAscolti();
        playlist.getBrani().get(0).incrementaAscolti();
        playlist.getBrani().get(0).incrementaAscolti();
        playlist.getBrani().get(1).incrementaAscolti();
        playlist.getBrani().get(2).incrementaAscolti();
        
        System.out.println(playlist.contaBraniPerArtista("lil nas x"));
        System.out.println(playlist.braniPerGenere("pop"));
        System.out.println(playlist.durataMediaBrani());
        System.out.println(playlist.GetMinutiAscoltati());
        System.out.println(playlist.piuAscoltato());
        System.out.println(playlist.rimuoviBrani("montero", "lil nas x"));
        System.out.println(playlist.shuffleConSeed("pop", 700));

	}

}
