import java.time.LocalDate;

public class Brano {
	private String titolo;
	private String artista;
	private String genere;
	private int durataSec;
	private LocalDate dataUscita;
	private int ascolti;
	
	public Brano(String titolo, String artista, String genere, int durataSec, LocalDate dataUscita, int ascolti) {
		super();
		this.titolo = titolo;
		this.artista = artista;
		this.genere = genere;
		this.durataSec = durataSec;
		this.dataUscita = dataUscita;
		this.ascolti = ascolti;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getArtista() {
		return artista;
	}

	public String getGenere() {
		return genere;
	}

	public int getDurataSec() {
		return durataSec;
	}

	public LocalDate getDataUscita() {
		return dataUscita;
	}

	public int getAscolti() {
		return ascolti;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public void setDurataSec(int durataSec) {
		this.durataSec = durataSec;
	}

	public void setDataUscita(LocalDate dataUscita) {
		this.dataUscita = dataUscita;
	}

	public void setAscolti(int ascolti) {
		this.ascolti = ascolti;
	}
	
	public void incrementaAscolti() {
		ascolti++;
	}

	@Override
	public String toString() {
		return "titolo=" + titolo + "  artista=" + artista + "  genere=" + genere + "  durataSec=" + durataSec
				+ "  dataUscita=" + dataUscita + "  ascolti=" + ascolti + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brano other = (Brano) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (genere == null) {
			if (other.genere != null)
				return false;
		} else if (!genere.equals(other.genere))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
	

	
}
