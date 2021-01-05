package Entità;

public class CodaDiImbarco {
	private int codCoda;
	private String tipoDiCoda;
	private int nGate;
	private int codSlot;
	
	public CodaDiImbarco(int CodCoda, String TipoDiCoda, int Ngate, int CodSlot) {
		super();
		codCoda = CodCoda;
		tipoDiCoda = TipoDiCoda;
		nGate = Ngate;
		codSlot = CodSlot;
	}

	public int getCodCoda() {
		return codCoda;
	}

	public void setCodCoda(int CodCoda) {
		codCoda = CodCoda;
	}

	public String getTipoDiCoda() {
		return tipoDiCoda;
	}

	public void setTipoDiCoda(String TipoDiCoda) {
		tipoDiCoda = TipoDiCoda;
	}

	public int getNgate() {
		return nGate;
	}

	public void setNgate(int Ngate) {
		nGate = Ngate;
	}

	public int getCodSlot() {
		return codSlot;
	}

	public void setCodSlot(int CodSlot) {
		codSlot = CodSlot;
	}
}
