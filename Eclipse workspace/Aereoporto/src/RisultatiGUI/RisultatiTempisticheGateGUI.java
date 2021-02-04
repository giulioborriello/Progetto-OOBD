package RisultatiGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControllerPackage.Controller;
import Entità.Tempistica;

public class RisultatiTempisticheGateGUI extends JFrame {
	
	private Controller controller;
	private JPanel contentPane;
	
	private JTable table;
	
	
	public RisultatiTempisticheGateGUI(List<Tempistica> list, Controller c, String scelta) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		Vector<String> columns = new Vector<String>();
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		if (scelta.equals("Giorni")) {

			columns.add("Anno");
			columns.add("Mese");
			columns.add("Giorno");		
			columns.add("Tempistica");
			
			
			
			for (Tempistica valori : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(valori.getAnno());
				vector.add(valori.getMese());
				vector.add(valori.getGiorno());	
				vector.add(valori.getValore());
				data.add(vector);
			}
		} 
		else if(scelta.equals("Settimane")) {
			
			columns.add("Anno");
			columns.add("Settimana");
			columns.add("Tempistica");
			
			
			for (Tempistica valori : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(valori.getAnno());
				vector.add(valori.getSettimana());
				vector.add(valori.getValore());	
				data.add(vector);
			}
		}
		else if(scelta.equals("Mesi")) {
			
			columns.add("Anno");
			columns.add("Mese");
			columns.add("Tempistica");	
			
			
			for (Tempistica valori : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(valori.getAnno());
				vector.add(valori.getMese());
				vector.add(valori.getValore());	
				data.add(vector);
			}
		}
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setLocation(114, 11);
		scrollpane.setSize(425, 347);
		
		table = new JTable(new DefaultTableModel(data, columns));
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(114, 11, 425, 347);
		
		scrollpane.setViewportView(table);
		contentPane.add(scrollpane);
 	    
 	    JButton btnNewButton_3 = new JButton("Torna indietro ");
 	    btnNewButton_3.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent arg0) {
 	    		controller.openGate();
 	    	}
 	    });
 	    btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
 	    btnNewButton_3.setBounds(749, 351, 180, 57);
 	    contentPane.add(btnNewButton_3);
	
	
	
	}
}
