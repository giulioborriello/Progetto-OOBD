package DAO;

import java.util.List;

import Entit‡.Fedelt‡;

public interface FedeltaDAO {
	
	public List<Fedelt‡> getFedelt‡ByCentoKilometri(String Centokilometri);
	public List<Fedelt‡> getFedelt‡ByCodIATA(String CodIATA);
	public List<Fedelt‡> getFedelt‡ByCodFiscale(String CodFiscale);
	public String insertFedelt‡(String CentoKilometri, String CodIATA,String CodFiscale);
	public String updateCentoKilometriByCodFiscaleANDCodIATA(String CentoKilometri, String CodFiscale, String CodIATA);
	public String updatePuntiByCentoKilometriANDCodIATA(String CentoKilometri, int Punti, String CodIATA);
	public String deleteFedelt‡(String CodFiscale);
}
