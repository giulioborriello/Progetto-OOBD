package Entità;


public class Gate {

	private int Ngate;
	private String CodTratta;

	public Gate(int ngate, String codTratta) {
		super();
		Ngate = ngate;
		CodTratta = codTratta;
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
	
}
