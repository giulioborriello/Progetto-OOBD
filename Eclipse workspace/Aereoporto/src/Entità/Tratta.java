package Entità;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Tratta {

	private String CodTratta;
	private int Nprenotazioni;
	private Time OrarioDiPartenza;
	private Date Data;
	private int Ngate;
	private String CodIATA;
	private String Destinazione;
	private String Scali;
	private Gate Gate;
	private List<Biglietto> Biglietto;
	private Compagnia Compagnia;

	public Tratta(String codTratta, int nprenotazioni, Time orarioDiPartenza, Date data, int ngate, String codIATA, 
			String destinazione, String scali, Object gate, Object biglietto, Object compagnia) {
		super();
		CodTratta = codTratta;
		Nprenotazioni = nprenotazioni;
		OrarioDiPartenza = orarioDiPartenza;
		Data = data;
		Ngate = ngate;
		CodIATA = codIATA;
		Destinazione = destinazione;
		Scali = scali;
		Gate = (Entità.Gate) gate;
		Biglietto.add((Entità.Biglietto) biglietto);
		Compagnia = (Entità.Compagnia) compagnia;
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

	public Gate getGate() {
		return Gate;
	}

	public void setGate(Gate gate) {
		Gate = gate;
	}

	public List<Biglietto> getBiglietto() {
		return Biglietto;
	}

	public void addBiglietto(Biglietto biglietto) {
		Biglietto.add(biglietto);
	}

	public Compagnia getCompagnia() {
		return Compagnia;
	}

	public void setCompagnia(Compagnia compagnia) {
		Compagnia = compagnia;
	}
	
	
	
}
