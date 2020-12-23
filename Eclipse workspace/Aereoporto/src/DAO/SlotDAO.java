package DAO;

import java.sql.Date;

public interface SlotDAO {

	public void getAllSlot();
	public void getSlotByCodSlot(String CodSlot);
	public void getSlotByCodCoda(String CodCoda);
	public void getSlotByData(String Data);
	public void insertSlot(int CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo, int CodCoda, Date Data);
	public void updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, int CodSlot);
	
	
}
