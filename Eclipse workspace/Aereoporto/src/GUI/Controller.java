package GUI;
import java.util.List;

import DAOPostgres.*;
import Entit�.Slot;
import GUI.Men�GUI;
import GUI.SlotGUI;

public class Controller {
	SlotGUI slot;
	Men�GUI men�;
	public Controller() {
		men� = new Men�GUI(this);
		men�.setVisible(true);
		slot = new SlotGUI();
	}
	
	public static void main(String[] args) {

	Controller controller = new Controller();
	}
	
	public void OpenSlot() {
		men�.setVisible(false);
		slot.setVisible(true);
		
	
	
	}
	
	
	
	
}


