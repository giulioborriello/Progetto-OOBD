package GUI;
import java.sql.Connection;
import java.util.List;

import DAOPostgres.*;
import Entit�.Slot;
import GUI.Men�GUI;
import GUI.SlotGUI;

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
	
	RisultatiGateGUI risultatiGate;
	
	
	
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
		men�.setVisible(false);
		slot.setVisible(true);
	
	}
	
	public void openGate() {
		men�.setVisible(false);
		gate.setVisible(true);
	
	}
	
	public void openTratta() {
		men�.setVisible(false);
		tratta.setVisible(true);
	
	}
	
	public void openFedelt�() {
		men�.setVisible(false);
		fedelt�.setVisible(true);
	
	}
	
	public void openCompagnia() {
		men�.setVisible(false);
		compagnia.setVisible(true);
	
	}
	
	public void openCodaDiImbarco() {
		men�.setVisible(false);
		codaDiImbarco.setVisible(true);
	
	}
	
	public void openCliente() {
		men�.setVisible(false);
		cliente.setVisible(true);
	
	}
	
	public void openBiglietto() {
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

	public void openRisultatiGate() {
		
		GateDAOPostgres gatePostgres = new GateDAOPostgres(conn);
		RisultatiGateGUI risultatiGate = new RisultatiGateGUI(gatePostgres.getAllGate());
		gate.setVisible(false);
		risultatiGate.setVisible(true);
		
	}
	
}


