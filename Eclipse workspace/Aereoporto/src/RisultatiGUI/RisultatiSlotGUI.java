package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;
import Entità.Slot;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiSlotGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	
	public RisultatiSlotGUI(List<Slot> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Slot");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(Slot slot: list) {
			String string = slot.getCodSlot()+ " " + slot.getTempoDiImbarcoStimato() + " " +slot.getTempoDiImbarcoEffettivo() 
			+ " " +slot.getOrarioDiPartenza() + " " +slot.getData() + " " + slot.getData();
			listModel.addElement(string);
			
		}
		
		JList jlist = new JList(listModel);
		jlist.setBounds(10, 11, 400, 363);
		contentPane.add(jlist);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openSlot();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 385, 180, 57);
		contentPane.add(btnNewButton_3);
	}

}
