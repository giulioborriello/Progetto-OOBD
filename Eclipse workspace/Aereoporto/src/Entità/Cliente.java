package Entità;

import java.util.List;

public class Cliente {
	
	private String CodFiscale;
	private String Nome;
	private String Cognome;
	private String Email;
	private List<Biglietto> Biglietto;
	private List<Fedeltà> Fedeltà;
	
public Cliente(String codFiscale, String nome, String cognome, String email, List<Biglietto> biglietto, List<Fedeltà> fedeltà) {
		super();
		CodFiscale = codFiscale;
		Nome = nome;
		Cognome = cognome;
		Email = email;
		setBiglietto(biglietto);
		Fedeltà = fedeltà;
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
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<Biglietto> getBiglietto() {
		return Biglietto;
	}
	public void setBiglietto(List<Biglietto> biglietto) {
		Biglietto = biglietto;
	}
	public List<Fedeltà> getFedeltà() {
		return Fedeltà;
	}
	public void setCliente(List<Fedeltà> fedeltà) {
		Fedeltà = fedeltà;
	}
	

}
