package DAO;

import java.util.List;

import Entità.Biglietto;
import Entità.Slot;

public interface BigliettoDAO {
	
	public List<Biglietto> getAllBiglietto();
	
	public List<Biglietto> getBigliettoByCodFiscale(String CodFiscale);

	public List<Biglietto> getBigliettoByCodTratta(String CodTratta);
	
	public void insertBiglietto(String CodFiscale, String Tipo_di_biglietto, String CodBiglietto, String CodTratta, String Posto);
	
	
}
