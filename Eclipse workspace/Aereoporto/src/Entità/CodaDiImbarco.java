package Entità;

public class CodaDiImbarco {
	private String codCoda;
	private String tipoDiCoda;
	private Gate gate;
	private Slot slot;

	public CodaDiImbarco(String codCoda, String tipoDiCoda, Gate gate, Slot slot) {
		super();
		this.codCoda = codCoda;
		this.tipoDiCoda = tipoDiCoda;
		this.gate = gate;
		this.slot = slot;
	}

	public String getCodCoda() {
		return codCoda;
	}

	public void setCodCoda(String CodCoda) {
		codCoda = CodCoda;
	}

	public String getTipoDiCoda() {
		return tipoDiCoda;
	}

	public void setTipoDiCoda(String TipoDiCoda) {
		tipoDiCoda = TipoDiCoda;
	}

	public Gate getGate() {
		return gate;
	}

	public void setGate(Gate gate) {
		this.gate = gate;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
}
