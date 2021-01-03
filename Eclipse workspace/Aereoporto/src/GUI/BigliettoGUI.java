package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BigliettoGUI extends JFrame {

	Controller controller;
	private JPanel contentPane;
	private JTextField CodBigliettoTextField;
	private JTextField CodfiscaleTextField;
	private JTextField NomeTextField;
	private JTextField PostoTextField;
	private JTextField CodTrattaTextField;
	
	String[] tipiDiRicerca = {"Seleziona tutti", "Codice Fiscale", "Codice Tratta"};
	String[] tipiDiBiglietti = {"Economy", "Business"};
	private JTextField EliminaTextField;
	private JTextField textFieldRicerca;
	
	public BigliettoGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRicerca = new JLabel("Ricerca");
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setBounds(333, 11, 119, 58);
		contentPane.add(lblRicerca);
		
		
		JLabel lblPer = new JLabel("Per:");
		lblPer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPer.setBounds(166, 64, 51, 33);
		contentPane.add(lblPer);
		
		textFieldRicerca = new JTextField();
		textFieldRicerca.setBounds(356, 74, 86, 20);
		contentPane.add(textFieldRicerca);
		textFieldRicerca.setColumns(10);
		
		JComboBox RicercaComboBox = new JComboBox(tipiDiRicerca);
		RicercaComboBox.setBounds(225, 72, 103, 22);
		contentPane.add(RicercaComboBox);
		
		JButton RicercaInviaButton = new JButton("Invia");
		RicercaInviaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiBiglietto(RicercaComboBox.getSelectedItem().toString(), textFieldRicerca.getText());
			}
		});
		RicercaInviaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		RicercaInviaButton.setBounds(473, 65, 85, 40);
		contentPane.add(RicercaInviaButton);
		
		
		JLabel lblInserimenti = new JLabel("Inserimenti");
		lblInserimenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimenti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInserimenti.setBounds(340, 127, 119, 58);
		contentPane.add(lblInserimenti);
		
		JLabel lblCodtratta = new JLabel("CodBiglietto");
		lblCodtratta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodtratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodtratta.setBounds(21, 175, 85, 40);
		contentPane.add(lblCodtratta);
		
		JLabel lblCodfiscale = new JLabel("CodFiscale");
		lblCodfiscale.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodfiscale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodfiscale.setBounds(139, 175, 85, 40);
		contentPane.add(lblCodfiscale);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(245, 175, 85, 40);
		contentPane.add(lblNome);
		
		JLabel lblPosto = new JLabel("Posto");
		lblPosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosto.setBounds(356, 175, 85, 40);
		contentPane.add(lblPosto);
		
		JLabel lblTipodibiglietto = new JLabel("Tipo Di Biglietto");
		lblTipodibiglietto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipodibiglietto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipodibiglietto.setBounds(451, 175, 139, 40);
		contentPane.add(lblTipodibiglietto);
		
		JLabel lblCodtratta_5 = new JLabel("CodTratta");
		lblCodtratta_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodtratta_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodtratta_5.setBounds(614, 175, 85, 40);
		contentPane.add(lblCodtratta_5);
		
		CodBigliettoTextField = new JTextField();
		CodBigliettoTextField.setBounds(21, 226, 86, 20);
		contentPane.add(CodBigliettoTextField);
		CodBigliettoTextField.setColumns(10);
		
		CodfiscaleTextField = new JTextField();
		CodfiscaleTextField.setColumns(10);
		CodfiscaleTextField.setBounds(138, 226, 86, 20);
		contentPane.add(CodfiscaleTextField);
		
		NomeTextField = new JTextField();
		NomeTextField.setColumns(10);
		NomeTextField.setBounds(244, 226, 86, 20);
		contentPane.add(NomeTextField);
		
		PostoTextField = new JTextField();
		PostoTextField.setColumns(10);
		PostoTextField.setBounds(356, 226, 86, 20);
		contentPane.add(PostoTextField);
		
		JComboBox TipoDiBigliettoComboBox = new JComboBox(tipiDiBiglietti);
		TipoDiBigliettoComboBox.setBounds(476, 226, 103, 22);
		contentPane.add(TipoDiBigliettoComboBox);
		
		CodTrattaTextField = new JTextField();
		CodTrattaTextField.setColumns(10);
		CodTrattaTextField.setBounds(613, 226, 86, 20);
		contentPane.add(CodTrattaTextField);
		
	
		JButton InserisciInviaButton = new JButton("Invia");
		InserisciInviaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.inserisciBiglietto(CodfiscaleTextField.getText(), TipoDiBigliettoComboBox.getSelectedItem().toString(), 
						CodBigliettoTextField.getText(), CodTrattaTextField.getText(), PostoTextField.getText());
			}
		});
		InserisciInviaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		InserisciInviaButton.setBounds(744, 208, 85, 40);
		contentPane.add(InserisciInviaButton);
		

		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElimina.setBounds(341, 275, 119, 58);
		contentPane.add(lblElimina);
		
		EliminaTextField = new JTextField();
		EliminaTextField.setColumns(10);
		EliminaTextField.setBounds(356, 381, 86, 20);
		contentPane.add(EliminaTextField);
		
		JButton EliminaInviaButton = new JButton("Invia");
		EliminaInviaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eliminaBiglietto(EliminaTextField.getText());
			}
		});

		EliminaInviaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		EliminaInviaButton.setBounds(519, 369, 85, 40);
		contentPane.add(EliminaInviaButton);
		
		JLabel lblSottoTitoloElimina = new JLabel("Inserisci N gate della riga da eliminare");
		lblSottoTitoloElimina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSottoTitoloElimina.setBounds(259, 330, 275, 40);
		contentPane.add(lblSottoTitoloElimina);
		
		JButton MenuButton = new JButton("Menu");
		MenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.backToMenù();
			}
		});
		MenuButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		MenuButton.setBounds(21, 495, 85, 40);
		contentPane.add(MenuButton);
		
		
		
		
	}
}
