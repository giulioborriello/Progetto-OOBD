package Entità;

import java.sql.Date;

public class Gate {

	private String CodGate;
	private String nGate;
	private Tratta tratta;
	private Date data;
	
	

	public Gate( String codGate, String nGate, Tratta tratta, Date data) {
		super();
		setCodGate(codGate);
		this.setnGate(nGate);
		this.tratta = tratta;
		this.data = data;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta Tratta) {
		tratta = Tratta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}



	public String getCodGate() {
		return CodGate;
	}



	public void setCodGate(String codGate) {
		CodGate = codGate;
	}



	public String getnGate() {
		return nGate;
	}



	public void setnGate(String nGate) {
		this.nGate = nGate;
	}
	
	
	
}
