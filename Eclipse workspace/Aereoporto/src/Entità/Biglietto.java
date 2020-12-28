package Entità;


public class Biglietto {

	

	 private String CodTratta;
	 private String CodFiscale;
	 private String Nome;
	 private String Posto;
	 private String TipoDiBiglietto;
	 private String CodBiglietto;
	 private Cliente Cliente;
	 private Tratta Tratta;
	 

 public Biglietto(String codTratta, String codFiscale, String nome, String posto, String tipo_Di_Biglietto,
			String codBiglietto, Cliente cliente, Tratta tratta) {
		super();
		CodTratta = codTratta;
		CodFiscale = codFiscale;
		Nome = nome;
		Posto = posto;
		TipoDiBiglietto = tipo_Di_Biglietto;
		CodBiglietto = codBiglietto;
		Cliente= cliente;
	    Tratta =  tratta;
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

	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	public Tratta getTratta() {
		return Tratta;
	}
	public void setTratta(Tratta tratta) {
		Tratta = tratta;
	}


	

}
