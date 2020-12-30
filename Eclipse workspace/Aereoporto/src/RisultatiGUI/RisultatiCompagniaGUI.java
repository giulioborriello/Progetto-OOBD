package RisultatiGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.Font;

public class RisultatiCompagniaGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public RisultatiCompagniaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList jlist = new JList((ListModel) null);
		jlist.setBounds(10, 11, 400, 363);
		contentPane.add(jlist);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 385, 180, 57);
		contentPane.add(btnNewButton_3);
	}

}
