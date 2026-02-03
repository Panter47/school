import java.time.LocalDate;

public class Docente extends Dipendente {
	
	private int numOre;
	private final int retribuzioneOraria=12;

	public Docente(String nominativo, String sesso, LocalDate dataDiNascita, double stipendioBase, double straordinario,
			int numOre) {
		super(nominativo, sesso, dataDiNascita, stipendioBase, straordinario);
		this.numOre = numOre;
	}

	public int getNumOre() {
		return numOre;
	}

	public void setNumOre(int numOre) {
		this.numOre = numOre;
	}

	@Override
	public String toString() {
		return "numOre=" + numOre + "  toString()=" + super.toString() + " ";
	}

	@Override
	public double straordinario(int ore) {
		setStraordinario(ore*retribuzioneOraria);
		return getStraordinario();
	}

	@Override
	public double stipendioMensile() {
		return getStipendioBase() + getStraordinario();
	}
	
	
	
	
	

}
