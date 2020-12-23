package Entità;

public class Fedeltà {
	private int CentoKilometri;
	private String CodIATA;
	private String CodFiscale;
	private int Punti;
	
	public Fedeltà(int centoKilometri, String codIATA, String codFiscale, int punti) {
		super();
		CentoKilometri = centoKilometri;
		CodIATA = codIATA;
		CodFiscale = codFiscale;
		Punti = punti;
	}

	public int getCentoKilometri() {
		return CentoKilometri;
	}

	public void setCentoKilometri(int centoKilometri) {
		CentoKilometri = centoKilometri;
	}

	public String getCodIATA() {
		return CodIATA;
	}

	public void setCodIATA(String codIATA) {
		CodIATA = codIATA;
	}

	public String getCodFiscale() {
		return CodFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		CodFiscale = codFiscale;
	}

	public int getPunti() {
		return Punti;
	}

	public void setPunti(int punti) {
		Punti = punti;
	}
	
	
	
	
	
}
