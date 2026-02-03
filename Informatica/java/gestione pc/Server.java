public class Server extends PcFisso {
	private int numProcessi;
	private boolean dischiRaid;
	
	public Server(int ram, int dimMemmoria, String marca, String modello, String sistemaOperativo, String tipoCase,
			int numProcessi, boolean dischiRaid) {
		super(ram, dimMemmoria, marca, modello, sistemaOperativo, tipoCase);
		this.numProcessi = numProcessi;
		this.dischiRaid = dischiRaid;
	}
	public int getNumProcessi() {
		return numProcessi;
	}
	public boolean isDischiRaid() {
		return dischiRaid;
	}
	public void setNumProcessi(int numProcessi) {
		this.numProcessi = numProcessi;
	}
	public void setDischiRaid(boolean dischiRaid) {
		this.dischiRaid = dischiRaid;
	}
	@Override
	public String toString() {
		return super.toString() + " numProcessi=" + numProcessi + ", dischiRaid=" + dischiRaid;
	}
	
	public boolean equals(Server s) {
		if(super.equals(s) && this.toString().equalsIgnoreCase(s.toString()))
			return true;
		return false;
	}
}
