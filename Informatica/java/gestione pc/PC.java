public class PC {
	protected int ram;
	protected int dimMemmoria;
	protected String marca;
	protected String modello;
	protected String sistemaOperativo;
	
	
	public PC(int ram, int dimMemmoria, String marca, String modello, String sistemaOperativo) {
		this.ram = ram;
		this.dimMemmoria = dimMemmoria;
		this.marca = marca;
		this.modello = modello;
		this.sistemaOperativo = sistemaOperativo;
	}
	public int getRam() {
		return ram;
	}
	public int getDimMemmoria() {
		return dimMemmoria;
	}
	public String getMarca() {
		return marca;
	}
	public String getModello() {
		return modello;
	}
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public void setDimMemmoria(int dimMemmoria) {
		this.dimMemmoria = dimMemmoria;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	@Override
	public String toString() {
		return "ram=" + ram + ", dimMemmoria=" + dimMemmoria + ", marca=" + marca + ", modello=" + modello
				+ ", sistemaOperativo=" + sistemaOperativo;
	}
	
	public boolean equals(PC p) {	
	if(this.toString().equalsIgnoreCase(p.toString()))
		return true;
	return false;
	
	}
	
}
