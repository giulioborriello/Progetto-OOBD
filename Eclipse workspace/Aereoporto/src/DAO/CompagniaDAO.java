package DAO;

import java.util.List;

import Entità.Compagnia;

public interface CompagniaDAO {
	
	public List<Compagnia> getAllCompagnia();
	
	public Compagnia getCompagniaByCodIATA(String CodIATA);
	
	public Compagnia getCompagniaByNomeCompagnia(String Nome);
	
	public String insertCompagnia(String CodIATA, String Nome_compagnia);
	
	public String deleteCompagnia(String CodIATA);
}
