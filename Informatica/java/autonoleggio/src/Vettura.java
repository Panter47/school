public class Vettura extends Veicolo{
	
	private int numPosti;

	public Vettura(String targa, int matricola, String marca, String modello, int cilindrata, int annoAcquisto,
			int capacitàSerbatoio, int numPosti) {
		super(targa, matricola, marca, modello, cilindrata, annoAcquisto, capacitàSerbatoio);
		this.numPosti = numPosti;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + " numPosti=" + numPosti;
	}

	@Override
	public double costoNoleggio(int giorni, double km, double carburanteRimasto) {
		return (50*giorni) + (km/25) + ((this.getCapacitàSerbatoio()-carburanteRimasto)*2); 
	}
	
	
}
