package Entità;

import java.sql.Date;
import java.sql.Time;

public class Tratta {

	private String codTratta;
	private int nPrenotazioni;
	private Time orarioDiPartenza;
	private Date data;
	private int nGate;
	private String codIATA;
	private String destinazione;
	private String scali;

	public Tratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, int Ngate, String CodIATA, 
			String Destinazione, String Scali, Boolean Ritardo) {
		super();
		codTratta = CodTratta;
		nPrenotazioni = Nprenotazioni;
		orarioDiPartenza = OrarioDiPartenza;
		data = Data;
		nGate = Ngate;
		codIATA = CodIATA;
		destinazione = Destinazione;
		scali = Scali;
	}

	public String getCodTratta() {
		return codTratta;
	}

	public void setCodTratta(String CodTratta) {
		codTratta = CodTratta;
	}

	public int getNprenotazioni() {
		return nPrenotazioni;
	}

	public void setNprenotazioni(int Nprenotazioni) {
		nPrenotazioni = Nprenotazioni;
	}

	public Time getOrarioDiPartenza() {
		return orarioDiPartenza;
	}

	public void setOrarioDiPartenza(Time OrarioDiPartenza) {
		orarioDiPartenza = OrarioDiPartenza;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date Data) {
		data = Data;
	}

	public int getNgate() {
		return nGate;
	}

	public void setNgate(int Ngate) {
		nGate = Ngate;
	}

	public String getCodIATA() {
		return codIATA;
	}

	public void setCodIATA(String CodIATA) {
		codIATA = CodIATA;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String Destinazione) {
		destinazione = Destinazione;
	}

	public String getScali() {
		return scali;
	}

	public void setScali(String Scali) {
		scali = Scali;
	}

	

	
}
