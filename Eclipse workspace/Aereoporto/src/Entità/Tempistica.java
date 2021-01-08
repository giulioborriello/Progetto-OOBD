package Entità;

public class Tempistica {
	private String GiornoMeseAnno;
	private String Valore;
	
	public Tempistica(String giornoMeseAnno, String valore) {
		super();
		GiornoMeseAnno = giornoMeseAnno;
		Valore = valore;
	}
	
	public String getGiornoMeseAnno() {
		return GiornoMeseAnno;
	}
	
	public void setGiornoMeseAnno(String giornoMeseAnno) {
		GiornoMeseAnno = giornoMeseAnno;
	}
	
	public String getValore() {
		return Valore;
	}
	
	public void setValore(String valore) {
		Valore = valore;
	}
	
}
