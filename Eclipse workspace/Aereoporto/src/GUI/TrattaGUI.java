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
		setBounds(100, 100, 1092, 816);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Inserimento_Label = new JLabel("Inserimento");
		Inserimento_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Inserimento_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Inserimento_Label.setBounds(433, 165, 169, 89);
		contentPane.add(Inserimento_Label);
		
		JLabel Ricerca_Label = new JLabel("Ricerca");
		Ricerca_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Ricerca_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ricerca_Label.setBounds(432, 11, 136, 42);
		contentPane.add(Ricerca_Label);
		
		JComboBox comboBox_Ricerca = new JComboBox(ValoriScelta);
		comboBox_Ricerca.setBounds(10, 82, 149, 82);
		contentPane.add(comboBox_Ricerca);
		
		JTextArea textFieldRicerca = new JTextArea();
		textFieldRicerca.setBounds(432, 111, 136, 22);
		contentPane.add(textFieldRicerca);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiTratta(comboBox_Ricerca.getSelectedItem().toString(), textFieldRicerca.getText() );
			}
		});
		btnNewButton.setBounds(888, 122, 142, 42);
		contentPane.add(btnNewButton);
		
		JLabel Cod_Tratta_Label = new JLabel("CodTratta");
		Cod_Tratta_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cod_Tratta_Label.setBounds(27, 305, 86, 14);
		contentPane.add(Cod_Tratta_Label);
		
		JLabel N_Prenotazioni_label = new JLabel("N Prenotazioni");
		N_Prenotazioni_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N_Prenotazioni_label.setBounds(150, 305, 102, 14);
		contentPane.add(N_Prenotazioni_label);
		
		JLabel Orario_Partenza = new JLabel("Orario di partenza");
		Orario_Partenza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Orario_Partenza.setBounds(318, 269, 130, 14);
		contentPane.add(Orario_Partenza);
		
		JLabel Partenza_in_Data = new JLabel("Data");
		Partenza_in_Data.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Partenza_in_Data.setBounds(618, 269, 46, 14);
		contentPane.add(Partenza_in_Data);
		
		JLabel N_gate_Label = new JLabel("N gate");
		N_gate_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N_gate_Label.setBounds(51, 408, 78, 22);
		contentPane.add(N_gate_Label);
		
		JLabel CodIATA_label = new JLabel("CodIATA");
		CodIATA_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CodIATA_label.setBounds(162, 412, 70, 14);
		contentPane.add(CodIATA_label);
		
		JLabel Destinazione_Label = new JLabel("Destinazione");
		Destinazione_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Destinazione_Label.setBounds(279, 412, 86, 14);
		contentPane.add(Destinazione_Label);
		
		JLabel Scali_Label = new JLabel("Scali");
		Scali_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Scali_Label.setBounds(415, 412, 46, 14);
		contentPane.add(Scali_Label);
		
		JLabel Gate_Label = new JLabel("Gate");
		Gate_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Gate_Label.setBounds(538, 412, 46, 14);
		contentPane.add(Gate_Label);
		
		JButton Invia_Button = new JButton("Invia");
		Invia_Button.addActionListener(new ActionListener() {
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

		Invia_Button.setBounds(839, 426, 142, 42);
		contentPane.add(Invia_Button);
		
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
		
		JLabel Elimina_Label = new JLabel("Elimina");
		Elimina_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Elimina_Label.setForeground(Color.BLACK);
		Elimina_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Elimina_Label.setBounds(354, 507, 366, 42);
		contentPane.add(Elimina_Label);
		
		JLabel InserisciCodTratta_Label = new JLabel("Inserisci CodTratta della riga da eliminare");
		InserisciCodTratta_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InserisciCodTratta_Label.setBounds(389, 556, 275, 40);
		contentPane.add(InserisciCodTratta_Label);
		
		textFieldElimina = new JTextField();
		textFieldElimina.setColumns(10);
		textFieldElimina.setBounds(498, 607, 86, 20);
		contentPane.add(textFieldElimina);
		
		JButton btnNewButton_1_1 = new JButton("Invia");
		btnNewButton_1_1.setBounds(888, 585, 142, 42);
		contentPane.add(btnNewButton_1_1);
		
		JButton BackToMenù_Button = new JButton("Men\u00F9");
		BackToMenù_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		BackToMenù_Button.setBounds(24, 579, 135, 39);
		contentPane.add(BackToMenù_Button);
		
		JLabel Giorno_Label = new JLabel("Giorno");
		Giorno_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Giorno_Label.setBounds(522, 305, 46, 14);
		contentPane.add(Giorno_Label);
		
		textFieldDataMese = new JTextField();
		textFieldDataMese.setColumns(10);
		textFieldDataMese.setBounds(600, 330, 86, 20);
		contentPane.add(textFieldDataMese);
		
		textFieldDataAnno = new JTextField();
		textFieldDataAnno.setColumns(10);
		textFieldDataAnno.setBounds(696, 330, 86, 20);
		contentPane.add(textFieldDataAnno);
		
		JLabel Mese_label = new JLabel("Mese");
		Mese_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Mese_label.setBounds(618, 305, 46, 14);
		contentPane.add(Mese_label);
		
		JLabel Anno_Label = new JLabel("Anno");
		Anno_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Anno_Label.setBounds(716, 305, 62, 14);
		contentPane.add(Anno_Label);
		
		JLabel Ora_label = new JLabel("Ora");
		Ora_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Ora_label.setBounds(307, 305, 46, 14);
		contentPane.add(Ora_label);
		
		textFieldOrarioDiPartenzaMinuto = new JTextField();
		textFieldOrarioDiPartenzaMinuto.setColumns(10);
		textFieldOrarioDiPartenzaMinuto.setBounds(374, 330, 86, 20);
		contentPane.add(textFieldOrarioDiPartenzaMinuto);
		
		JLabel Minuto_label = new JLabel("Minuto");
		Minuto_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Minuto_label.setBounds(393, 307, 46, 14);
		contentPane.add(Minuto_label);
	}
}
