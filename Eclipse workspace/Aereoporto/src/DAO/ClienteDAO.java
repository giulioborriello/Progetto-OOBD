package DAO;

import java.util.List;

import Entità.Cliente;

public interface ClienteDAO {

	public List<Cliente> getAllCliente();
	
	public List<Cliente> getClienteByCodFiscale(String CodFiscale);
	
	public void insertCliente(String CodFiscale, String Nome, String Cognome, String Email);
	
	public void updateEmailByCodFiscale(String Email, String CodFiscale);
	
	
	
}
