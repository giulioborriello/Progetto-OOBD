import java.util.List;

import DAOPostgres.*;
import Entit�.Slot;
import GUI.Men�;
import GUI.SlotGUI;

public class Controller {
	Men� men�;
	SlotGUI slot;
	
	public Controller() {
		men� = new Men�(this);
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


