package Entità;

import java.util.List;

public class Gate {

	private int Ngate;
	private String CodTratta;
	private Tratta Tratta;

	public Gate(int ngate, String codTratta, Tratta tratta) {
		super();
		Ngate = ngate;
		CodTratta = codTratta;
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
	
	public Tratta getTratta() {
		return Tratta;
	}

	public void setTratta(Tratta tratta) {
		Tratta = tratta;
	}
	
	
}
