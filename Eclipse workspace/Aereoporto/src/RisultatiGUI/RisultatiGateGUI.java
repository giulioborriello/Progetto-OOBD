package RisultatiGUI;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControllerPackage.Controller;
import Entità.Gate;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiGateGUI extends JFrame {

	private Controller controller;
	
	private JPanel contentPane;
	private JTable table;
	
	public RisultatiGateGUI(List<Gate> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Gate");
		setResizable(false);
		
		
		Vector<String> columns = new Vector<String>();
		columns.add("Codice Gate");
		columns.add("N° Gate");
		columns.add("Codice Tratta Corrispondente");		
		columns.add("Data");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		for(Gate gate: list) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(gate.getCodGate());
			vector.add(gate.getnGate());
			vector.add(gate.getTratta().getCodTratta());	
			vector.add(gate.getData());
			data.add(vector);
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
 	    btnNewButton_3.setBounds(62, 452, 180, 57);
 	    contentPane.add(btnNewButton_3);
 	     
	}
}
