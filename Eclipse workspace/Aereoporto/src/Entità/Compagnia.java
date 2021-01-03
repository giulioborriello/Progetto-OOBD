package Entità;

import java.util.List;

public class Compagnia {
	private String CodIATA;
	private String NomeCompagnia;
	
	

	public Compagnia(String codIATA, String nomeCompagnia) {
		super();
		CodIATA = codIATA;
		NomeCompagnia = nomeCompagnia;
	}

	public String getCodIATA() {
		return CodIATA;
	}

	public void setCodIATA(String codIATA) {
		CodIATA = codIATA;
	}

	public String getNomeCompagnia() {
		return NomeCompagnia;
	}

	public void setNomeCompagnia(String nomeCompagnia) {
		NomeCompagnia = nomeCompagnia;
	}
	
}
