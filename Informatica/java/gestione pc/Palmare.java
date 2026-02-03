public class Palmare extends PcPortatili{

	private boolean Bluetooth;
	private String tipoMemoria;
	
	public Palmare(int ram, int dimMemmoria, String marca, String modello, String sistemaOperativo, double peso,
			double altezza, double larghezza, double profodità, double dimSchermo, boolean intReteWireless,
			boolean bluetooth, String tipoMemoria) {
		super(ram, dimMemmoria, marca, modello, sistemaOperativo, peso, altezza, larghezza, profodità, dimSchermo,
				intReteWireless);
		Bluetooth = bluetooth;
		this.tipoMemoria = tipoMemoria;
	}

	public boolean isBluetooth() {
		return Bluetooth;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setBluetooth(boolean bluetooth) {
		Bluetooth = bluetooth;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

	@Override
	public String toString() {
		return super.toString() + " Bluetooth=" + Bluetooth + ", tipoMemoria=" + tipoMemoria;
	}
	
	public boolean equals(Palmare p) {
		if(super.equals(p) && this.toString().equalsIgnoreCase(p.toString()))
			return true;
		return false;
	}
		
}
