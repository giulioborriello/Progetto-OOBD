package DAO;


import Entità.CodaDiImbarco;

public interface CodaDiImbarcoDAO {
	
	
	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda);
	
	public CodaDiImbarco getCodaDiImbarcoByNgate(String Ngate, String data);
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(String CodSlot, String data);
	
	public String insertCodaDiImbarco(String CodCoda, String Tipo_di_coda, String Ngate, String CodSlot);
	
	public String deleteCodaDiImbarco(String CodCoda);
	
}
