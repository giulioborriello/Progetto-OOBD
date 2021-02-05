package DAO;


import java.sql.Date;

import Entità.CodaDiImbarco;

public interface CodaDiImbarcoDAO {
	
	
	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda);
	public CodaDiImbarco getCodaDiImbarcoByCodGate(String CodGate);
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(String CodSlot);
	
	
	public String insertCodaDiImbarco(String CodCoda, String Tipo_di_coda, String Ngate);
	
	
	public String deleteCodaDiImbarco(String CodCoda);
	
}
