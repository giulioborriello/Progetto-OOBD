package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;
import Entit‡.Fedelt‡;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RisultatiFedelt‡GUI extends JFrame {

	private Controller controller;
	
	private JPanel contentPane;
	
	
	public RisultatiFedelt‡GUI(List<Fedelt‡> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Fedelt‡");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(Fedelt‡ fedelt‡: list) {
			String string = fedelt‡.getCliente() + " " + fedelt‡.getCompagnia() + " " + fedelt‡.getCentoKilometri() + " " + fedelt‡.getPunti();
			listModel.addElement(string);
			
		}
		
		JList jlist = new JList(listModel);
		jlist.setBounds(10, 11, 673, 363);
		contentPane.add(jlist);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openFedelt‡();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 385, 180, 57);
		contentPane.add(btnNewButton_3);
	}

}
