import java.util.ArrayList;
import java.util.Collections;

public class LibreriaMusicale {
	private ArrayList<Brano> brani;
	
	public ArrayList<Brano> getBrani() {
		return brani;
	}

	public LibreriaMusicale() {
		this.brani= new ArrayList<>();
	}
	
	public boolean aggiungiBrano(Brano b) {
		try {
		if(brani.contains(b) || b == null)
			throw new IllegalArgumentException("errore nell'aggiunta del brano");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		brani.add(b);
		return true;
	}
	
	public boolean rimuoviBrani(String titolo, String artista) {
		try {
			if(artista == null || titolo == null)
				throw new IllegalArgumentException("errore nella rimozione del brano");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		for(Brano b : brani) {
			if(b.getArtista().equalsIgnoreCase(artista) && b.getTitolo().equalsIgnoreCase(titolo)) {
				brani.remove(b);
				return true;
			}
		}
		return false;
	}
	
	public int GetMinutiAscoltati() {
		int tot=0;
		for(Brano b : brani) {
			tot+=(b.getDurataSec()*b.getAscolti())/60;
		}
		return tot;
	}
	
	public ArrayList<Brano> braniPerGenere(String genere) {
		try {
			if(genere == null)
				throw new IllegalArgumentException("errore nel nome del genere");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
		}
		ArrayList<Brano> b1 = new ArrayList<Brano>();
		for( Brano b : brani) {
			if(b.getGenere().equalsIgnoreCase(genere)) 
				b1.add(b);
		}
		return b1;
	}
	
	public int  contaBraniPerArtista(String artista) {
		try {
			if(artista == null)
				throw new IllegalArgumentException("errore nel nome dell'artista");
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		int tot=0;
		for(Brano b : brani) {
			if(b.getArtista().equalsIgnoreCase(artista))
				tot++;
		}
		return tot;
	}
	
	public Brano piuAscoltato() {
		Brano br = brani.getFirst();
		
		for(Brano b : brani) {
			if(b.getAscolti() >br.getAscolti()) {
				br = b;
			}
		}
		return br;
	}
	
	public ArrayList<Brano> shuffleConSeed(String genere, int durataMax) {
		try {
			if(genere == null) 
				throw new IllegalArgumentException("errore nel nome del genere");
			if(durataMax == 0)
				throw new IllegalArgumentException("errore nella durata massima");	
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
			
		}
		ArrayList<Brano> br = new ArrayList<Brano>();
		ArrayList<Brano> br1 = new ArrayList<Brano>();
		double durat=0;
		for(Brano b : brani) {
			if(b.getGenere().equalsIgnoreCase(genere)) {
				br.add(b);
			}
		}
		Collections.shuffle(br);
		
		for(Brano b : br) {
			if(durat + b.getDurataSec() <= durataMax) {
				br1.add(b);
				durat+=b.getDurataSec();
			}
		}
		
		
		return br1;
	}
	
	public double durataMediaBrani() {
		try {
			if(brani.size() == 0)
				throw new IllegalArgumentException("lista vuota");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
		double tot=0, cont=0;
		
		for(Brano b : brani) {
			tot+=b.getDurataSec();
			cont++;
		}
		return tot/cont;
	}

	@Override
	public String toString() {
		return "i brani della playlist sono: \n"+ brani;
	}

}
