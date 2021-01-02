package DAO;

import java.util.List;

import Entità.CodaDiImbarco;

public interface CodaDiImbarcoDAO {
	
	public List<CodaDiImbarco> getAllCodaDiImbarco();
	
	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda);
	
	public CodaDiImbarco getCodaDiImbarcoByNgate(String Ngate);
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(int CodSlot);
	
	public String insertCodaDiImbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot);
	
	
}
