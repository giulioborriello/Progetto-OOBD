package DAO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Entità.Slot;

public interface SlotDAO {

	public Slot getSlotByCodSlot(String CodSlot);
	public Slot getSlotByCodCoda(String CodCoda);
	public List<Slot> getSlotByData(String Data);
	public String insertSlot(String CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo, Date Data, Time OrarioDiPartenza);
	public String updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, String CodSlot);
	public String deleteSlot(String CodSlot);
	
}
