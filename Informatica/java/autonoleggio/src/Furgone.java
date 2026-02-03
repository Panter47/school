public class Furgone extends Veicolo {

	private int carico;

	public Furgone(String targa, int matricola, String marca, String modello, int cilindrata, int annoAcquisto,
			int capacitàSerbatoio, int carico) {
		super(targa, matricola, marca, modello, cilindrata, annoAcquisto, capacitàSerbatoio);
		this.carico = carico;
	}

	public int getCarico() {
		return carico;
	}

	public void setCarico(int carico) {
		this.carico = carico;
	}

	@Override
	public String toString() {
		return super.toString() + " carico=" + carico;
	}
	
	@Override
	public double costoNoleggio(int giorni, double km, double carburanteRimasto) {
		return (70*giorni) + (km/30) + ((this.getCapacitàSerbatoio()-carburanteRimasto)*2); 
	}

	
	
	
	
}
