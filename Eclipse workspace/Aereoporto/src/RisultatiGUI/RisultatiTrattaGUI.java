package RisultatiGUI;

import Entità.Tratta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiTrattaGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	
	public RisultatiTrattaGUI(List<Tratta> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Tratta");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(Tratta tratta: list) {
			String string = tratta.getCodTratta()+" "+tratta.getDestinazione()+" "+
		tratta.getNprenotazioni()+" "+tratta.getScali();
			listModel.addElement(string);
			
		}
		
		JList jlist = new JList(listModel);
		jlist.setBounds(10, 11, 400, 363);
		contentPane.add(jlist);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openTratta();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 425, 180, 57);
		contentPane.add(btnNewButton_3);
	}
}
