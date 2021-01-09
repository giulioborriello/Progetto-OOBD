package Entità;

public class Tempistica {
	private String Giorno;
	private String Settimana;
	private String Mese;
	private String Anno;
	private String Valore;
	
	
	
	public Tempistica( String anno, String mese, String settimana, String giorno, String valore) {
		super();
		Giorno = giorno;
		Settimana = settimana;
		Mese = mese;
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



	public String getSettimana() {
		return Settimana;
	}



	public void setSettimana(String settimana) {
		Settimana = settimana;
	}
	
}
