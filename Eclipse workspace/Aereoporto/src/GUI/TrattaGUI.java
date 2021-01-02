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
		
		JLabel lblNewLabel = new JLabel("Inserimento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(433, 165, 169, 89);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ricerca");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(432, 11, 136, 42);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(ValoriScelta);
		comboBox.setBounds(10, 82, 149, 82);
		contentPane.add(comboBox);
		
		JTextArea textFieldRicerca = new JTextArea();
		textFieldRicerca.setBounds(432, 111, 136, 22);
		contentPane.add(textFieldRicerca);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiTratta(comboBox.getSelectedItem().toString(), textFieldRicerca.getText() );
			}
		});
		btnNewButton.setBounds(888, 122, 142, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("CodTratta");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(27, 305, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("N Prenotazioni");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(150, 305, 102, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Orario di partenza");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(318, 269, 130, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Data");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(618, 269, 46, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("N gate");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(839, 301, 78, 22);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("CodIATA");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5.setBounds(944, 305, 70, 14);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Destinazione");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_6.setBounds(27, 412, 86, 14);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Scali");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_7.setBounds(172, 412, 46, 14);
		contentPane.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_8 = new JLabel("Gate");
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_8.setBounds(279, 412, 46, 14);
		contentPane.add(lblNewLabel_2_8);
		
		JButton btnNewButton_1 = new JButton("Invia");
		btnNewButton_1.addActionListener(new ActionListener() {
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

		btnNewButton_1.setBounds(522, 426, 142, 42);
		contentPane.add(btnNewButton_1);
		
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
		textFieldNgate.setBounds(816, 330, 86, 20);
		contentPane.add(textFieldNgate);
		
		textFieldCodIATA = new JTextField();
		textFieldCodIATA.setColumns(10);
		textFieldCodIATA.setBounds(944, 330, 86, 20);
		contentPane.add(textFieldCodIATA);
		
		textFieldDestinazione = new JTextField();
		textFieldDestinazione.setColumns(10);
		textFieldDestinazione.setBounds(27, 437, 86, 20);
		contentPane.add(textFieldDestinazione);
		
		textFieldScali = new JTextField();
		textFieldScali.setColumns(10);
		textFieldScali.setBounds(150, 437, 86, 20);
		contentPane.add(textFieldScali);
		
		textFieldGate = new JTextField();
		textFieldGate.setColumns(10);
		textFieldGate.setBounds(261, 437, 86, 20);
		contentPane.add(textFieldGate);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Elimina");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(354, 507, 366, 42);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Inserisci CodTratta della riga da eliminare");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(389, 556, 275, 40);
		contentPane.add(lblNewLabel_7_1);
		
		textFieldElimina = new JTextField();
		textFieldElimina.setColumns(10);
		textFieldElimina.setBounds(498, 607, 86, 20);
		contentPane.add(textFieldElimina);
		
		JButton btnNewButton_1_1 = new JButton("Invia");
		btnNewButton_1_1.setBounds(888, 585, 142, 42);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Indietro");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		btnNewButton_2.setBounds(24, 579, 135, 39);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giorno");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(522, 305, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldDataMese = new JTextField();
		textFieldDataMese.setColumns(10);
		textFieldDataMese.setBounds(600, 330, 86, 20);
		contentPane.add(textFieldDataMese);
		
		textFieldDataAnno = new JTextField();
		textFieldDataAnno.setColumns(10);
		textFieldDataAnno.setBounds(696, 330, 86, 20);
		contentPane.add(textFieldDataAnno);
		
		JLabel lblNewLabel_4 = new JLabel("Mese");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(618, 305, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Anno");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(716, 305, 62, 14);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ora");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(307, 305, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textFieldOrarioDiPartenzaMinuto = new JTextField();
		textFieldOrarioDiPartenzaMinuto.setColumns(10);
		textFieldOrarioDiPartenzaMinuto.setBounds(374, 330, 86, 20);
		contentPane.add(textFieldOrarioDiPartenzaMinuto);
		
		JLabel lblNewLabel_3_2 = new JLabel("Minuto");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(393, 307, 46, 14);
		contentPane.add(lblNewLabel_3_2);
	}
}
