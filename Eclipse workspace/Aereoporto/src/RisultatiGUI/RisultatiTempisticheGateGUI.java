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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

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
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		if (scelta.equals("Giorni")) {
			
			String titoli = "Anno " + "Mese " + "Giorno "+ "Tempistica ";
			listModel.addElement(titoli);
			for (Tempistica valori : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(coda.getCodCoda());
				vector.add(coda.getTipoDiCoda());
				vector.add(coda.getGate().getCodGate());	
				vector.add(coda.getSlot().getCodSlot());
				data.add(vector);
			}
		} 
		else if(scelta.equals("Settimane")) {
			
			String titoli = "Anno " + "Settimana " + "Tempistica ";
			listModel.addElement(titoli);
			for (Tempistica valori : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(coda.getCodCoda());
				vector.add(coda.getTipoDiCoda());
				vector.add(coda.getGate().getCodGate());	
				vector.add(coda.getSlot().getCodSlot());
				data.add(vector);
			}
		}
		else if(scelta.equals("Mesi")) {
			String titoli = "Anno " + "Mese " + "Tempistica ";
			listModel.addElement(titoli);
			for (Tempistica valori : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(coda.getCodCoda());
				vector.add(coda.getTipoDiCoda());
				vector.add(coda.getGate().getCodGate());	
				vector.add(coda.getSlot().getCodSlot());
				data.add(vector);
			}
		}
		
		JList jlist = new JList(listModel);
 	    jlist.setLocation(5, 5);
 	    jlist.setSize(726, 309);
 	    contentPane.add(jlist);
 	    
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
