public class PcPortatili extends PC {
	
	protected double peso;
	protected double altezza;
	protected double larghezza;
	protected double profodità;
	protected double dimSchermo;
	protected boolean intReteWireless;
	public PcPortatili(int ram, int dimMemmoria, String marca, String modello, String sistemaOperativo, double peso,
			double altezza, double larghezza, double profodità, double dimSchermo, boolean intReteWireless) {
		super(ram, dimMemmoria, marca, modello, sistemaOperativo);
		this.peso = peso;
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.profodità = profodità;
		this.dimSchermo = dimSchermo;
		this.intReteWireless = intReteWireless;
	}
	public double getPeso() {
		return peso;
	}
	public double getAltezza() {
		return altezza;
	}
	public double getLarghezza() {
		return larghezza;
	}
	public double getProfodità() {
		return profodità;
	}
	public double getDimSchermo() {
		return dimSchermo;
	}
	public boolean isIntReteWireless() {
		return intReteWireless;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}
	public void setProfodità(double profodità) {
		this.profodità = profodità;
	}
	public void setDimSchermo(double dimSchermo) {
		this.dimSchermo = dimSchermo;
	}
	public void setIntReteWireless(boolean intReteWireless) {
		this.intReteWireless = intReteWireless;
	}
	@Override
	public String toString() {
		return super.toString() + " peso=" + peso + ", altezza=" + altezza + ", larghezza=" + larghezza + ", profodità=" + profodità
				+ ", dimSchermo=" + dimSchermo + ", intReteWireless=" + intReteWireless;
	}
	
	public boolean equals(PcPortatili p) {
		if(super.equals(p) && this.toString().equalsIgnoreCase(p.toString()))
			return true;
		return false;
	}

}
