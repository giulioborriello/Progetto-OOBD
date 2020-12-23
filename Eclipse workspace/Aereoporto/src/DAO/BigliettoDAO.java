package DAO;

public interface BigliettoDAO {
	
	public void getAllBiglietto();
	
	public void getBigliettoByCodFiscale(String CodFiscale);

	public void getBigliettoByCodTratta(String CodTratta);
	
	public void insertBiglietto(String CodFiscale, String Tipo_di_biglietto, String CodBiglietto, String CodTratta, String Posto);
	
	
}
