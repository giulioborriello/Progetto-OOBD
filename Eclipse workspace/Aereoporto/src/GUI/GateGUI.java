package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GateGUI extends JFrame {
	String[] ValoriScelta = {"Seleziona tutti","N gate","CodTratta",};
	Controller controller;

	private JPanel contentPane;
	private JTextField textFieldNgate;
	private JTextField textFieldCodTratta;
	private JTextField textFieldElimina;
	private JTextField textFieldRicerca;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GateGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRicerca = new JLabel("Ricerca");
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setBounds(322, 11, 136, 42);
		contentPane.add(lblRicerca);
		
		JComboBox comboBoxRicerca = new JComboBox(ValoriScelta);
		comboBoxRicerca.setBounds(181, 78, 94, 22);
		contentPane.add(comboBoxRicerca);
		
		textFieldRicerca = new JTextField();
		textFieldRicerca.setBounds(345, 79, 94, 20);
		contentPane.add(textFieldRicerca);
		textFieldRicerca.setColumns(10);
		

		JButton btnRicerca = new JButton("Invia");
		btnRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiGate(comboBoxRicerca.getSelectedItem().toString(), textFieldRicerca.getText());
			}
		});
		btnRicerca.setBounds(660, 67, 85, 40);
		contentPane.add(btnRicerca);

		
		JLabel lblInserisci = new JLabel("Inserimento");
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setForeground(Color.BLACK);
		lblInserisci.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInserisci.setBounds(321, 153, 136, 42);
		contentPane.add(lblInserisci);
		
		JLabel lblNgate = new JLabel("N gate");
		lblNgate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgate.setBounds(300, 216, 65, 22);
		contentPane.add(lblNgate);
		
		JLabel lblCodtratta = new JLabel("CodTratta");
		lblCodtratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodtratta.setBounds(406, 222, 68, 14);
		contentPane.add(lblCodtratta);
		
		textFieldNgate = new JTextField();
		textFieldNgate.setBounds(279, 245, 86, 20);
		contentPane.add(textFieldNgate);
		textFieldNgate.setColumns(10);
		
		textFieldCodTratta = new JTextField();
		textFieldCodTratta.setColumns(10);
		textFieldCodTratta.setBounds(396, 245, 86, 20);
		contentPane.add(textFieldCodTratta);
		
		JButton btnInserisci = new JButton("Invia");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.inserisciGate(textFieldNgate.getText(), textFieldCodTratta.getText());
			}
		});
		btnInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInserisci.setBounds(661, 233, 85, 40);
		contentPane.add(btnInserisci);
		
		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setForeground(Color.BLACK);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElimina.setBounds(317, 311, 149, 42);
		contentPane.add(lblElimina);
		
		JLabel lblEliminaNgate = new JLabel("Inserisci N gate della riga da eliminare");
		lblEliminaNgate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEliminaNgate.setBounds(269, 346, 253, 30);
		contentPane.add(lblEliminaNgate);
		
		textFieldElimina = new JTextField();
		textFieldElimina.setBounds(346, 387, 86, 20);
		contentPane.add(textFieldElimina);
		textFieldElimina.setColumns(10);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMenu.setBounds(0, 529, 180, 57);
		contentPane.add(btnMenu);
		
		
		JButton btnElimina = new JButton("Invia");
//		btnElimina.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.eliminaGate(textFieldElimina.getText());
//			}
//		});
		btnElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnElimina.setBounds(660, 375, 85, 40);
		contentPane.add(btnElimina);
	}
}
