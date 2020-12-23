package Entità;

import java.util.List;

public class Gate {

	private int Ngate;
	private String CodTratta;
	private List<CodaDiImbarco> CodaDiImbarco;
	private Tratta Tratta;

	public Gate(int ngate, String codTratta, CodaDiImbarco codaDiImbarco, Tratta tratta) {
		super();
		Ngate = ngate;
		CodTratta = codTratta;
		CodaDiImbarco.add(codaDiImbarco);
		Tratta = tratta;
	}

	public int getNgate() {
		return Ngate;
	}

	public void setNgate(int ngate) {
		Ngate = ngate;
	}

	public String getCodTratta() {
		return CodTratta;
	}

	public void setCodTratta(String codTratta) {
		CodTratta = codTratta;
	}

	public List<CodaDiImbarco> getCodaDiImbarco(){
		return CodaDiImbarco;
	}
	
	public void addCodaDiImbarco(CodaDiImbarco codaDiImbarco) {
		CodaDiImbarco.add(codaDiImbarco);
	}

	public Tratta getTratta() {
		return Tratta;
	}

	public void setTratta(Tratta tratta) {
		Tratta = tratta;
	}
	
	
}
