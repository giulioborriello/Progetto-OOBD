package DAO;

public interface ClienteDAO {

	public void getAllCliente();
	
	public void getClienteByCodFiscale(String CodFiscale);
	
	public void insertCliente(String CodFiscale, String Nome, String Cognome, String Email);
	
	public void updateEmailByCodFiscale(String Email, String CodFiscale);
	
	
	
}
