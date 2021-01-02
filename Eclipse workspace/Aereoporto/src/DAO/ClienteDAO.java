package DAO;

import java.util.List;

import Entità.Cliente;

public interface ClienteDAO {

	public List<Cliente> getAllCliente();
	
	public Cliente getClienteByCodFiscale(String CodFiscale);
	
	public String insertCliente(String CodFiscale, String Nome, String Cognome, String Email);
	
	public String updateEmailByCodFiscale(String Email, String CodFiscale);
	
	public String deleteCliente(String CodFiscale);
	
}
