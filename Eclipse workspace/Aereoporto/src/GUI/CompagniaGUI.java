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

public class CompagniaGUI extends JFrame {
	String[] ValoriScelta = {"Seleziona tutti","CodIATA","Nome Compagnia",};
	Controller controller;
	private JPanel contentPane;
	private JTextField CodIATAtextField;
	private JTextField NomeCompagniatextField;
	private JTextField SitoWebtextField;
	private JTextField TrattatextField;
	private JTextField FedeltàtextField;
	private JTextField EliminaCodIatatextField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CompagniaGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ricerca");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(317, 11, 136, 42);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(ValoriScelta);
		comboBox.setBounds(10, 73, 149, 82);
		contentPane.add(comboBox);
		
		JTextArea RicercaTextArea = new JTextArea();
		RicercaTextArea.setBounds(317, 102, 136, 22);
		contentPane.add(RicercaTextArea);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.getSelectedItem().toString();
			}
		});
		btnNewButton.setBounds(640, 103, 142, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserimento");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(317, 197, 136, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("CodIATA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(192, 265, 80, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeCompagnia = new JLabel("Nome Compagnia");
		lblNomeCompagnia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCompagnia.setBounds(317, 257, 122, 22);
		contentPane.add(lblNomeCompagnia);
		
		JLabel lblSitoWeb = new JLabel("Sito Web");
		lblSitoWeb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSitoWeb.setBounds(495, 265, 80, 14);
		contentPane.add(lblSitoWeb);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tratta");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(266, 337, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Fedelt\u00E0");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(421, 337, 59, 14);
		contentPane.add(lblNewLabel_3_2);
		
		CodIATAtextField = new JTextField();
		CodIATAtextField.setBounds(176, 290, 86, 20);
		contentPane.add(CodIATAtextField);
		CodIATAtextField.setColumns(10);
		CodIATAtextField.getText();
		
		NomeCompagniatextField = new JTextField();
		NomeCompagniatextField.setColumns(10);
		NomeCompagniatextField.setBounds(331, 290, 86, 20);
		contentPane.add(NomeCompagniatextField);
		NomeCompagniatextField.getText();
		
		SitoWebtextField = new JTextField();
		SitoWebtextField.setColumns(10);
		SitoWebtextField.setBounds(481, 290, 86, 20);
		SitoWebtextField.getText();
		contentPane.add(SitoWebtextField);
		
		TrattatextField = new JTextField();
		TrattatextField.setColumns(10);
		TrattatextField.setBounds(244, 362, 86, 20);
		TrattatextField.getText();
		contentPane.add(TrattatextField);
		
		FedeltàtextField = new JTextField();
		FedeltàtextField.setColumns(10);
		FedeltàtextField.setBounds(405, 362, 86, 20);
		FedeltàtextField.getText();
		contentPane.add(FedeltàtextField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Elimina");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(304, 411, 149, 42);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Inserisci CodIATA della riga da eliminare");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(236, 464, 275, 40);
		contentPane.add(lblNewLabel_7_1);
		
		EliminaCodIatatextField = new JTextField();
		EliminaCodIatatextField.setColumns(10);
		EliminaCodIatatextField.setBounds(331, 515, 86, 20);
		EliminaCodIatatextField.getText();
		contentPane.add(EliminaCodIatatextField);
		
		JButton btnNewButton_1 = new JButton("Invia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.InserisciInCompagnia(comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton_1.setBounds(640, 361, 142, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Invia");
		btnNewButton_2.setBounds(640, 526, 142, 42);
		contentPane.add(btnNewButton_2);
		public void actionPerformed(ActionEvent arg0) {
			controller.InserisciInCompagnia(comboBox.getSelectedItem().toString());
		}
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(0, 514, 180, 57);
		contentPane.add(btnNewButton_3);
	}
   
}
