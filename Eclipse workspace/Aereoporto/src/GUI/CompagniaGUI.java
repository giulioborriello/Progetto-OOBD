package GUI;

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
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTextField codIATAtextField;
	private JTextField nomeCompagniatextField;
	private JTextField eliminaCodIatatextField;
	
	private String[] tipiRicerca = {"Seleziona tutti","CodIATA","Nome Compagnia",};
	
	public CompagniaGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Compagnia");
		
		JLabel lblNewLabel_1 = new JLabel("Ricerca");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(317, 11, 136, 42);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(tipiRicerca);
		comboBox.setBounds(160, 103, 109, 22);
		contentPane.add(comboBox);
		
		JTextArea RicercaTextArea = new JTextArea();
		RicercaTextArea.setBounds(317, 102, 136, 22);
		contentPane.add(RicercaTextArea);
		
		JButton RicercaButton = new JButton("Invia");
		RicercaButton.setFont(new Font("Dialog", Font.BOLD, 15));
		RicercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openRisultatiCompagnia(comboBox.getSelectedItem().toString(), RicercaTextArea.getText());
				
			}
		});
		RicercaButton.setBounds(620, 93, 142, 42);
		contentPane.add(RicercaButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserimento");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(304, 165, 136, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("CodIATA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(268, 229, 80, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeCompagnia = new JLabel("Nome Compagnia");
		lblNomeCompagnia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCompagnia.setBounds(395, 224, 122, 22);
		contentPane.add(lblNomeCompagnia);
		
		codIATAtextField = new JTextField();
		codIATAtextField.setBounds(256, 250, 86, 20);
		contentPane.add(codIATAtextField);
		codIATAtextField.setColumns(10);
		codIATAtextField.getText();
		
		nomeCompagniatextField = new JTextField();
		nomeCompagniatextField.setColumns(10);
		nomeCompagniatextField.setBounds(413, 251, 86, 20);
		contentPane.add(nomeCompagniatextField);
		nomeCompagniatextField.getText();
		
		
		JButton InserisciButton = new JButton("Invia");
		InserisciButton.setFont(new Font("Dialog", Font.BOLD, 15));
		InserisciButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.inserisciInCompagnia(codIATAtextField.getText(), nomeCompagniatextField.getText());
			}
		});
		InserisciButton.setBounds(620, 235, 142, 42);
		contentPane.add(InserisciButton);
		
		
		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setForeground(Color.BLACK);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElimina.setBounds(292, 323, 149, 42);
		contentPane.add(lblElimina);
		
		JLabel lblEliminaCodIATA = new JLabel("Inserisci CodIATA della riga da eliminare");
		lblEliminaCodIATA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEliminaCodIATA.setBounds(236, 376, 275, 40);
		contentPane.add(lblEliminaCodIATA);
		
		eliminaCodIatatextField = new JTextField();
		eliminaCodIatatextField.setColumns(10);
		eliminaCodIatatextField.setBounds(331, 427, 86, 20);
		eliminaCodIatatextField.getText();
		contentPane.add(eliminaCodIatatextField);
		
		
		JButton EliminaButton = new JButton("Invia");
		EliminaButton.setFont(new Font("Dialog", Font.BOLD, 15));
		EliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.eliminaCompagnia(eliminaCodIatatextField.getText());
			}
		});
		EliminaButton.setBounds(620, 455, 142, 42);
		contentPane.add(EliminaButton);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_3.setBounds(0, 514, 180, 57);
		contentPane.add(btnNewButton_3);
	}
   
		}
