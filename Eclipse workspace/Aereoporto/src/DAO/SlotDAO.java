package DAO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Entit�.CodaDiImbarco;
import Entit�.Slot;

public interface SlotDAO {

	
	public Slot getSlotByCodSlot(String CodSlot);
	public Slot getSlotByCodSlot(String CodSlot, CodaDiImbarco coda);
	public Slot getSlotByCodCoda(String CodCoda);
	
	public String insertSlot(String CodSlot, int TempoDiImbarcoStimato, String CodCoda);
	
	
	public String updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, String CodSlot);
	
	
	public String deleteSlot(String CodSlot);
	
}
