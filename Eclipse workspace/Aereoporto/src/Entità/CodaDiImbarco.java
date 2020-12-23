package Entità;

public class CodaDiImbarco {
	private int CodCoda;
	private String TipoDiCoda;
	private int Ngate;
	private int CodSlot;
	private Slot Slot;
	private Gate Gate;
	
	public CodaDiImbarco(int codCoda, String tipoDiCoda, int ngate, int codSlot, Slot slot, Gate gate) {
		super();
		CodCoda = codCoda;
		TipoDiCoda = tipoDiCoda;
		Ngate = ngate;
		CodSlot = codSlot;
		Slot = slot;
		Gate = gate;
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

	public Slot getSlot() {
		return Slot;
	}

	public void setSlot(Slot slot) {
		Slot = slot;
	}

	public Gate getGate() {
		return Gate;
	}

	public void setGate(Gate gate) {
		Gate = gate;
	}
	
	

}
