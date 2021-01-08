package Entità;

import java.sql.Date;
import java.sql.Time;

public class Slot {
	
	private int codSlot;
	private int tempoDiImbarcoStimato;
	private int tempoDiImbarcoEffettivo;
	private int codCoda;
	private Date data;
	private Time orarioDiPartenza;
	
	public Slot(int CodSlot, int TempoDiImbarcoStimato, int TempoDiImbarcoEffettivo, int CodCoda, Date Data, Time OrarioDiPartenza) {
		super();
		codSlot = CodSlot;
		tempoDiImbarcoStimato = TempoDiImbarcoStimato;
		tempoDiImbarcoEffettivo = TempoDiImbarcoEffettivo;
		codCoda = CodCoda;
		data = Data;
		setOrarioDiPartenza(OrarioDiPartenza);
	}
	
	public int getCodSlot() {
		return codSlot;
	}
	public void setCodSlot(int CodSlot) {
		codSlot = CodSlot;
	}
	public int getTempoDiImbarcoStimato() {
		return tempoDiImbarcoStimato;
	}
	public void setTempoDiImbarcoStimato(int TempoDiImbarcoStimato) {
		tempoDiImbarcoStimato = TempoDiImbarcoStimato;
	}
	public int getTempoDiImbarcoEffettivo() {
		return tempoDiImbarcoEffettivo;
	}
	public void setTempoDiImbarcoEffettivo(int TempoDiImbarcoEffettivo) {
		tempoDiImbarcoEffettivo = TempoDiImbarcoEffettivo;
	}

	public int getCodCoda() {
		return codCoda;
	}

	public void setCodCoda(int CodCoda) {
		codCoda = CodCoda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getOrarioDiPartenza() {
		return orarioDiPartenza;
	}

	public void setOrarioDiPartenza(Time orarioDiPartenza) {
		this.orarioDiPartenza = orarioDiPartenza;
	}
}
