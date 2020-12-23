package Entit�;

import java.util.List;

public class Cliente {
	
	private String CodFiscale;
	private String Nome;
	private String Cognome;
	private String Email;
	private List<Biglietto> Biglietto;
	private List<Fedelt�> Fedelt�;
	
public Cliente(String codFiscale, String nome, String cognome, String email, List<Biglietto> biglietto, List<Fedelt�> fedelt�) {
		super();
		CodFiscale = codFiscale;
		Nome = nome;
		Cognome = cognome;
		Email = email;
		setBiglietto(biglietto);
		Fedelt� = fedelt�;
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
	public List<Fedelt�> getFedelt�() {
		return Fedelt�;
	}
	public void setCliente(List<Fedelt�> fedelt�) {
		Fedelt� = fedelt�;
	}
	

}
