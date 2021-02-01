package DAO;


import java.sql.Date;

import Entità.CodaDiImbarco;

public interface CodaDiImbarcoDAO {
	
	
	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda);
	
	public CodaDiImbarco getCodaDiImbarcoByNgate(String Ngate, Date data);
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(String CodSlot, Date data);
	
	public String insertCodaDiImbarco(String CodCoda, String Tipo_di_coda, String Ngate, String CodSlot);
	
	public String deleteCodaDiImbarco(String CodCoda);
	
}
