package Entità;

public class Fedeltà {
	private String centoKilometri;
	private int punti;
	private Compagnia Compagnia;
	private Cliente Cliente;

	
	public Fedeltà(String centoKilometri, int punti, Compagnia Compagnia, Cliente Cliente) {
		super();
		this.centoKilometri = centoKilometri;
		this.punti = punti;
		this.Compagnia = Compagnia;
		this.Cliente = Cliente;
	}

	public String getCentoKilometri() {
		return centoKilometri;
	}

	public void setCentoKilometri(String CentoKilometri) {
		centoKilometri = CentoKilometri;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int Punti) {
		punti = Punti;
	}

	public void setCodIATA(Compagnia codIATA) {
		this.Compagnia = codIATA;
	}

	public void setCodFiscale(Cliente codFiscale) {
		this.Cliente = codFiscale;
	}


	public Compagnia getCompagnia() {
		return Compagnia;
	}


	public Cliente getCliente() {
		return Cliente;
	}
}
