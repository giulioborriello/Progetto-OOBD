package Entità;

public class Gate {

	int Ngate;
	String CodTratta;
	
	public Gate(int Ngate, String CodTratta) {
		this.Ngate = Ngate;
		this.CodTratta = CodTratta;
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
