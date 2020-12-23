package Entità;

public class CodaDiImbarco {
	private int CodCoda;
	private String TipoDiCoda;
	private int Ngate;
	private int CodSlot;
	
	public CodaDiImbarco(int codCoda, String tipoDiCoda, int ngate, int codSlot) {
		super();
		CodCoda = codCoda;
		TipoDiCoda = tipoDiCoda;
		Ngate = ngate;
		CodSlot = codSlot;
	}

	public int getCodCoda() {
		return CodCoda;
	}

	public void setCodCoda(int codCoda) {
		CodCoda = codCoda;
	}

	public String getTipoDiCoda() {
		return TipoDiCoda;
	}

	public void setTipoDiCoda(String tipoDiCoda) {
		TipoDiCoda = tipoDiCoda;
	}

	public int getNgate() {
		return Ngate;
	}

	public void setNgate(int ngate) {
		Ngate = ngate;
	}

	public int getCodSlot() {
		return CodSlot;
	}

	public void setCodSlot(int codSlot) {
		CodSlot = codSlot;
	}
	
	

}
