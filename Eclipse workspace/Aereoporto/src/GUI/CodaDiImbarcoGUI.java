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

public class CodaDiImbarcoGUI extends JFrame {
	Controller controller;
	String[] ValoriScelta = {"Seleziona tutti","CodCoda","N gate","CodSlot"};
	private JPanel contentPane;
	private JTextField CodCodatextField;
	private JTextField TipoDiCodatextField;
	private JTextField NGatetextField;
	private JTextField CodSlottextField;
	private JTextField EliminatextField;
	private JLabel lblRicerca;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CodaDiImbarcoGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRicerca = new JLabel("Ricerca");
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setBounds(315, 11, 136, 42);
		contentPane.add(lblRicerca);
		
		JComboBox comboBoxRicerca = new JComboBox(ValoriScelta);
		comboBoxRicerca.setBounds(135, 108, 149, 22);
		contentPane.add(comboBoxRicerca);
		
		JTextArea RicercatextArea = new JTextArea();
		RicercatextArea.setBounds(315, 107, 136, 22);
		contentPane.add(RicercatextArea);
		
		JButton btnRicerca = new JButton("Invia");
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openRisultatiCodaDiImbarco(comboBoxRicerca.getSelectedItem().toString(), RicercatextArea.getText());
			}
		});
		btnRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca.setBounds(618, 98, 142, 42);
		contentPane.add(btnRicerca);
		
		JLabel lblInserisci = new JLabel("Inserimento");
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setForeground(Color.BLACK);
		lblInserisci.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInserisci.setBounds(315, 172, 136, 42);
		contentPane.add(lblInserisci);
		
		JLabel lblCodCoda = new JLabel("CodCoda");
		lblCodCoda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodCoda.setBounds(265, 242, 66, 14);
		contentPane.add(lblCodCoda);

		
		JLabel lblTipoDiCoda = new JLabel("Tipo di coda");
		lblTipoDiCoda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDiCoda.setBounds(420, 238, 98, 22);
		contentPane.add(lblTipoDiCoda);
		
		JLabel lblCodslot = new JLabel("CodSlot");
		lblCodslot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodslot.setBounds(440, 324, 66, 14);
		contentPane.add(lblCodslot);
		
		JLabel lblNGate = new JLabel("N gate");
		lblNGate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNGate.setBounds(274, 315, 46, 22);
		contentPane.add(lblNGate);
		
		CodCodatextField = new JTextField();
		CodCodatextField.setBounds(250, 270, 86, 20);
		contentPane.add(CodCodatextField);
		CodCodatextField.setColumns(10);
		CodCodatextField.getText();
		
		TipoDiCodatextField = new JTextField();
		TipoDiCodatextField.setColumns(10);
		TipoDiCodatextField.setBounds(420, 271, 86, 20);
		TipoDiCodatextField.getText();
		contentPane.add(TipoDiCodatextField);
		
		NGatetextField = new JTextField();
		NGatetextField.setColumns(10);
		NGatetextField.setBounds(250, 348, 86, 20);
		NGatetextField.getText();
		contentPane.add(NGatetextField);
		
		CodSlottextField = new JTextField();
		CodSlottextField.setColumns(10);
		CodSlottextField.setBounds(420, 349, 86, 20);
		CodSlottextField.getText();
		contentPane.add(CodSlottextField);
		
		
		JButton btnInserisci = new JButton("Invia");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.inserisciCodaDiImbarco(CodCodatextField.getText(), TipoDiCodatextField.getText(), NGatetextField.getText(), CodSlottextField.getText());
			}
		});
		btnInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInserisci.setBounds(618, 337, 142, 42);
		contentPane.add(btnInserisci);
		
		
		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setForeground(Color.BLACK);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElimina.setBounds(299, 407, 149, 42);
		contentPane.add(lblElimina);
		
		JLabel lblEliminaNgate = new JLabel("Inserisci N gate della riga da eliminare");
		lblEliminaNgate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEliminaNgate.setBounds(243, 445, 275, 22);
		contentPane.add(lblEliminaNgate);
		
		EliminatextField = new JTextField();
		EliminatextField.setBounds(333, 478, 86, 20);
		contentPane.add(EliminatextField);
		EliminatextField.setColumns(10);
		CodSlottextField.getText();
		

		
		
		JButton btnMenu = new JButton("Menù");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.backToMenù();
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMenu.setBounds(28, 549, 142, 42);
		contentPane.add(btnMenu);
		
		JButton btnElimina = new JButton("Invia");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			controller.EliminaCodaDiImbarco(EliminatextField.getText());	
			}
		});
//		btnElimina.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				controller.eliminaCodaDiImbarco(EliminatextField.getText());
//			}
//		});
		btnElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnElimina.setBounds(618, 465, 142, 42);
		contentPane.add(btnElimina);
	}
}
