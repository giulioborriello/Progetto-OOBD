package DAO;

import java.util.List;

import Entit�.Cliente;

public interface ClienteDAO {
	
	public Cliente getClienteByCodFiscale(String CodFiscale);
	
	
	public String insertCliente(String CodFiscale, String Nome, String Cognome);
	
	
	public String deleteCliente(String CodFiscale);
	
}
