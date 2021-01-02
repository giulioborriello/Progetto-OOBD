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
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TrattaGUI extends JFrame {
	String[] ValoriScelta = {"Seleziona tutti","CodTratta","Ngate","Data","CodIATA","Destinazione" };
	Controller controller;
	private JPanel contentPane;
	private JTextField textFieldCodTratta;
	private JTextField textFieldNprenotazioni;
	private JTextField textFieldOrarioDiPartenzaOra;
	private JTextField textFieldDataGiorno;
	private JTextField textFieldCodIATA;
	private JTextField textFieldDestinazione;
	private JTextField textFieldScali;
	private JTextField textFieldGate;
	private JTextField textFieldElimina;
	private JTextField textFieldNgate;
	private JTextField textFieldDataMese;
	private JTextField textFieldDataAnno;
	private JTextField textFieldOrarioDiPartenzaMinuto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TrattaGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Inserimento = new JLabel("Inserimento");
		lbl_Inserimento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Inserimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Inserimento.setBounds(433, 165, 169, 89);
		contentPane.add(lbl_Inserimento);
		
		JLabel lbl_Ricerca = new JLabel("Ricerca");
		lbl_Ricerca.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ricerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Ricerca.setBounds(432, 11, 136, 42);
		contentPane.add(lbl_Ricerca);
		
		JComboBox comboBox_Ricerca = new JComboBox(ValoriScelta);
		comboBox_Ricerca.setBounds(262, 112, 103, 22);
		contentPane.add(comboBox_Ricerca);
		
		JTextArea textFieldRicerca = new JTextArea();
		textFieldRicerca.setBounds(432, 111, 136, 22);
		contentPane.add(textFieldRicerca);
		
		JButton Button_InviaRicerca = new JButton("Invia");
		Button_InviaRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiTratta(comboBox_Ricerca.getSelectedItem().toString(), textFieldRicerca.getText() );
			}
		});
		Button_InviaRicerca.setBounds(792, 100, 142, 42);
		contentPane.add(Button_InviaRicerca);
		
		JLabel lbl_Cod_Tratta = new JLabel("CodTratta");
		lbl_Cod_Tratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Cod_Tratta.setBounds(27, 305, 86, 14);
		contentPane.add(lbl_Cod_Tratta);
		
		JLabel lbl_N_prentazioni = new JLabel("N Prenotazioni");
		lbl_N_prentazioni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_N_prentazioni.setBounds(150, 305, 102, 14);
		contentPane.add(lbl_N_prentazioni);
		
		JLabel lbl_Orario_Partenza = new JLabel("Orario di partenza");
		lbl_Orario_Partenza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Orario_Partenza.setBounds(318, 269, 130, 14);
		contentPane.add(lbl_Orario_Partenza);
		
		JLabel lbl_Partenza_in_Data = new JLabel("Data");
		lbl_Partenza_in_Data.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Partenza_in_Data.setBounds(618, 269, 46, 14);
		contentPane.add(lbl_Partenza_in_Data);
		
		JLabel lbl_N_Gate = new JLabel("N gate");
		lbl_N_Gate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_N_Gate.setBounds(51, 408, 78, 22);
		contentPane.add(lbl_N_Gate);
		
		JLabel lbl_CodIATA = new JLabel("CodIATA");
		lbl_CodIATA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CodIATA.setBounds(162, 412, 70, 14);
		contentPane.add(lbl_CodIATA);
		
		JLabel lbl_Destinazione = new JLabel("Destinazione");
		lbl_Destinazione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Destinazione.setBounds(279, 412, 86, 14);
		contentPane.add(lbl_Destinazione);
		
		JLabel lbl_Scali = new JLabel("Scali");
		lbl_Scali.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Scali.setBounds(415, 412, 46, 14);
		contentPane.add(lbl_Scali);
		
		JLabel lbl_Gate = new JLabel("Gate");
		lbl_Gate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Gate.setBounds(538, 412, 46, 14);
		contentPane.add(lbl_Gate);
		
		JButton Button_InviaInserimento = new JButton("Invia");
		Button_InviaInserimento.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int Ngate = Integer.valueOf(textFieldNgate.getText());
				int Nprenotazioni = Integer.valueOf(textFieldNprenotazioni.getText());
				String Data = textFieldDataGiorno.getText() + "-" + textFieldDataMese.getText() + "-" + textFieldDataAnno.getText(); 
				String Orario = textFieldOrarioDiPartenzaOra.getText() + ":" + textFieldOrarioDiPartenzaMinuto.getText();
				try {
					controller.inserisciTratta(textFieldCodTratta.getText(),Nprenotazioni,Orario,Data,Ngate, textFieldCodIATA.getText(),textFieldDestinazione.getText(),textFieldScali.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Button_InviaInserimento.setBounds(792, 425, 142, 42);
		contentPane.add(Button_InviaInserimento);
		
		textFieldCodTratta = new JTextField();
		textFieldCodTratta.setBounds(27, 330, 86, 20);
		contentPane.add(textFieldCodTratta);
		textFieldCodTratta.setColumns(10);
		
		textFieldNprenotazioni = new JTextField();
		textFieldNprenotazioni.setColumns(10);
		textFieldNprenotazioni.setBounds(150, 330, 86, 20);
		contentPane.add(textFieldNprenotazioni);
		
		textFieldOrarioDiPartenzaOra = new JTextField();
		textFieldOrarioDiPartenzaOra.setColumns(10);
		textFieldOrarioDiPartenzaOra.setBounds(279, 330, 86, 20);
		contentPane.add(textFieldOrarioDiPartenzaOra);
		
		textFieldDataGiorno = new JTextField();
		textFieldDataGiorno.setColumns(10);
		textFieldDataGiorno.setBounds(498, 330, 86, 20);
		contentPane.add(textFieldDataGiorno);
		
		textFieldNgate = new JTextField();
		textFieldNgate.setColumns(10);
		textFieldNgate.setBounds(27, 435, 86, 22);
		contentPane.add(textFieldNgate);
		
		textFieldCodIATA = new JTextField();
		textFieldCodIATA.setColumns(10);
		textFieldCodIATA.setBounds(150, 437, 86, 20);
		contentPane.add(textFieldCodIATA);
		
		textFieldDestinazione = new JTextField();
		textFieldDestinazione.setColumns(10);
		textFieldDestinazione.setBounds(279, 437, 86, 20);
		contentPane.add(textFieldDestinazione);
		
		textFieldScali = new JTextField();
		textFieldScali.setColumns(10);
		textFieldScali.setBounds(389, 437, 86, 20);
		contentPane.add(textFieldScali);
		
		textFieldGate = new JTextField();
		textFieldGate.setColumns(10);
		textFieldGate.setBounds(516, 437, 86, 20);
		contentPane.add(textFieldGate);
		
		JLabel lbl_Elimina = new JLabel("Elimina");
		lbl_Elimina.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Elimina.setForeground(Color.BLACK);
		lbl_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Elimina.setBounds(354, 507, 366, 42);
		contentPane.add(lbl_Elimina);
		
		JLabel lbl_InserisciCodTratta = new JLabel("Inserisci CodTratta della riga da eliminare");
		lbl_InserisciCodTratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_InserisciCodTratta.setBounds(389, 556, 275, 40);
		contentPane.add(lbl_InserisciCodTratta);
		
		textFieldElimina = new JTextField();
		textFieldElimina.setColumns(10);
		textFieldElimina.setBounds(498, 607, 86, 20);
		contentPane.add(textFieldElimina);
		
		JButton Button_Elimina = new JButton("Invia");
		Button_Elimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Elimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eliminaTratta(textFieldElimina.getText());
			}
		});
		Button_Elimina.setBounds(792, 585, 142, 42);
		contentPane.add(Button_Elimina);
		
		JButton Button_BackToMenu = new JButton("Men\u00F9");
		Button_BackToMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_BackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		Button_BackToMenu.setBounds(27, 662, 135, 39);
		contentPane.add(Button_BackToMenu);
		
		JLabel lbl_Giorno = new JLabel("Giorno");
		lbl_Giorno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Giorno.setBounds(522, 305, 46, 14);
		contentPane.add(lbl_Giorno);
		
		textFieldDataMese = new JTextField();
		textFieldDataMese.setColumns(10);
		textFieldDataMese.setBounds(600, 330, 86, 20);
		contentPane.add(textFieldDataMese);
		
		textFieldDataAnno = new JTextField();
		textFieldDataAnno.setColumns(10);
		textFieldDataAnno.setBounds(696, 330, 86, 20);
		contentPane.add(textFieldDataAnno);
		
		JLabel lbl_Mese = new JLabel("Mese");
		lbl_Mese.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Mese.setBounds(618, 305, 46, 14);
		contentPane.add(lbl_Mese);
		
		JLabel lbl_Anno = new JLabel("Anno");
		lbl_Anno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Anno.setBounds(716, 305, 62, 14);
		contentPane.add(lbl_Anno);
		
		JLabel lbl_Ora = new JLabel("Ora");
		lbl_Ora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Ora.setBounds(307, 305, 46, 14);
		contentPane.add(lbl_Ora);
		
		textFieldOrarioDiPartenzaMinuto = new JTextField();
		textFieldOrarioDiPartenzaMinuto.setColumns(10);
		textFieldOrarioDiPartenzaMinuto.setBounds(374, 330, 86, 20);
		contentPane.add(textFieldOrarioDiPartenzaMinuto);
		
		JLabel lbl_Minuto = new JLabel("Minuto");
		lbl_Minuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Minuto.setBounds(393, 307, 46, 14);
		contentPane.add(lbl_Minuto);
	}
}
