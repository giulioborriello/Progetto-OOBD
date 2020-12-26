package DAO;

import java.util.List;

import Entità.CodaDiImbarco;

public interface CodaDiImbarcoDAO {
	
	public List<CodaDiImbarco> getAllCodaDiImbarco();
	
	public List<CodaDiImbarco> getCodaDiImbarcoByCodCoda(String CodCoda);
	
	public List<CodaDiImbarco> getCodaDiImbarcoByNgate(String Ngate);
	
	public List<CodaDiImbarco> getCodaDiImbarcoByCodSlot(String CodSlot);
	
	public void insertCodaDiImbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot);
	
	
}
