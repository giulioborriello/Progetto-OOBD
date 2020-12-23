package Entità;

public class Cliente {
	
	private String CodFiscale;
	private String Nome;
	private String Cognome;
	private String Email;
	
	
public Cliente(String codFiscale, String nome, String cognome, String email) {
		super();
		CodFiscale = codFiscale;
		Nome = nome;
		Cognome = cognome;
		Email = email;
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
	

}
