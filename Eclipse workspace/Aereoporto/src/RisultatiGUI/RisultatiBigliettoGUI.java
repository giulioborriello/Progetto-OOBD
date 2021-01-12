package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;
import Entità.Biglietto;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiBigliettoGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	
	
	public RisultatiBigliettoGUI(List<Biglietto> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Biglietto");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		
		String titoli = "Codice Biglietto" + " " + "Posto" + " " + "Tipo" + " " + "Tratta" + " " + "Cliente";
		listModel.addElement(titoli);
		
		for(Biglietto biglietto: list) {
			String string = biglietto.getCodBiglietto() + " "  
					+ biglietto.getPosto() + " " + biglietto.getTipoDiBiglietto() + " " + 
					biglietto.getTratta().getCodTratta() + " " +
					biglietto.getCliente().getCodFiscale();
			listModel.addElement(string);
			
		}
		
		
		
		JList jlist = new JList(listModel);
		jlist.setBounds(34, 11, 400, 363);
		contentPane.add(jlist);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.openBiglietto();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(34, 414, 180, 57);
		contentPane.add(btnNewButton_3);
	}
}
