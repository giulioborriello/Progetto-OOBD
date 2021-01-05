package Entità;

public class Fedeltà {
	private int centoKilometri;
	private String codIATA;
	private String codFiscale;
	private int punti;

	public Fedeltà(int CentoKilometri, String CodIATA, String CodFiscale, int Punti) {
		super();
		centoKilometri = CentoKilometri;
		codIATA = CodIATA;
		codFiscale = CodFiscale;
		punti = Punti;
	}

	public int getCentoKilometri() {
		return centoKilometri;
	}

	public void setCentoKilometri(int CentoKilometri) {
		centoKilometri = CentoKilometri;
	}

	public String getCodIATA() {
		return codIATA;
	}

	public void setCodIATA(String CodIATA) {
		codIATA = CodIATA;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String CodFiscale) {
		codFiscale = CodFiscale;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int Punti) {
		punti = Punti;
	}
}
