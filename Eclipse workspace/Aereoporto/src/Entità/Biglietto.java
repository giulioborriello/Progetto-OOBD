package Entità;


public class Biglietto {
	private String codTratta;
	private String codFiscale;
	private String posto;
	private String tipoDiBiglietto;
	private String codBiglietto;



	public Biglietto(String CodTratta, String CodFiscale, String Posto, String TipoDiBiglietto, String CodBiglietto) {
		super();
		codTratta = CodTratta;
		codFiscale = CodFiscale;
		posto = Posto;
		tipoDiBiglietto = TipoDiBiglietto;
		codBiglietto = CodBiglietto;
	}


	public String getCodTratta() {
		return codTratta;
	}
	public void setCodTratta(String CodTratta) {
		codTratta = CodTratta;
	}
	public String getCodFiscale() {
		return codFiscale;
	}
	public void setCodFiscale(String CodFiscale) {
		codFiscale = CodFiscale;
	}

	public String getPosto() {
		return posto;
	}
	public void setPosto(String Posto) {
		posto = Posto;
	}
	public String getTipo_Di_Biglietto() {
		return tipoDiBiglietto;
	}
	public void setTipo_Di_Biglietto(String TipoDiBiglietto) {
		tipoDiBiglietto = TipoDiBiglietto;
	}
	public String getCodBiglietto() {
		return codBiglietto;
	}
	public void setCodBiglietto(String CodBiglietto) {
		codBiglietto = CodBiglietto;
	}

}
