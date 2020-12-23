package DAO;

public interface FedeltaDAO {
	public void getAllFedelt‡();
	public void getFedelt‡ByCentoKilometri(String Centokilometri);
	public void getFedelt‡ByCodIATA(String CodIATA);
	public void getFedelt‡ByCodFiscale(String CodFiscale);
	public void insertFedelt‡(int CentoKilometri, String CodIATA,String CodFiscale , int Punti);
	public void updateCentoKilometriByCodFiscaleANDCodIATA(int CentoKilometri, String CodFiscale, String CodIATA);
	public void updatePuntiByCentoKilometriANDCodIATA(int CentoKilometri, int Punti, String CodIATA);
}
