package Entit�;

import java.util.List;

public class Compagnia {
	private String CodIATA;
	private String NomeCompagnia;
	private String SitoWeb;
	private List<Tratta> Tratta;
	private List<Fedelt�> Fedelt�;
	
	

	public Compagnia(String codIATA, String nomeCompagnia, String sitoWeb, List<Tratta> tratta, List<Fedelt�> fedelt�) {
		super();
		CodIATA = codIATA;
		NomeCompagnia = nomeCompagnia;
		SitoWeb = sitoWeb;
		setTratta(tratta);
		setFedelt�(fedelt�);
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

	public List<Tratta> getTratta() {
		return Tratta;
	}

	public void setTratta(List<Tratta> tratta) {
		Tratta = tratta;
	}

	public void addTratta(Tratta tratta) {
		Tratta.add(tratta);
	}
	
	public List<Fedelt�> getFedelt�() {
		return Fedelt�;
	}

	public void setFedelt�(List<Fedelt�> fedelt�) {
		Fedelt� = fedelt�;
	}
	
	public void addFedelt�(Fedelt� fedelt�) {
		Fedelt�.add(fedelt�);
	}
	
}
