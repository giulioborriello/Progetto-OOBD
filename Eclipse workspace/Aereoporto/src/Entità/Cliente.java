package Entità;


public class Cliente {
	
	private String codFiscale;
	private String nome;
	private String cognome;	
	
public Cliente(String CodFiscale, String Nome, String Cognome) {
		super();
		codFiscale = CodFiscale;
		nome = Nome;
		cognome = Cognome;
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
	
	

}
