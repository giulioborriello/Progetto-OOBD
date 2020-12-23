package DAO;

public interface CompagniaDAO {
	public void getAllCompagnia();
	public void getCompagniaByCodIATA(String CodIATA);
	public void getCompagniaByNomeCompagnia(String Nome);
	public void insertCompagnia(String CodIATA, String Nome_compagnia, String Sito_web);
	
}
