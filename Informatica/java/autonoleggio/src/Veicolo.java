public abstract class Veicolo {
	
	protected String targa;
	protected int matricola;
	protected String marca;
	protected String modello;
	protected int cilindrata;
	protected int annoAcquisto;
	protected int capacitàSerbatoio;
	
	public Veicolo(String targa, int matricola, String marca, String modello, int cilindrata, int annoAcquisto, int capacitàSerbatoio) {
		this.targa = targa;
		this.matricola = matricola;
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.annoAcquisto = annoAcquisto;
		this.capacitàSerbatoio = capacitàSerbatoio;
	}

	public String getTarga() {
		return targa;
	}

	public int getMatricola() {
		return matricola;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public int getAnnoAcquisto() {
		return annoAcquisto;
	}

	public int getCapacitàSerbatoio() {
		return capacitàSerbatoio;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public void setAnnoAcquisto(int annoAcquisto) {
		this.annoAcquisto = annoAcquisto;
	}

	public void setCapacitàSerbatoio(int capacitàSerbatoio) {
		this.capacitàSerbatoio = capacitàSerbatoio;
	}	
	
	@Override
	public String toString() {
		return "targa=" + targa + "  matricola=" + matricola + "  marca=" + marca + "  modello=" + modello
				+ "  cilindrata=" + cilindrata + "  annoAcquisto=" + annoAcquisto + "  capacitàSerbatoio="
				+ capacitàSerbatoio;
	}

	public abstract double costoNoleggio(int giorni, double km, double carburanteRimasto);
}
