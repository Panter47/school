public class Libro {
	private String titolo;
	private String autore; 
	private String letto;
	private double prezzo;
	private int anno;
	private String genere;

	public Libro(String titolo, String autore, String genere, double prezzo, int anno, String letto) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.genere=genere;
		this.prezzo = prezzo;
		this.anno = anno;
		this.letto = letto;
	}
	//getter
	public String getTitolo() {
		return titolo;
	}
	public String getAutore() {
		return autore;
	}
	public String getLetto() {
		return letto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public int getAnno() {
		return anno;
	}
	public String getGenere() {
		return genere;
	}
	
	//setter
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public void setLetto(String letto) {
		this.letto = letto;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public void setGenere(String genere) {
		this.genere=genere;
	}
	
	@Override
	public String toString() {
		return titolo + ": " + autore + ": " +genere +": "+ prezzo + ": " + anno + ": "
				+ letto;
	}
	
	
	/**
	 * dalla lettura della stringa all'oggetto libro
	 * @param linea passi la stringa letta del file txt
	 * @return a new object book
	 */
	public static Libro fromString(String linea) {
		String[] parte = linea.split(": ");
		String titolo = parte[0];
		String autore = parte[1];
		String genere = parte[2];
		double prezzo = Double.parseDouble(parte[3]);
		int anno = Integer.parseInt(parte[4]);
		String letto = parte[5];
		return new Libro(titolo, autore,genere,prezzo,anno,letto);
	}
	
}
