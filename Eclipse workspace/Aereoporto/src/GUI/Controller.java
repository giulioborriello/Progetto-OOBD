package GUI;
import java.sql.Connection;
import java.util.List;

import DAOPostgres.*;
import Entit�.Cliente;
import Entit�.CodaDiImbarco;
import Entit�.Compagnia;
import Entit�.Fedelt�;
import Entit�.Gate;
import Entit�.Slot;
import Entit�.Tratta;
import GUI.Men�GUI;
import GUI.SlotGUI;
import RisultatiGUI.RisultatiBigliettoGUI;
import RisultatiGUI.RisultatiClienteGUI;
import RisultatiGUI.RisultatiCodaDiImbarcoGUI;
import RisultatiGUI.RisultatiCompagniaGUI;
import RisultatiGUI.RisultatiFedelt�GUI;
import RisultatiGUI.RisultatiGateGUI;
import RisultatiGUI.RisultatiSlotGUI;
import RisultatiGUI.RisultatiTrattaGUI;

public class Controller {
	static Connection conn;
	
	SlotGUI slot;
	Men�GUI men�;
	GateGUI gate;
	TrattaGUI tratta;
	Fedelt�GUI fedelt�;
	CompagniaGUI compagnia;
	CodaDiImbarcoGUI codaDiImbarco;
	ClienteGUI cliente;
	BigliettoGUI biglietto;
	RisultatiSlotGUI risultatiSlot;
	RisultatiGateGUI risultatiGate;
	RisultatiTrattaGUI risultatiTratta;
	RisultatiFedelt�GUI risultatiFedelt�;
	RisultatiCompagniaGUI risultatiCompagnia;
	RisultatiCodaDiImbarcoGUI risultatiCodaDiImbarco;
	RisultatiClienteGUI risultatiCliente;
	RisultatiBigliettoGUI risultatiBiglietto;
	
	
	
	
	
	
	public Controller() {
		men� = new Men�GUI(this);
		men�.setVisible(true);
		slot = new SlotGUI(this);
		tratta = new TrattaGUI(this);
		fedelt� = new Fedelt�GUI(this);
		compagnia = new CompagniaGUI(this);
		codaDiImbarco = new CodaDiImbarcoGUI(this);
		cliente = new ClienteGUI(this);
		biglietto = new BigliettoGUI(this);
		gate = new GateGUI(this);
		
		 
	}
	
	public static void main(String[] args) {

	Controller controller = new Controller();
	SingletonPostgres instanza = SingletonPostgres.getInstance();
	conn = instanza.getConnection();
	}
	
	public void openSlot() {
		if(risultatiSlot != null) {
			risultatiSlot.setVisible(false);
		}
		men�.setVisible(false);
		slot.setVisible(true);
	
	}
	
	public void openGate() {
		if(risultatiGate != null) {
			risultatiGate.setVisible(false);
		}
		men�.setVisible(false);
		gate.setVisible(true);
		 
	
	}
	
	public void openTratta() {
		if(risultatiTratta != null) {
			risultatiTratta.setVisible(false);
		}
		men�.setVisible(false);
		tratta.setVisible(true);
	
	}
	
	public void openFedelt�() {
		if(risultatiFedelt� != null) {
			risultatiFedelt�.setVisible(false);
		}
		men�.setVisible(false);
		fedelt�.setVisible(true);
	
	}
	
	public void openCompagnia() {
		if(risultatiCompagnia != null) {
			risultatiCompagnia.setVisible(false);
		}
		men�.setVisible(false);
		compagnia.setVisible(true);
	
	}
	
	public void openCodaDiImbarco() {
		if(risultatiCodaDiImbarco != null) {
			risultatiCodaDiImbarco.setVisible(false);
		}
		men�.setVisible(false);
		codaDiImbarco.setVisible(true);
	
	}
	
	public void openCliente() {
		if(risultatiCliente != null) {
			risultatiCliente.setVisible(false);
		}
		men�.setVisible(false);
		cliente.setVisible(true);
	
	}
	
	public void openBiglietto() {
		if(risultatiBiglietto != null) {
			risultatiBiglietto.setVisible(false);
		}
		men�.setVisible(false);
		biglietto.setVisible(true);
	
	}
	
	public void backToMen�() {
		biglietto.setVisible(false);
		cliente.setVisible(false);
		codaDiImbarco.setVisible(false);
		compagnia.setVisible(false);
		fedelt�.setVisible(false);
		tratta.setVisible(false);
		gate.setVisible(false);
		slot.setVisible(false);
		men�.setVisible(true);
	}
	
	

	public void openRisultatiGate(String valore, String ricerca) {
		
		GateDAOPostgres gatePostgres = new GateDAOPostgres(conn);
		List<Gate> list = null;
		if (ricerca == "Seleziona tutti") {
				list = gatePostgres.getAllGate();
		}
		else if(ricerca == "N gate") {
			list.add(gatePostgres.getGateByNgate(Integer.valueOf(valore)));
			
		}
		
		else if(ricerca == "CodTratta") {
			list.add(gatePostgres.getGateByCodTratta(valore));
		}
		
		risultatiGate = new RisultatiGateGUI(list, this);
		gate.setVisible(false);
		risultatiGate.setVisible(true);
		
	}
	
	public void openRisultatiTratta(String valore, String ricerca) {
		
		TrattaDAOPostgres trattaPostgres = new TrattaDAOPostgres(conn);
		
		List<Tratta> list = null;
		if (ricerca == "Seleziona tutti") {
			list = trattaPostgres.getAllTratta();
		}
		else if(ricerca == "CodTratta") {
			list.add(trattaPostgres.getTrattaByCodTratta(valore));
		
		}
	
		else if(ricerca == "Ngate") {
			list = (trattaPostgres.getTrattaNgate(valore));
		}
	
		else if(ricerca == "Data") {
			list = (trattaPostgres.getTrattaByData(valore));
		}
		
		else if(ricerca == "CodIATA") {
			list = (trattaPostgres.getTrattaCodIATA(valore));
		}
		
		else if(ricerca == "Destinazione") {
			list = (trattaPostgres.getTrattaDestinazione(valore));
		}	
		
		
		risultatiTratta = new RisultatiTrattaGUI(list, this);
		tratta.setVisible(false);
		risultatiTratta.setVisible(true);
		
	}
	
	public void openRisultatiSlot(String valore, String ricerca) {
		
		SlotDAOPostgres slotPostgres = new SlotDAOPostgres(conn);
		List<Slot> list = null;
		if (ricerca == "Seleziona tutti") {
			list = slotPostgres.getAllSlot();
		}
		
		else if(ricerca == "CodSlot") {
			list = slotPostgres.getAllSlot();
		}
	
		else if(ricerca == "CodCoda") {
			list.add(slotPostgres.getSlotByCodCoda(Integer.valueOf(valore)));
			
		}
		
		else if(ricerca == "Data") {
			list = slotPostgres.getSlotByData(valore);
		}
		
		risultatiSlot = new RisultatiSlotGUI(list, this);
		slot.setVisible(false);
		risultatiSlot.setVisible(true);
				
	}
	
	public void openRisultatiFedelt�(String valore, String ricerca) {
		
		Fedelt�DAOPostgres fedelt�Postgres = new Fedelt�DAOPostgres(conn);
		
		List<Fedelt�> list = null;
		if (ricerca == "Seleziona tutti") {
			list = fedelt�Postgres.getAllFedelt�();
		}
		
		else if(ricerca == "CentoKilometri") {
			list = fedelt�Postgres.getFedelt�ByCentoKilometri(valore);
		}
		
		else if(ricerca == "CodiATA") {
			list = fedelt�Postgres.getFedelt�ByCodIATA(valore);
		}
		
		else if(ricerca == "CodFiscale") {
			list = fedelt�Postgres.getFedelt�ByCodFiscale(valore);
		}
		
		risultatiFedelt� = new RisultatiFedelt�GUI(list, this);
		fedelt�.setVisible(false);
		risultatiFedelt�.setVisible(true);
		
	}
	
	public void openRisultatiCompagnia(String valore, String ricerca) {
		CompagniaDAOPostgres compagniaPostgres= new CompagniaDAOPostgres(conn);
		List<Compagnia> list = null;
		
		if (valore == "Seleziona tutti") {
			list = compagniaPostgres.getAllCompagnia();
		}
		
		else if(valore == "CodIATA") {
			list = (List<Compagnia>) compagniaPostgres.getCompagniaByCodIATA(valore);
		}
		
		else if(valore == "Nome Compagnia") {
			list = (List<Compagnia>) compagniaPostgres.getCompagniaByNomeCompagnia(valore);
		}
		risultatiCompagnia = new RisultatiCompagniaGUI(list, this);
		compagnia.setVisible(false);
		risultatiCompagnia.setVisible(true);
		
	}	
		
	public void openRisultatiCodaDiImbarco(String valore, String ricerca) {
		CodaDiImbarcoDAOPostgres codaDiImbarcoPostgres = new CodaDiImbarcoDAOPostgres(conn);
		List<CodaDiImbarco> list = null;
		
		if (valore == "seleziona tutti") {
			list = codaDiImbarcoPostgres.getAllCodaDiImbarco();	
		}
		
		else if(valore == "CodCoda") {
			list =  (List<CodaDiImbarco>) codaDiImbarcoPostgres.getCodaDiImbarcoByCodCoda(valore);
		}
		
		else if(valore == "CodSlot") {
			list.add(codaDiImbarcoPostgres.getCodaDiImbarcoByCodSlot(Integer.valueOf(valore)));
		}
	
		else if(valore == "N gate") {
			list = (List<CodaDiImbarco>) codaDiImbarcoPostgres.getCodaDiImbarcoByNgate(valore);
		}
	
	}
	
	public void openRisultatiCliente(String valore, String ricerca) {
		ClienteDAOPostgres clientePostgres = new ClienteDAOPostgres(conn);
		List<Cliente> list = null;
		if (valore == "seleziona tutti") {
			list = clientePostgres.getAllCliente();	
		}
		
		if (valore == "Codice Fiscale") {
			list = (List<Cliente>) clientePostgres.getClienteByCodFiscale(valore);	
		}
	}
	
	
	
	
	
	
	
}


