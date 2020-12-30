package RisultatiGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Entit�.Slot;
import Entit�.Tratta;
import GUI.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiTrattaGUI extends JFrame {
	Controller controller;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public RisultatiTrattaGUI(List<Tratta> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(Tratta tratta: list) {
			String string = tratta.getCodTratta()+" "+tratta.getCodIATA()+" "+tratta.getDestinazione()+" "+tratta.getNgate()+" "+tratta.getNprenotazioni()+" "+tratta.getScali();
			listModel.addElement(string);
			
		}
		
		JList jlist = new JList((ListModel) null);
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
