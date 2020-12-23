package Entità;

import java.util.List;

public class Compagnia {
	private String CodIATA;
	private String NomeCompagnia;
	private String SitoWeb;
	private List<Tratta> Tratta;
	private List<Fedeltà> Fedeltà;
	
	

	public Compagnia(String codIATA, String nomeCompagnia, String sitoWeb, List<Tratta> tratta, List<Fedeltà> fedeltà) {
		super();
		CodIATA = codIATA;
		NomeCompagnia = nomeCompagnia;
		SitoWeb = sitoWeb;
		setTratta(tratta);
		setFedeltà(fedeltà);
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
	
	public List<Fedeltà> getFedeltà() {
		return Fedeltà;
	}

	public void setFedeltà(List<Fedeltà> fedeltà) {
		Fedeltà = fedeltà;
	}
	
	public void addFedeltà(Fedeltà fedeltà) {
		Fedeltà.add(fedeltà);
	}
	
}
