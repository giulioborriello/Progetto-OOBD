package DAO;


public interface CodaDiImbarcoDAO {
	
	public void getAllCodaDiImbarco();
	
	public void getCodaDiImbarcoByCodCoda(String CodCoda);
	
	public void getCodaDiImbarcoByNgate(String Ngate);
	
	public void getCodaDiImbarcoByCodSlot(String CodSlot);
	
	public void insertCodaDiImbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot);
	
	
}
