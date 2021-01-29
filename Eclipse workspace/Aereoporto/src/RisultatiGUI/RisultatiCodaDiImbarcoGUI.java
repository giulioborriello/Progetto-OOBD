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

import ControllerPackage.Controller;
import Entità.CodaDiImbarco;

public class RisultatiCodaDiImbarcoGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;

	public RisultatiCodaDiImbarcoGUI(List<CodaDiImbarco> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Coda Di Imbarco");		
		setResizable(false);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		String titoli = "Codice Coda " + "Tipo Di Coda " + "Codice Gate "+ "CodSlot ";
		listModel.addElement(titoli);
		
		
		for(CodaDiImbarco coda: list) {
			String string = coda.getCodCoda()+ " " + coda.getTipoDiCoda() + " " + coda.getGate().getCodGate() + " " +
					coda.getSlot().getCodSlot();
			listModel.addElement(string);
			
		}
		
		
		JList jlist = new JList(listModel);
 	    jlist.setLocation(62, 49);
 	    jlist.setSize(772, 363);
 	    contentPane.add(jlist);
 	    
 	    JButton btnNewButton_3 = new JButton("Torna indietro ");
 	    btnNewButton_3.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent arg0) {
 	    		controller.openCodaDiImbarco();
 	    	}
 	    });
 	   btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    btnNewButton_3.setBounds(62, 452, 180, 57);
	    contentPane.add(btnNewButton_3);
		
	}

}
