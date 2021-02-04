package Entità;


public class Biglietto {
	private Tratta tratta;
	private Cliente cliente;
	private String posto;
	private String tipoDiBiglietto;
	private String codBiglietto;

	
	public Biglietto(String posto, String tipoDiBiglietto, String codBiglietto, Tratta tratta, Cliente cliente) {
		super();
		this.tratta = tratta;
		this.cliente = cliente;
		this.posto = posto;
		this.tipoDiBiglietto = tipoDiBiglietto;
		this.codBiglietto = codBiglietto;
	}
	
	

	public Tratta getTratta() {
		return tratta;
	}



	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public String getPosto() {
		return posto;
	}
	public void setPosto(String Posto) {
		posto = Posto;
	}
	public String getTipoDiBiglietto() {
		return tipoDiBiglietto;
	}
	public void setTipoDiBiglietto(String TipoDiBiglietto) {
		tipoDiBiglietto = TipoDiBiglietto;
	}
	public String getCodBiglietto() {
		return codBiglietto;
	}
	public void setCodBiglietto(String CodBiglietto) {
		codBiglietto = CodBiglietto;
	}

}
