package DAO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Entit�.Slot;

public interface SlotDAO {

	public List<Slot> getAllSlot();
	public Slot getSlotByCodSlot(int CodSlot);
	public Slot getSlotByCodCoda(int CodCoda);
	public List<Slot> getSlotByData(String Data);
	public String insertSlot(int CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo, Date Data, Time OrarioDiPartenza);
	public String updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, int CodSlot);
	public String deleteSlot(int CodSlot);
	
}
