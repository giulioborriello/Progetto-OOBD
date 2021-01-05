package Entità;


public class Cliente {
	
	private String codFiscale;
	private String nome;
	private String cognome;
	private String email;
	
	
public Cliente(String CodFiscale, String Nome, String Cognome, String Email) {
		super();
		codFiscale = CodFiscale;
		nome = Nome;
		cognome = Cognome;
		email = Email;
	}

public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String CodFiscale) {
		codFiscale = CodFiscale;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String Nome) {
		nome = Nome;
	}
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String Cognome) {
		cognome = Cognome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String Email) {
		email = Email;
	}
	

}
