package Entità;

import java.sql.Date;
import java.sql.Time;

public class Tratta {

	private String codTratta;
	private int nPrenotazioni;
	private Time orarioDiPartenza;
	private Date data;
	private String destinazione;
	private String scali;
	private boolean ritardo;
	private Compagnia compagnia;
	private Gate gate;
	

	public Tratta(String codTratta, int nPrenotazioni, Time orarioDiPartenza, Date data, String destinazione,
			String scali, boolean ritardo, Compagnia compagnia, Gate gate) {
		super();
		this.codTratta = codTratta;
		this.nPrenotazioni = nPrenotazioni;
		this.orarioDiPartenza = orarioDiPartenza;
		this.data = data;
		this.destinazione = destinazione;
		this.scali = scali;
		this.ritardo = ritardo;
		this.setCompagnia(compagnia);
		this.setGate(gate);
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

	public boolean isRitardo() {
		return ritardo;
	}

	public void setRitardo(boolean ritardo) {
		this.ritardo = ritardo;
	}

	public Compagnia getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(Compagnia compagnia) {
		this.compagnia = compagnia;
	}

	public Gate getGate() {
		return gate;
	}

	public void setGate(Gate gate) {
		this.gate = gate;
	}

	

	
}
