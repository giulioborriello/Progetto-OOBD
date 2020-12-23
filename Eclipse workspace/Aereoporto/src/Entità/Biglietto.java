package Entità;

public class Biglietto {
 public Biglietto(String codTratta, String codFiscale, String nome, String posto, String tipo_Di_Biglietto,
			String codBiglietto) {
		super();
		CodTratta = codTratta;
		CodFiscale = codFiscale;
		Nome = nome;
		Posto = posto;
		Tipo_Di_Biglietto = tipo_Di_Biglietto;
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
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPosto() {
		return Posto;
	}
	public void setPosto(String posto) {
		Posto = posto;
	}
	public String getTipo_Di_Biglietto() {
		return Tipo_Di_Biglietto;
	}
	public void setTipo_Di_Biglietto(String tipo_Di_Biglietto) {
		Tipo_Di_Biglietto = tipo_Di_Biglietto;
	}
	public String getCodBiglietto() {
		return CodBiglietto;
	}
	public void setCodBiglietto(String codBiglietto) {
		CodBiglietto = codBiglietto;
	}
private String CodTratta;
 private String CodFiscale;
 private String Nome;
 private String Posto;
 private String Tipo_Di_Biglietto;
 private String CodBiglietto;
	public Biglietto() {
		
	}

}
