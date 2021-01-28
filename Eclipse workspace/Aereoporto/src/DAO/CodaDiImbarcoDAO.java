package DAO;


import Entità.CodaDiImbarco;

public interface CodaDiImbarcoDAO {
	
	
	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda);
	
	public CodaDiImbarco getCodaDiImbarcoByNgate(String Ngate, String data);
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(int CodSlot, String data);
	
	public String insertCodaDiImbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot);
	
	public String deleteCodaDiImbarco(int CodCoda);
	
}
