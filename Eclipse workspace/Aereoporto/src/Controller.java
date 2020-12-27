import java.util.List;

import DAOPostgres.*;
import Entità.Slot;
import GUI.Menù;
import GUI.SlotGUI;

public class Controller {
	Menù menù;
	SlotGUI slot;
	
	public Controller() {
		menù = new Menù(this);
		menù.setVisible(true);
		slot = new SlotGUI();
	}
	
	public static void main(String[] args) {

	Controller controller = new Controller();

	}
	
	public void OpenSlot() {
		menù.setVisible(false);
		slot.setVisible(true);
		
	
	
	}
	
	
	
	
}


