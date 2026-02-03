public class Desktop extends PcFisso{

	private String schedaVideo;
	private String scehdaAudio;
	
	public Desktop(int ram, int dimMemmoria, String marca, String modello, String sistemaOperativo, String tipoCase,
			String schedaVideo, String scehdaAudio) {
		super(ram, dimMemmoria, marca, modello, sistemaOperativo, tipoCase);
		this.schedaVideo = schedaVideo;
		this.scehdaAudio = scehdaAudio;
	}

	public String getSchedaVideo() {
		return schedaVideo;
	}

	public String getScehdaAudio() {
		return scehdaAudio;
	}

	public void setSchedaVideo(String schedaVideo) {
		this.schedaVideo = schedaVideo;
	}

	public void setScehdaAudio(String scehdaAudio) {
		this.scehdaAudio = scehdaAudio;
	}

	@Override
	public String toString() {
		return super.toString() + " schedaVideo=" + schedaVideo + ", scehdaAudio=" + scehdaAudio;
	}

	public boolean equals(Desktop d) {
		if(super.equals(d) && this.toString().equalsIgnoreCase(d.toString()))
			return true;
		return false;
	}
	
	

}
