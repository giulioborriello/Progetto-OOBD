package DAO;

import java.util.List;

import Entit‡.Fedelt‡;

public interface FedeltaDAO {
	public List<Fedelt‡> getAllFedelt‡();
	public List<Fedelt‡> getFedelt‡ByCentoKilometri(String Centokilometri);
	public List<Fedelt‡> getFedelt‡ByCodIATA(String CodIATA);
	public List<Fedelt‡> getFedelt‡ByCodFiscale(String CodFiscale);
	public void insertFedelt‡(int CentoKilometri, String CodIATA,String CodFiscale , int Punti);
	public void updateCentoKilometriByCodFiscaleANDCodIATA(int CentoKilometri, String CodFiscale, String CodIATA);
	public void updatePuntiByCentoKilometriANDCodIATA(int CentoKilometri, int Punti, String CodIATA);
}
