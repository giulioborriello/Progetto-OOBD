package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;




public class ClienteGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTextField textFieldCodiceFiscale;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldEmail;
	private JTextField textFieldRicerca;
	private JTextField textFieldIndicaCodiceFiscale;
	
	private String[] tipiRicerca = {"Codice Fiscale"};
	
	public ClienteGUI(Controller c) {
		setResizable(false);
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Inserimentolbl = new JLabel("Inserimenti");
		Inserimentolbl.setHorizontalAlignment(SwingConstants.CENTER);
		Inserimentolbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Inserimentolbl.setBounds(345, 11, 119, 58);
		contentPane.add(Inserimentolbl);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodiceFiscale.setBounds(40, 85, 104, 40);
		contentPane.add(lblCodiceFiscale);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(193, 85, 85, 40);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCognome.setBounds(358, 85, 85, 40);
		contentPane.add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(507, 85, 85, 40);
		contentPane.add(lblEmail);
		
		JButton InserisciInviaButton = new JButton("Invia");
		InserisciInviaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.inserisciCliente(textFieldCodiceFiscale.getText(), textFieldNome.getText(), 
						textFieldCognome.getText(), textFieldEmail.getText());
			}
		});
		InserisciInviaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		InserisciInviaButton.setBounds(643, 124, 85, 40);
		contentPane.add(InserisciInviaButton);
		
		textFieldCodiceFiscale = new JTextField();
		textFieldCodiceFiscale.setColumns(10);
		textFieldCodiceFiscale.setBounds(50, 136, 86, 20);
		contentPane.add(textFieldCodiceFiscale);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(192, 136, 86, 20);
		contentPane.add(textFieldNome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(358, 136, 86, 20);
		contentPane.add(textFieldCognome);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(507, 136, 86, 20);
		contentPane.add(textFieldEmail);
		

		
		JButton MenuButton = new JButton("Menu");
		MenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.backToMenù();
			}
		});
		MenuButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		MenuButton.setBounds(22, 446, 85, 40);
		contentPane.add(MenuButton);
		
		JLabel Ricercalbl = new JLabel("Ricerca");
		Ricercalbl.setHorizontalAlignment(SwingConstants.CENTER);
		Ricercalbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ricercalbl.setBounds(308, 183, 176, 40);
		contentPane.add(Ricercalbl);
		
		JComboBox comboBoxRicerca = new JComboBox(tipiRicerca);
		comboBoxRicerca.setBounds(175, 250, 108, 22);
		contentPane.add(comboBoxRicerca);
		textFieldRicerca = new JTextField();
		textFieldRicerca.setColumns(10);
		textFieldRicerca.setBounds(362, 251, 86, 20);
		contentPane.add(textFieldRicerca);
		
		JButton RicercaInviaButton = new JButton("Invia");
		RicercaInviaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiCliente(comboBoxRicerca.getSelectedItem().toString(), textFieldRicerca.getText());
			}
		});
		RicercaInviaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		RicercaInviaButton.setBounds(512, 239, 85, 40);
		contentPane.add(RicercaInviaButton);
		
		JLabel Eliminalbl = new JLabel("Elimina");
		Eliminalbl.setHorizontalAlignment(SwingConstants.CENTER);
		Eliminalbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Eliminalbl.setBounds(345, 317, 104, 47);
		contentPane.add(Eliminalbl);
		
		JLabel lblEliminaCodiceFiscale = new JLabel("Codice Fiscale");
		lblEliminaCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEliminaCodiceFiscale.setBounds(358, 375, 99, 14);
		contentPane.add(lblEliminaCodiceFiscale);
		
		JButton EliminaButton = new JButton("Invia");
		EliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eliminaCliente(textFieldIndicaCodiceFiscale.getText());
			}
		});
		EliminaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		EliminaButton.setBounds(507, 388, 85, 40);
		contentPane.add(EliminaButton);
		
		textFieldIndicaCodiceFiscale = new JTextField();
		textFieldIndicaCodiceFiscale.setColumns(10);
		textFieldIndicaCodiceFiscale.setBounds(358, 400, 86, 20);
		contentPane.add(textFieldIndicaCodiceFiscale);
	}
}
