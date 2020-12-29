package GUI;
import java.util.List;

import DAOPostgres.*;
import Entit�.Slot;
import GUI.Men�GUI;
import GUI.SlotGUI;

public class Controller {
	SlotGUI slot;
	Men�GUI men�;
	GateGUI gate;
	TrattaGUI tratta;
	Fedelt�GUI fedelt�;
	CompagniaGUI compagnia;
	CodaDiImbarcoGUI codaDiImbarco;
	ClienteGUI cliente;
	BigliettoGUI biglietto;
	
	
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
	}
	
	public void OpenSlot() {
		men�.setVisible(false);
		slot.setVisible(true);
	
	}
	
	public void OpenGate() {
		men�.setVisible(false);
		gate.setVisible(true);
	
	}
	
	public void OpenTratta() {
		men�.setVisible(false);
		tratta.setVisible(true);
	
	}
	
	public void OpenFedelt�() {
		men�.setVisible(false);
		fedelt�.setVisible(true);
	
	}
	
	public void OpenCompagnia() {
		men�.setVisible(false);
		compagnia.setVisible(true);
	
	}
	
	public void OpenCodaDiImbarco() {
		men�.setVisible(false);
		codaDiImbarco.setVisible(true);
	
	}
	
	public void OpenCliente() {
		men�.setVisible(false);
		cliente.setVisible(true);
	
	}
	
	public void OpenBiglietto() {
		men�.setVisible(false);
		biglietto.setVisible(true);
	
	}
	
}


