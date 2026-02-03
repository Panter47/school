
public class Notebook extends PcPortatili{
	private boolean webcam;
	private int megapixel;
	
	public Notebook(int ram, int dimMemmoria, String marca, String modello, String sistemaOperativo, double peso,
			double altezza, double larghezza, double profodità, double dimSchermo, boolean intReteWireless,
			boolean webcam, int megapixel) {
		super(ram, dimMemmoria, marca, modello, sistemaOperativo, peso, altezza, larghezza, profodità, dimSchermo,
				intReteWireless);
		this.webcam = webcam;
		if(webcam==true)
			this.megapixel=megapixel;
		else
			this.megapixel=0;
	}

	public boolean isWebcam() {
		return webcam;
	}

	public int getMegapixel() {
		return megapixel;
	}

	public void setWebcam(boolean webcam) {
		this.webcam = webcam;
	}

	public void setMegapixel(int megapixel) {
		this.megapixel = megapixel;
	}

	@Override
	public String toString() {
		return super.toString() + " webcam=" + webcam + ", megapixel=" + megapixel;
	}
	
	public boolean equals(Notebook n) {
		if(super.equals(n) && this.toString().equalsIgnoreCase(n.toString()))
			return true;
		return false;
	}
	
	

}
