package Entità;

import java.sql.Date;
import java.sql.Time;

public class Tratta {

	private String CodTratta;
	private int Nprenotazioni;
	private Time OrarioDiPartenza;
	private Date Data;
	private int Ngate;
	private String CodIATA;
	private String Destinazione;
	private String Scali;
	
	public Tratta(String codTratta, int nprenotazioni, Time orarioDiPartenza, Date data, int ngate, String codIATA,
			String destinazione, String scali) {
		super();
		CodTratta = codTratta;
		Nprenotazioni = nprenotazioni;
		OrarioDiPartenza = orarioDiPartenza;
		Data = data;
		Ngate = ngate;
		CodIATA = codIATA;
		Destinazione = destinazione;
		Scali = scali;
	}

	public String getCodTratta() {
		return CodTratta;
	}

	public void setCodTratta(String codTratta) {
		CodTratta = codTratta;
	}

	public int getNprenotazioni() {
		return Nprenotazioni;
	}

	public void setNprenotazioni(int nprenotazioni) {
		Nprenotazioni = nprenotazioni;
	}

	public Time getOrarioDiPartenza() {
		return OrarioDiPartenza;
	}

	public void setOrarioDiPartenza(Time orarioDiPartenza) {
		OrarioDiPartenza = orarioDiPartenza;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public int getNgate() {
		return Ngate;
	}

	public void setNgate(int ngate) {
		Ngate = ngate;
	}

	public String getCodIATA() {
		return CodIATA;
	}

	public void setCodIATA(String codIATA) {
		CodIATA = codIATA;
	}

	public String getDestinazione() {
		return Destinazione;
	}

	public void setDestinazione(String destinazione) {
		Destinazione = destinazione;
	}

	public String getScali() {
		return Scali;
	}

	public void setScali(String scali) {
		Scali = scali;
	}
	
	
	
}
