package GUI;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import DAOPostgres.*;
import Entit�.Biglietto;
import Entit�.Cliente;
import Entit�.CodaDiImbarco;
import Entit�.Compagnia;
import Entit�.Fedelt�;
import Entit�.Gate;
import Entit�.Slot;
import Entit�.Tratta;
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
	
	

	public void openRisultatiGate(String ricerca, String valore) {
		
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
	
	public void openRisultatiTratta(String ricerca, String valore) {
		
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
	
	public void openRisultatiSlot(String ricerca, String valore) {
		
		SlotDAOPostgres slotPostgres = new SlotDAOPostgres(conn);
		List<Slot> list = null;
		if (ricerca == "Seleziona tutti") {
			list = slotPostgres.getAllSlot();
		}
		
		else if(ricerca == "CodSlot") {
			list = slotPostgres.getAllSlot();
		}
	
		else if(ricerca == "CodCoda") {
			list = (List<Slot>) slotPostgres.getSlotByCodCoda(Integer.valueOf(valore));
			
		}
		
		else if(ricerca == "Data") {
			list = slotPostgres.getSlotByData(valore);
		}
		
		risultatiSlot = new RisultatiSlotGUI(list, this);
		slot.setVisible(false);
		risultatiSlot.setVisible(true);
				
	}
	
	public void openRisultatiFedelt�(String ricerca, String valore) {
		
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
	
	public void openRisultatiCompagnia(String ricerca, String valore) {
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
		
	public void openRisultatiCodaDiImbarco(String ricerca, String valore) {
		CodaDiImbarcoDAOPostgres codaDiImbarcoPostgres = new CodaDiImbarcoDAOPostgres(conn);
		List<CodaDiImbarco> list = null;
		
		if (valore == "seleziona tutti") {
			list = codaDiImbarcoPostgres.getAllCodaDiImbarco();	
		}
		
		else if(valore == "CodCoda") {
			list =  (List<CodaDiImbarco>) codaDiImbarcoPostgres.getCodaDiImbarcoByCodCoda(valore);
		}
		
		else if(valore == "CodSlot") {
			list = (List<CodaDiImbarco>) codaDiImbarcoPostgres.getCodaDiImbarcoByCodSlot(Integer.valueOf(valore));
		}
	
		else if(valore == "N gate") {
			list = (List<CodaDiImbarco>) codaDiImbarcoPostgres.getCodaDiImbarcoByNgate(valore);
		}
		risultatiCodaDiImbarco = new RisultatiCodaDiImbarcoGUI(list, this);
		codaDiImbarco.setVisible(false);
		risultatiCodaDiImbarco.setVisible(true);
	
	}
	
	
	
	
	public void openRisultatiCliente(String ricerca, String valore) {
		ClienteDAOPostgres clientePostgres = new ClienteDAOPostgres(conn);
		List<Cliente> list = null;
		if (valore == "Seleziona tutti") {
			list = clientePostgres.getAllCliente();	
		}
		
		else if (valore == "Codice Fiscale") {
			list.add(clientePostgres.getClienteByCodFiscale(valore));	
		}
		risultatiCliente = new RisultatiClienteGUI(list, this);
		cliente.setVisible(false);
		risultatiCliente.setVisible(true);
	}
	
	
	
	public void openRisultatiBiglietto(String ricerca, String valore) {
		BigliettoDAOPostgres biglietto = new BigliettoDAOPostgres(conn);
		List<Biglietto> list = null;
		
		if (valore == "Seleziona tutti") {
			list = biglietto.getAllBiglietto();	
		}
		else if(valore == "Codice Fiscale") {
			list = biglietto.getBigliettoByCodFiscale(valore);
		}
		else if(valore == "Codice Tratta") {
			list = biglietto.getBigliettoByCodTratta(valore);
		}
	}
	
	public void inserisciTratta(String codTratta, int nPrenotazioni,String orarioDiPartenza, String data, int nGate, String CodIATA, String destinazione, String scali) throws ParseException{
		
		Time tempo = java.sql.Time.valueOf(orarioDiPartenza);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(data);
		Date sqlDate = new java.sql.Date(date.getTime());  
		TrattaDAOPostgres tratta = new TrattaDAOPostgres(conn);
		tratta.insertTratta(codTratta, nPrenotazioni, tempo, sqlDate, nGate, CodIATA, destinazione, scali);
	}
	
}


