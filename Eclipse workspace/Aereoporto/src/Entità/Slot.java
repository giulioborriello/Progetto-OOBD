package Entità;

import java.sql.Date;

public class Slot {
	
	private int CodSlot;
	private int TempoDiImbarcoStimato;
	private int TempoDiImbarcoEffettivo;
	private int CodCoda;
	private Date Data;
	private CodaDiImbarco CodaDiImbarco;
	
	public Slot(int codSlot, int tempoDiImbarcoStimato, int tempoDiImbarcoEffettivo, int codCoda, Date data, Object codaDiImbarco) {
		super();
		CodSlot = codSlot;
		TempoDiImbarcoStimato = tempoDiImbarcoStimato;
		TempoDiImbarcoEffettivo = tempoDiImbarcoEffettivo;
		CodCoda = codCoda;
		Data = data;
		CodaDiImbarco = (Entità.CodaDiImbarco) codaDiImbarco;
	}
	
	public int getCodSlot() {
		return CodSlot;
	}
	public void setCodSlot(int codSlot) {
		CodSlot = codSlot;
	}
	public int getTempoDiImbarcoStimato() {
		return TempoDiImbarcoStimato;
	}
	public void setTempoDiImbarcoStimato(int tempoDiImbarcoStimato) {
		TempoDiImbarcoStimato = tempoDiImbarcoStimato;
	}
	public int getTempoDiImbarcoEffettivo() {
		return TempoDiImbarcoEffettivo;
	}
	public void setTempoDiImbarcoEffettivo(int tempoDiImbarcoEffettivo) {
		TempoDiImbarcoEffettivo = tempoDiImbarcoEffettivo;
	}

	public int getCodCoda() {
		return CodCoda;
	}

	public void setCodCoda(int codCoda) {
		CodCoda = codCoda;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public CodaDiImbarco getCodaDiImbarco() {
		return CodaDiImbarco;
	}

	public void setCodaDiImbarco(CodaDiImbarco codaDiImbarco) {
		CodaDiImbarco = codaDiImbarco;
	}
	
	
	
}
