import java.util.List;

import DAOPostgres.*;
import Entit‡.Slot;

public class Main {

	public static void main(String[] args) {
		
		
		
//	TrattaDAO TDAO = new TrattaDAO(conn);
//	TDAO.insertTratta("A2", 0, Time.valueOf(LocalTime.of(0, 0, 0)), Date.valueOf(LocalDate.of(2021, 1, 1)), 1, "AL", "Milano");

//	BigliettoDAO BDAO = new BigliettoDAO(conn);
//	BDAO.insertBiglietto("abcd", "economy", "Bi", "A1", "A11");
	
//	Fedelt‡DAOPostgres FDAO = new Fedelt‡DAOPostgres();
//	FDAO.updateCentoKilometriByCodFiscaleANDCodIATA(22, "abcd", "AL");
	
	
	SlotDAOPostgres SDAO = new SlotDAOPostgres();
	List<Slot> list = SDAO.getAllSlot();
	
	for(Slot slot:list) {
		System.out.println(slot.getCodSlot());
		System.out.println(slot.getCodCoda());
		System.out.println(slot.getTempoDiImbarcoEffettivo());
		System.out.println(slot.getTempoDiImbarcoStimato());
	}
	
//	GateDAO GDAO = new GateDAO(conn);
//	GDAO.updateCodTrattaByNgate("A1", 1);
	
//	ClienteDAO CDAO = new ClienteDAO(conn);
//	CDAO.updateEmailByCodFiscale("swagBoy", "abcd");
//	
	
	}
}


