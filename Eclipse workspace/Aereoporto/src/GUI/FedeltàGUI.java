package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fedelt‡GUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTextField textFieldCentokilometri;
	private JTextField txtCodiatatextfield;
	private JTextField txtCodfiscaletextfield;
	private JTextField txtPuntitextfield;
	private JTextField txtRicercatextfield;
	private JTextField txtCodFiscaleElimina;
    private JTextField textFieldCodiceFiscale_AggiornaCentokilometri;
    private JTextField textFieldCodIATA_AggiornaCentoChilometri_;
    private JTextField textFieldCentoChilometri_AggiornaPunti;
    private JTextField textField_CodiceIATA_AggiornaPunti;
    private JTextField textField_CentoKilometriAggiornaCentokilometri;
    private JTextField textField_NuovoPunteggio;
    private JTextField textFieldCodIATA_Elimina;
		
    private String [] tipiRicerca = {"Seleziona tutti","CentoKilometri","CodiATA","CodFiscale"};
    

	public Fedelt‡GUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 864);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Fedelt‡");
		
		JLabel lbl_Inserisci = new JLabel("Inserisci");
		lbl_Inserisci.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Inserisci.setBounds(367, 11, 85, 59);
		contentPane.add(lbl_Inserisci);
		
		JLabel lbl_ContaChilometri = new JLabel("Centochilometri");
		lbl_ContaChilometri.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_ContaChilometri.setBounds(43, 70, 146, 31);
		contentPane.add(lbl_ContaChilometri);
		
		JLabel lbl_CodIATA = new JLabel("Codice IATA");
		lbl_CodIATA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CodIATA.setBounds(239, 69, 95, 31);
		contentPane.add(lbl_CodIATA);
		
		JLabel lbl_CodFiscale = new JLabel("Codice Fiscale");
		lbl_CodFiscale.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CodFiscale.setBounds(428, 70, 109, 31);
		contentPane.add(lbl_CodFiscale);
		
		JLabel lbl_Punti = new JLabel("Punti");
		lbl_Punti.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Punti.setBounds(617, 71, 49, 31);
		contentPane.add(lbl_Punti);
		
		textFieldCentokilometri = new JTextField();
	    textFieldCentokilometri.setBounds(53, 101, 109, 31);
		contentPane.add(textFieldCentokilometri);
		textFieldCentokilometri.setColumns(10);
		
		txtCodiatatextfield = new JTextField();
		txtCodiatatextfield.setColumns(10);
		txtCodiatatextfield.setBounds(232, 100, 109, 31);
		contentPane.add(txtCodiatatextfield);
		
		txtCodfiscaletextfield = new JTextField();
		txtCodfiscaletextfield.setColumns(10);
		txtCodfiscaletextfield.setBounds(428, 101, 109, 31);
		contentPane.add(txtCodfiscaletextfield);
		
		txtPuntitextfield = new JTextField();
		txtPuntitextfield.setColumns(10);
		txtPuntitextfield.setBounds(586, 101, 109, 31);
		contentPane.add(txtPuntitextfield);
		
		JButton Button_InviaInserisci = new JButton("Invia");
		Button_InviaInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controller.inserisciFedelt‡(textFieldCentokilometri.getText(), txtCodiatatextfield.getText(), 
						txtCodfiscaletextfield.getText(), txtPuntitextfield.getText());
					
		}
	});
		Button_InviaInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaInserisci.setBounds(728, 92, 85, 40);
		contentPane.add(Button_InviaInserisci);
		
		JLabel lbl_Ricerca = new JLabel("Ricerca");
		lbl_Ricerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Ricerca.setBounds(370, 156, 73, 31);
		contentPane.add(lbl_Ricerca);
		
		JComboBox comboBox_Ricerca = new JComboBox(tipiRicerca);
		comboBox_Ricerca.setBounds(194, 220, 95, 20);
		contentPane.add(comboBox_Ricerca);
		
		txtRicercatextfield = new JTextField();
		txtRicercatextfield.setBounds(336, 209, 132, 43);
		contentPane.add(txtRicercatextfield);
		txtRicercatextfield.setColumns(10);
		
		JLabel lbl_Elimina = new JLabel("Elimina");
		lbl_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Elimina.setBounds(369, 296, 73, 50);
		contentPane.add(lbl_Elimina);
		
		
		
		txtCodFiscaleElimina = new JTextField();
		txtCodFiscaleElimina.setColumns(10);
		txtCodFiscaleElimina.setBounds(166, 376, 122, 20);
		contentPane.add(txtCodFiscaleElimina);
		
		JButton Button_BackToMenu = new JButton("Men\u00F9");
		Button_BackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMen˘();
			}
		});
		Button_BackToMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_BackToMenu.setBounds(21, 729, 101, 57);
		contentPane.add(Button_BackToMenu);
		
		
		
		JButton Button_InviaRicerca = new JButton("Invia");
		Button_InviaRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiFedelt‡(comboBox_Ricerca.getSelectedItem().toString(), txtRicercatextfield.getText());
			}
		});
		Button_InviaRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaRicerca.setBounds(504, 209, 85, 40);
		contentPane.add(Button_InviaRicerca);
		
		JButton Button_InviaElimina = new JButton("Invia");
		Button_InviaElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			controller.eliminaFedelt‡(txtCodFiscaleElimina.getText(), textFieldCodIATA_Elimina.getText());	
          }
		});
		Button_InviaElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaElimina.setBounds(503, 356, 85, 40);
		contentPane.add(Button_InviaElimina);
		
		textFieldCodiceFiscale_AggiornaCentokilometri = new JTextField();
		textFieldCodiceFiscale_AggiornaCentokilometri.setColumns(10);
		textFieldCodiceFiscale_AggiornaCentokilometri.setBounds(29, 521, 108, 20);
		contentPane.add(textFieldCodiceFiscale_AggiornaCentokilometri);
		
		JLabel lblAggiornaCentokilometri = new JLabel("Aggiorna Centokilometri");
		lblAggiornaCentokilometri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAggiornaCentokilometri.setBounds(294, 439, 230, 31);
		contentPane.add(lblAggiornaCentokilometri);
		
		JButton ButtonAggiornaCentokilometri = new JButton("Invia");
		ButtonAggiornaCentokilometri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.aggiornaFedelt‡Centokilometri(textField_CentoKilometriAggiornaCentokilometri.getText(),  textFieldCodiceFiscale_AggiornaCentokilometri.getText(), textFieldCodIATA_AggiornaCentoChilometri_.getText());
			}
		});
		ButtonAggiornaCentokilometri.setFont(new Font("Tahoma", Font.BOLD, 15));
		ButtonAggiornaCentokilometri.setBounds(506, 507, 85, 40);
		contentPane.add(ButtonAggiornaCentokilometri);
		
		textFieldCodIATA_AggiornaCentoChilometri_ = new JTextField();
		textFieldCodIATA_AggiornaCentoChilometri_.setColumns(10);
		textFieldCodIATA_AggiornaCentoChilometri_.setBounds(172, 519, 109, 20);
		contentPane.add(textFieldCodIATA_AggiornaCentoChilometri_);
		
		JLabel lbl_CodiceFiscale_AggiornaCentokilometri = new JLabel("Codice Fiscale");
		lbl_CodiceFiscale_AggiornaCentokilometri.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CodiceFiscale_AggiornaCentokilometri.setBounds(29, 486, 108, 31);
		contentPane.add(lbl_CodiceFiscale_AggiornaCentokilometri);
		
		JLabel lblAggiornaPunti = new JLabel("Aggiorna Punti");
		lblAggiornaPunti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAggiornaPunti.setBounds(332, 567, 139, 31);
		contentPane.add(lblAggiornaPunti);
		
		textFieldCentoChilometri_AggiornaPunti = new JTextField();
		textFieldCentoChilometri_AggiornaPunti.setColumns(10);
		textFieldCentoChilometri_AggiornaPunti.setBounds(28, 644, 109, 20);
		contentPane.add(textFieldCentoChilometri_AggiornaPunti);
		
		textField_CodiceIATA_AggiornaPunti = new JTextField();
		textField_CodiceIATA_AggiornaPunti.setColumns(10);
		textField_CodiceIATA_AggiornaPunti.setBounds(170, 643, 109, 20);
		contentPane.add(textField_CodiceIATA_AggiornaPunti);
		
		JLabel lbl_CentoChilometri_AggiornaPunti = new JLabel("Centochilometri");
		lbl_CentoChilometri_AggiornaPunti.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CentoChilometri_AggiornaPunti.setBounds(21, 608, 122, 31);
		contentPane.add(lbl_CentoChilometri_AggiornaPunti);
		
		JButton ButtonAggiornaPunti = new JButton("Invia");
		ButtonAggiornaPunti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.aggiornaFedelt‡Punti(textField_NuovoPunteggio.getText(), textFieldCentoChilometri_AggiornaPunti.getText(), textField_CodiceIATA_AggiornaPunti.getText());
			}
		});
		ButtonAggiornaPunti.setFont(new Font("Tahoma", Font.BOLD, 15));
		ButtonAggiornaPunti.setBounds(508, 621, 85, 40);
		contentPane.add(ButtonAggiornaPunti);
		
		JLabel lbl_CodIATA_Aggiorna_Punti = new JLabel("Codice IATA");
		lbl_CodIATA_Aggiorna_Punti.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CodIATA_Aggiorna_Punti.setBounds(178, 610, 95, 31);
		contentPane.add(lbl_CodIATA_Aggiorna_Punti);
		
		JLabel lbl_CodIATA_Aggiorna_Centokilometri = new JLabel("Codice IATA");
		lbl_CodIATA_Aggiorna_Centokilometri.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CodIATA_Aggiorna_Centokilometri.setBounds(180, 484, 95, 31);
		contentPane.add(lbl_CodIATA_Aggiorna_Centokilometri);
		
		JLabel lbl_Centokilometri_Aggiorna_Centokilometri_ = new JLabel("Nuovo Centokilometri");
		lbl_Centokilometri_Aggiorna_Centokilometri_.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Centokilometri_Aggiorna_Centokilometri_.setBounds(316, 483, 167, 31);
		contentPane.add(lbl_Centokilometri_Aggiorna_Centokilometri_);
		
		JLabel lbl_Nuovo_Punteggio = new JLabel("Nuovo Punteggio");
		lbl_Nuovo_Punteggio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Nuovo_Punteggio.setBounds(335, 611, 132, 31);
		contentPane.add(lbl_Nuovo_Punteggio);
		
		textField_CentoKilometriAggiornaCentokilometri = new JTextField();
		textField_CentoKilometriAggiornaCentokilometri.setColumns(10);
		textField_CentoKilometriAggiornaCentokilometri.setBounds(343, 520, 109, 20);
		contentPane.add(textField_CentoKilometriAggiornaCentokilometri);
		
		textField_NuovoPunteggio = new JTextField();
		textField_NuovoPunteggio.setColumns(10);
		textField_NuovoPunteggio.setBounds(343, 644, 109, 20);
		contentPane.add(textField_NuovoPunteggio);
		
		textFieldCodIATA_Elimina = new JTextField();
		textFieldCodIATA_Elimina.setColumns(10);
		textFieldCodIATA_Elimina.setBounds(345, 376, 122, 20);
		contentPane.add(textFieldCodIATA_Elimina);
		
		JLabel lbl_CodIATA_Elimina = new JLabel("Codice IATA");
		lbl_CodIATA_Elimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CodIATA_Elimina.setBounds(357, 346, 95, 31);
		contentPane.add(lbl_CodIATA_Elimina);
		
		JLabel lbl_CodFiscale_Elimina = new JLabel("Codice Fiscale");
		lbl_CodFiscale_Elimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_CodFiscale_Elimina.setBounds(172, 347, 109, 31);
		contentPane.add(lbl_CodFiscale_Elimina);
	}
}
