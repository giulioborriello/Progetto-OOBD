package Entità;

public class Fedeltà {
	private int CentoKilometri;
	private String CodIATA;
	private String CodFiscale;
	private int Punti;
	private Cliente cliente;
	private Compagnia compagnia;

	public Fedeltà(int centoKilometri, String codIATA, String codFiscale, int punti, Cliente cliente,
			Compagnia compagnia) {
		super();
		CentoKilometri = centoKilometri;
		CodIATA = codIATA;
		CodFiscale = codFiscale;
		Punti = punti;
		this.cliente = cliente;
		this.setCompagnia(compagnia);
	}

	public int getCentoKilometri() {
		return CentoKilometri;
	}

	public void setCentoKilometri(int centoKilometri) {
		CentoKilometri = centoKilometri;
	}

	public String getCodIATA() {
		return CodIATA;
	}

	public void setCodIATA(String codIATA) {
		CodIATA = codIATA;
	}

	public String getCodFiscale() {
		return CodFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		CodFiscale = codFiscale;
	}

	public int getPunti() {
		return Punti;
	}

	public void setPunti(int punti) {
		Punti = punti;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Compagnia getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(Compagnia compagnia) {
		this.compagnia = compagnia;
	}
	
	
	
	
	
}
