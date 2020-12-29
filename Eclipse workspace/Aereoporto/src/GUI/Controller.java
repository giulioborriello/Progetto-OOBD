package GUI;
import java.sql.Connection;
import java.util.List;

import DAOPostgres.*;
import Entità.Slot;
import GUI.MenùGUI;
import GUI.SlotGUI;

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
	
	RisultatiGateGUI risultatiGate;
	
	
	
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
		menù.setVisible(false);
		slot.setVisible(true);
	
	}
	
	public void openGate() {
		menù.setVisible(false);
		gate.setVisible(true);
	
	}
	
	public void openTratta() {
		menù.setVisible(false);
		tratta.setVisible(true);
	
	}
	
	public void openFedeltà() {
		menù.setVisible(false);
		fedeltà.setVisible(true);
	
	}
	
	public void openCompagnia() {
		menù.setVisible(false);
		compagnia.setVisible(true);
	
	}
	
	public void openCodaDiImbarco() {
		menù.setVisible(false);
		codaDiImbarco.setVisible(true);
	
	}
	
	public void openCliente() {
		menù.setVisible(false);
		cliente.setVisible(true);
	
	}
	
	public void openBiglietto() {
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

	public void openRisultatiGate() {
		
		GateDAOPostgres gatePostgres = new GateDAOPostgres(conn);
		RisultatiGateGUI risultatiGate = new RisultatiGateGUI(gatePostgres.getAllGate());
		gate.setVisible(false);
		risultatiGate.setVisible(true);
		
	}
	
}


