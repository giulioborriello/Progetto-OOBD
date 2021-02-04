package DAO;

import java.util.List;

import Entità.Cliente;

public interface ClienteDAO {

	
	public Cliente getClienteByCodFiscale(String CodFiscale);
	public String insertCliente(String CodFiscale, String Nome, String Cognome, String Email);
	public String deleteCliente(String CodFiscale);
	
}
