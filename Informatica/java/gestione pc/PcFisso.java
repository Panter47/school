public class PcFisso extends PC {
	protected String tipoCase;

	public PcFisso(int ram, int dimMemmoria, String marca, String modello, String sistemaOperativo, String tipoCase) {
		super(ram, dimMemmoria, marca, modello, sistemaOperativo);
		this.tipoCase = tipoCase;
	}

	public String getTipoCase() {
		return tipoCase;
	}

	public void setTipoCase(String tipoCase) {
		this.tipoCase = tipoCase;
	}
	
	@Override
	public String toString() {
		return super.toString() + " tipoCase=" + tipoCase;
	}

	public boolean equals(PcFisso f) {
		if(super.equals(f) && this.toString().equalsIgnoreCase(f.toString()) )
			return true;
		return false;
	}
	
}
