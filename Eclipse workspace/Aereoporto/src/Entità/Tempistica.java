package Entità;

public class Tempistica {
	private String Giorno;
	private String Mese;
	private String Anno;
	private String Valore;
	
	
	
	public Tempistica(String mese, String anno, String valore) {
		super();
		Mese = mese;
		Anno = anno;
		Valore = valore;
	}

	
	
	public Tempistica(String anno, String valore) {
		super();
		Anno = anno;
		Valore = valore;
	}



	public String getGiorno() {
		return Giorno;
	}

	public void setGiorno(String giorno) {
		Giorno = giorno;
	}

	public String getMese() {
		return Mese;
	}

	public void setMese(String mese) {
		Mese = mese;
	}

	public String getAnno() {
		return Anno;
	}

	public void setAnno(String anno) {
		Anno = anno;
	}

	public String getValore() {
		return Valore;
	}
	
	public void setValore(String valore) {
		Valore = valore;
	}
	
}
