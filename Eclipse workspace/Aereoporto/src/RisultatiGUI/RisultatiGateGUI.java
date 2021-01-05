package RisultatiGUI;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entità.Gate;
import GUI.Controller;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiGateGUI extends JFrame {

	private Controller controller;
	
	private JPanel contentPane;

	public RisultatiGateGUI(List<Gate> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Gate");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(Gate gate: list) {
			String[] astring = {String.valueOf(gate.getNgate()), gate.getCodTratta()};
			listModel.addElement(astring[0] + " " + astring[1]);
			
		}
		
		JList jlist = new JList(listModel);
 	    jlist.setLocation(62, 49);
 	    jlist.setSize(400, 363);
 	    contentPane.add(jlist);
 	    
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
