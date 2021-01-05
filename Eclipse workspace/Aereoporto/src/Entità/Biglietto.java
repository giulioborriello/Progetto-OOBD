package Entità;


public class Biglietto {

	

	 private String CodTratta;
	 private String CodFiscale;
	 private String Posto;
	 private String TipoDiBiglietto;
	 private String CodBiglietto;
	 
	 

 public Biglietto(String codTratta, String codFiscale, String posto, String tipo_Di_Biglietto,
			String codBiglietto) {
		super();
		CodTratta = codTratta;
		CodFiscale = codFiscale;
		Posto = posto;
		TipoDiBiglietto = tipo_Di_Biglietto;
		CodBiglietto = codBiglietto;
	}
 
 
public String getCodTratta() {
		return CodTratta;
	}
	public void setCodTratta(String codTratta) {
		CodTratta = codTratta;
	}
	public String getCodFiscale() {
		return CodFiscale;
	}
	public void setCodFiscale(String codFiscale) {
		CodFiscale = codFiscale;
	}
	
	public String getPosto() {
		return Posto;
	}
	public void setPosto(String posto) {
		Posto = posto;
	}
	public String getTipo_Di_Biglietto() {
		return TipoDiBiglietto;
	}
	public void setTipo_Di_Biglietto(String tipo_Di_Biglietto) {
		TipoDiBiglietto = tipo_Di_Biglietto;
	}
	public String getCodBiglietto() {
		return CodBiglietto;
	}
	public void setCodBiglietto(String codBiglietto) {
		CodBiglietto = codBiglietto;
	}

}
