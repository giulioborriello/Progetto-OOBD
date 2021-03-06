package Entit�;

import java.sql.Date;
import java.sql.Time;

public class Slot {
	
	private String codSlot;
	private int tempoDiImbarcoStimato;
	private int tempoDiImbarcoEffettivo;
	private Date data;
	private CodaDiImbarco coda;
	
	public Slot(String codSlot, int tempoDiImbarcoStimato, int tempoDiImbarcoEffettivo, Date data,
			CodaDiImbarco coda) {
		super();
		this.codSlot = codSlot;
		this.tempoDiImbarcoStimato = tempoDiImbarcoStimato;
		this.tempoDiImbarcoEffettivo = tempoDiImbarcoEffettivo;
		this.data = data;
		this.setCoda(coda);
	}
	public String getCodSlot() {
		return codSlot;
	}
	public void setCodSlot(String CodSlot) {
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public CodaDiImbarco getCoda() {
		return coda;
	}
	public void setCoda(CodaDiImbarco coda) {
		this.coda = coda;
	}
}
