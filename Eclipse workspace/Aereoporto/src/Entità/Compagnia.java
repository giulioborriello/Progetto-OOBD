package Entità;

import java.util.List;

public class Compagnia {
	private String CodIATA;
	private String NomeCompagnia;
	private String SitoWeb;
	
	

	public Compagnia(String codIATA, String nomeCompagnia, String sitoWeb) {
		super();
		CodIATA = codIATA;
		NomeCompagnia = nomeCompagnia;
		SitoWeb = sitoWeb;
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

	public String getSitoWeb() {
		return SitoWeb;
	}

	public void setSitoWeb(String sitoWeb) {
		SitoWeb = sitoWeb;
	}
	
}
