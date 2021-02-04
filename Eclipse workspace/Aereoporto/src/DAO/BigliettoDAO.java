package DAO;

import java.util.List;

import Entità.Biglietto;

public interface BigliettoDAO {
	
	public List<Biglietto> getBigliettoByCodFiscale(String CodFiscale);

	public List<Biglietto> getBigliettoByCodTratta(String CodTratta);
	
	
	public String insertBiglietto(String CodFiscale, String TipoDiBiglietto, String CodBiglietto, String CodTratta, String Posto);
	
	
	public String deleteBiglietto(String CodBiglietto);
	
}
