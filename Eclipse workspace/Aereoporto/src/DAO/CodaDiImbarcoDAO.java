package DAO;

import java.sql.Date;
import java.util.List;

import Entità.CodaDiImbarco;

public interface CodaDiImbarcoDAO {
	
	
	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda);
	
	public CodaDiImbarco getCodaDiImbarcoByNgate(String Ngate, Date data);
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(int CodSlot, Date data);
	
	public String insertCodaDiImbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot);
	
	public String deleteCodaDiImbarco(int CodCoda);
	
}
