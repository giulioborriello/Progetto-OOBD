package RisultatiGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Controller;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiFedelt‡GUI extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	
	public RisultatiFedelt‡GUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList jlist = new JList((ListModel) null);
		jlist.setBounds(10, 11, 400, 363);
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
