package GUI;
import java.sql.Connection;
import java.util.List;

import DAOPostgres.*;
import Entità.Cliente;
import Entità.CodaDiImbarco;
import Entità.Compagnia;
import Entità.Fedeltà;
import Entità.Gate;
import Entità.Slot;
import Entità.Tratta;
import GUI.MenùGUI;
import GUI.SlotGUI;
import RisultatiGUI.RisultatiBigliettoGUI;
import RisultatiGUI.RisultatiClienteGUI;
import RisultatiGUI.RisultatiCodaDiImbarcoGUI;
import RisultatiGUI.RisultatiCompagniaGUI;
import RisultatiGUI.RisultatiFedeltàGUI;
import RisultatiGUI.RisultatiGateGUI;
import RisultatiGUI.RisultatiSlotGUI;
import RisultatiGUI.RisultatiTrattaGUI;

public class Controller {
	static Connection conn;
	
	SlotGUI slot;
	MenùGUI menù;
	GateGUI gate;
	TrattaGUI tratta;
	FedeltàGUI fedeltà;
	CompagniaGUI compagnia;
	CodaDiImbarcoGUI codaDiImbarco;
	ClienteGUI cliente;
	BigliettoGUI biglietto;
	RisultatiSlotGUI risultatiSlot;
	RisultatiGateGUI risultatiGate;
	RisultatiTrattaGUI risultatiTratta;
	RisultatiFedeltàGUI risultatiFedeltà;
	RisultatiCompagniaGUI risultatiCompagnia;
	RisultatiCodaDiImbarcoGUI risultatiCodaDiImbarco;
	RisultatiClienteGUI risultatiCliente;
	RisultatiBigliettoGUI risultatiBiglietto;
	
	
	
	
	
	
	public Controller() {
		menù = new MenùGUI(this);
		menù.setVisible(true);
		slot = new SlotGUI(this);
		tratta = new TrattaGUI(this);
		fedeltà = new FedeltàGUI(this);
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
		menù.setVisible(false);
		slot.setVisible(true);
	
	}
	
	public void openGate() {
		if(risultatiGate != null) {
			risultatiGate.setVisible(false);
		}
		menù.setVisible(false);
		gate.setVisible(true);
		 
	
	}
	
	public void openTratta() {
		if(risultatiTratta != null) {
			risultatiTratta.setVisible(false);
		}
		menù.setVisible(false);
		tratta.setVisible(true);
	
	}
	
	public void openFedeltà() {
		if(risultatiFedeltà != null) {
			risultatiFedeltà.setVisible(false);
		}
		menù.setVisible(false);
		fedeltà.setVisible(true);
	
	}
	
	public void openCompagnia() {
		if(risultatiCompagnia != null) {
			risultatiCompagnia.setVisible(false);
		}
		menù.setVisible(false);
		compagnia.setVisible(true);
	
	}
	
	public void openCodaDiImbarco() {
		if(risultatiCodaDiImbarco != null) {
			risultatiCodaDiImbarco.setVisible(false);
		}
		menù.setVisible(false);
		codaDiImbarco.setVisible(true);
	
	}
	
	public void openCliente() {
		if(risultatiCliente != null) {
			risultatiCliente.setVisible(false);
		}
		menù.setVisible(false);
		cliente.setVisible(true);
	
	}
	
	public void openBiglietto() {
		if(risultatiBiglietto != null) {
			risultatiBiglietto.setVisible(false);
		}
		menù.setVisible(false);
		biglietto.setVisible(true);
	
	}
	
	public void backToMenù() {
		biglietto.setVisible(false);
		cliente.setVisible(false);
		codaDiImbarco.setVisible(false);
		compagnia.setVisible(false);
		fedeltà.setVisible(false);
		tratta.setVisible(false);
		gate.setVisible(false);
		slot.setVisible(false);
		menù.setVisible(true);
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
	
	public void openRisultatiFedeltà(String valore, String ricerca) {
		
		FedeltàDAOPostgres fedeltàPostgres = new FedeltàDAOPostgres(conn);
		
		List<Fedeltà> list = null;
		if (ricerca == "Seleziona tutti") {
			list = fedeltàPostgres.getAllFedeltà();
		}
		
		else if(ricerca == "CentoKilometri") {
			list = fedeltàPostgres.getFedeltàByCentoKilometri(valore);
		}
		
		else if(ricerca == "CodiATA") {
			list = fedeltàPostgres.getFedeltàByCodIATA(valore);
		}
		
		else if(ricerca == "CodFiscale") {
			list = fedeltàPostgres.getFedeltàByCodFiscale(valore);
		}
		
		risultatiFedeltà = new RisultatiFedeltàGUI(list, this);
		fedeltà.setVisible(false);
		risultatiFedeltà.setVisible(true);
		
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


