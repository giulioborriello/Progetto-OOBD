package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;

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
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTextField textFieldCodTratta;
	private JTextField textFieldCodIATA;
	private JTextField textFieldDestinazione;
	private JTextField textFieldScali;
	private JTextField textFieldElimina;
	
	private String[] Ngate = {"1", "2", "3", "4", "5"};

	private String[] tipiDiRicerca = {"CodTratta","Data","CodIATA e data","Destinazione e data" };
	private String[] oreOMinuti = {"0","1","2","3","4","5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21","22","23","24","25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
			"41","42","43","44","45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
	private String[] giorni = {"1","2","3","4","5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21","22","23","24","25", "26", "27", "28", "29", "30", "31"};
	private String[] mesi = {"1", "2", "3", "4","5","6","7","8", "9", "10", "11", "12"};
	private String[] anni = {"2000","2001","2002","2003","2004","2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", 
			"2016", "2017", "2018", "2019", "2020", "2021","2022","2023","2024","2025"};
	
	public TrattaGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Tratta");
		setResizable(false);
		
		JLabel lbl_Inserimento = new JLabel("Inserimento");
		lbl_Inserimento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Inserimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Inserimento.setBounds(414, 166, 169, 89);
		contentPane.add(lbl_Inserimento);
		
		JLabel lbl_Ricerca = new JLabel("Ricerca");
		lbl_Ricerca.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ricerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Ricerca.setBounds(432, 11, 136, 42);
		contentPane.add(lbl_Ricerca);
		
		JComboBox comboBox_Ricerca = new JComboBox(tipiDiRicerca);
		comboBox_Ricerca.setBounds(121, 108, 103, 22);
		contentPane.add(comboBox_Ricerca);
		
		JTextArea textFieldRicerca = new JTextArea();
		textFieldRicerca.setBounds(102, 140, 136, 22);
		contentPane.add(textFieldRicerca);
		
		
		JComboBox comboBox_Ora = new JComboBox(oreOMinuti);
		comboBox_Ora.setBounds(148, 327, 103, 22);
		contentPane.add(comboBox_Ora);
		
		JComboBox comboBox_Ngate_Inserimento = new JComboBox(Ngate);
		comboBox_Ngate_Inserimento.setBounds(148, 438, 103, 22);
		contentPane.add(comboBox_Ngate_Inserimento);
		
		JComboBox comboBox_Minuto = new JComboBox(oreOMinuti);
		comboBox_Minuto.setBounds(261, 327, 103, 22);
		contentPane.add(comboBox_Minuto);
		
		JComboBox comboBox_Giorno = new JComboBox(giorni);
		comboBox_Giorno.setBounds(406, 328, 103, 22);
		contentPane.add(comboBox_Giorno);
		
		JComboBox comboBox_Mese = new JComboBox(mesi);
		comboBox_Mese.setBounds(531, 330, 103, 22);
		contentPane.add(comboBox_Mese);
		
		JComboBox comboBox_Anno = new JComboBox(anni);
		comboBox_Anno.setBounds(651, 330, 103, 22);
		contentPane.add(comboBox_Anno);
		
		JComboBox comboBox_GiornoRicerca = new JComboBox(giorni);
		comboBox_GiornoRicerca.setBounds(327, 131, 103, 22);
		contentPane.add(comboBox_GiornoRicerca);
		
		JComboBox comboBox_MeseRicerca = new JComboBox(mesi);
		comboBox_MeseRicerca.setBounds(452, 133, 103, 22);
		contentPane.add(comboBox_MeseRicerca);
		
		JComboBox comboBox_AnnoRicerca = new JComboBox(anni);
		comboBox_AnnoRicerca.setBounds(572, 133, 103, 22);
		contentPane.add(comboBox_AnnoRicerca);
		
		
		JButton Button_InviaRicerca = new JButton("Invia");
		Button_InviaRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Data = comboBox_GiornoRicerca.getSelectedItem().toString() + "/" + comboBox_MeseRicerca.getSelectedItem().toString() + "/" + comboBox_AnnoRicerca.getSelectedItem().toString(); 
				System.out.println(Data + "GUI");
				controller.openRisultatiTratta(comboBox_Ricerca.getSelectedItem().toString(), textFieldRicerca.getText(), Data);
			}
		});
		Button_InviaRicerca.setBounds(792, 100, 142, 42);
		contentPane.add(Button_InviaRicerca);
		
		JLabel lbl_Cod_Tratta = new JLabel("CodTratta");
		lbl_Cod_Tratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Cod_Tratta.setBounds(36, 305, 68, 14);
		contentPane.add(lbl_Cod_Tratta);
		
		JLabel lbl_Orario_Partenza = new JLabel("Orario di partenza");
		lbl_Orario_Partenza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Orario_Partenza.setBounds(198, 271, 116, 14);
		contentPane.add(lbl_Orario_Partenza);
		
		JLabel lbl_Data = new JLabel("Data");
		lbl_Data.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Data.setBounds(565, 270, 35, 14);
		contentPane.add(lbl_Data);
		
		JLabel lbl_CodIATA = new JLabel("CodIATA");
		lbl_CodIATA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CodIATA.setBounds(280, 414, 70, 14);
		contentPane.add(lbl_CodIATA);
		
		JLabel lbl_Destinazione = new JLabel("Destinazione");
		lbl_Destinazione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Destinazione.setBounds(397, 414, 86, 14);
		contentPane.add(lbl_Destinazione);
		
		JLabel lbl_Scali = new JLabel("Scali");
		lbl_Scali.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Scali.setBounds(533, 414, 46, 14);
		contentPane.add(lbl_Scali);
		
		
		
		
		JButton Button_InviaInserimento = new JButton("Invia");
		Button_InviaInserimento.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String Data = comboBox_Giorno.getSelectedItem().toString() + "-" + comboBox_Mese.getSelectedItem().toString() + "-" + comboBox_Anno.getSelectedItem().toString(); 
				String Orario = comboBox_Ora.getSelectedItem().toString() + ":" + comboBox_Minuto.getSelectedItem().toString();
				
				try {
					controller.inserisciTratta(textFieldCodTratta.getText(),"0",Orario,Data, 
							textFieldCodIATA.getText(),textFieldDestinazione.getText(), textFieldScali.getText(), comboBox_Ngate_Inserimento.getSelectedItem().toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Button_InviaInserimento.setBounds(792, 416, 142, 42);
		contentPane.add(Button_InviaInserimento);
		
		textFieldCodTratta = new JTextField();
		textFieldCodTratta.setBounds(27, 330, 86, 20);
		contentPane.add(textFieldCodTratta);
		textFieldCodTratta.setColumns(10);
		
		textFieldCodIATA = new JTextField();
		textFieldCodIATA.setColumns(10);
		textFieldCodIATA.setBounds(268, 439, 86, 20);
		contentPane.add(textFieldCodIATA);
		
		textFieldDestinazione = new JTextField();
		textFieldDestinazione.setColumns(10);
		textFieldDestinazione.setBounds(397, 439, 86, 20);
		contentPane.add(textFieldDestinazione);
		
		textFieldScali = new JTextField();
		textFieldScali.setColumns(10);
		textFieldScali.setBounds(507, 439, 86, 20);
		contentPane.add(textFieldScali);
		
		JLabel lbl_Elimina = new JLabel("Elimina");
		lbl_Elimina.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Elimina.setForeground(Color.BLACK);
		lbl_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Elimina.setBounds(309, 504, 366, 42);
		contentPane.add(lbl_Elimina);
		
		JLabel lbl_InserisciCodTratta = new JLabel("Inserisci CodTratta della riga da eliminare");
		lbl_InserisciCodTratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_InserisciCodTratta.setBounds(344, 553, 275, 40);
		contentPane.add(lbl_InserisciCodTratta);
		
		textFieldElimina = new JTextField();
		textFieldElimina.setColumns(10);
		textFieldElimina.setBounds(453, 604, 86, 20);
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
		lbl_Giorno.setBounds(434, 304, 46, 14);
		contentPane.add(lbl_Giorno);
		
		JLabel lbl_Mese = new JLabel("Mese");
		lbl_Mese.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Mese.setBounds(565, 306, 35, 14);
		contentPane.add(lbl_Mese);
		
		JLabel lbl_Anno = new JLabel("Anno");
		lbl_Anno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Anno.setBounds(685, 306, 35, 14);
		contentPane.add(lbl_Anno);
		
		JLabel lbl_Ora = new JLabel("Ora");
		lbl_Ora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Ora.setBounds(183, 303, 46, 14);
		contentPane.add(lbl_Ora);
		
		JLabel lbl_Minuto = new JLabel("Minuto");
		lbl_Minuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Minuto.setBounds(289, 305, 46, 14);
		contentPane.add(lbl_Minuto);
		
		JLabel lbl_Data_1 = new JLabel("Data");
		lbl_Data_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Data_1.setBounds(486, 73, 35, 14);
		contentPane.add(lbl_Data_1);
		
		JLabel lbl_Giorno_1 = new JLabel("Giorno");
		lbl_Giorno_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Giorno_1.setBounds(355, 107, 46, 14);
		contentPane.add(lbl_Giorno_1);
		
		
		
		JLabel lbl_Mese_1 = new JLabel("Mese");
		lbl_Mese_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Mese_1.setBounds(486, 109, 35, 14);
		contentPane.add(lbl_Mese_1);
		
		JLabel lbl_Anno_1 = new JLabel("Anno");
		lbl_Anno_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Anno_1.setBounds(606, 109, 35, 14);
		contentPane.add(lbl_Anno_1);
		
		JLabel lblNewLabel = new JLabel("Ngate");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(178, 410, 46, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Per separare gli scali utilizzare _");
		lblNewLabel_1.setBounds(472, 389, 169, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
	}
}
