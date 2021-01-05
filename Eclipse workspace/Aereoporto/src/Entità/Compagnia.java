package Entità;


public class Compagnia {
	private String codIATA;
	private String nomeCompagnia;
	
	

	public Compagnia(String CodIATA, String NomeCompagnia) {
		super();
		codIATA = CodIATA;
		nomeCompagnia = NomeCompagnia;
	}

	public String getCodIATA() {
		return codIATA;
	}

	public void setCodIATA(String CodIATA) {
		codIATA = CodIATA;
	}

	public String getNomeCompagnia() {
		return nomeCompagnia;
	}

	public void setNomeCompagnia(String NomeCompagnia) {
		nomeCompagnia = NomeCompagnia;
	}
	
}
