package RisultatiGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Entità.Tempistica;
import GUI.Controller;

public class RisultatiTempisticheGateGUI extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	public RisultatiTempisticheGateGUI(List<Tempistica> list, Controller c, String scelta) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		if (scelta.equals("Giorni")) {
			for (Tempistica valori : list) {
				listModel.addElement(valori.getAnno() + " " + valori.getMese() + " " + valori.getGiorno() + " " + valori.getValore() );
			}
		} 
		else if(scelta.equals("Settimane")) {
			for (Tempistica valori : list) {
				listModel.addElement(valori.getAnno() + " " + valori.getSettimana() + " " + valori.getValore() );
			}
		}
		else if(scelta.equals("Mesi")) {
			for (Tempistica valori : list) {
				listModel.addElement(valori.getAnno() + " " + valori.getMese() + " " + valori.getValore() );
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
