package DAO;

import java.util.List;

import Entità.Compagnia;

public interface CompagniaDAO {
	public List<Compagnia> getAllCompagnia();
	public List<Compagnia> getCompagniaByCodIATA(String CodIATA);
	public List<Compagnia> getCompagniaByNomeCompagnia(String Nome);
	public void insertCompagnia(String CodIATA, String Nome_compagnia, String Sito_web);
	
}
