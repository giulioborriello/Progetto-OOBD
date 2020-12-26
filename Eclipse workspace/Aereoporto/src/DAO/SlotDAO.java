package DAO;

import java.sql.Date;
import java.util.List;

import Entità.Slot;

public interface SlotDAO {

	public List<Slot> getAllSlot();
	public void getSlotByCodSlot(String CodSlot);
	public void getSlotByCodCoda(String CodCoda);
	public void getSlotByData(String Data);
	public void insertSlot(int CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo, int CodCoda, Date Data);
	public void updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, int CodSlot);
	
	
}
