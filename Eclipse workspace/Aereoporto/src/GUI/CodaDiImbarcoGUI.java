
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
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CodaDiImbarcoGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTextField codCodatextField;
	private JTextField CodGatetextField;
	private JTextField eliminatextField;
	private JLabel lblRicerca;
	
	private String[] tipiRicerca = {"Codice Coda","Codice Gate","Codice Slot"};
	private String[] tipiDiCoda = {"Business Class","Priority","Family","Diversamente abili"};
	
	private String[] giorni = {"1","2","3","4","5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21","22","23","24","25", "26", "27", "28", "29", "30", "31"};
	private String[] mesi = {"1", "2", "3", "4","5","6","7","8", "9", "10", "11", "12"};
	private String[] anni = {"2000","2001","2002","2003","2004","2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", 
			"2016", "2017", "2018", "2019", "2020", "2021","2022","2023","2024","2025"};
	
	public CodaDiImbarcoGUI(Controller c) {
		setResizable(false);
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Coda Di Imbarco");
		
		lblRicerca = new JLabel("Ricerca");
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setBounds(315, 11, 136, 42);
		contentPane.add(lblRicerca);
		
		JComboBox comboBoxRicerca = new JComboBox(tipiRicerca);
		comboBoxRicerca.setBounds(302, 64, 149, 22);
		contentPane.add(comboBoxRicerca);
		
		JTextArea RicercatextArea = new JTextArea();
		RicercatextArea.setBounds(312, 97, 136, 22);
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
		
		JLabel lblCodCoda = new JLabel("Codice Coda");
		lblCodCoda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodCoda.setBounds(106, 248, 81, 14);
		contentPane.add(lblCodCoda);

		
		JLabel lblTipoDiCoda = new JLabel("Tipo di coda");
		lblTipoDiCoda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDiCoda.setBounds(339, 225, 98, 22);
		contentPane.add(lblTipoDiCoda);
		
		JLabel lblCodGate = new JLabel("Codice Gate");
		lblCodGate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodGate.setBounds(339, 317, 81, 22);
		contentPane.add(lblCodGate);
		
		codCodatextField = new JTextField();
		codCodatextField.setBounds(101, 273, 86, 20);
		contentPane.add(codCodatextField);
		codCodatextField.setColumns(10);
		codCodatextField.getText();
		
		CodGatetextField = new JTextField();
		CodGatetextField.setColumns(10);
		CodGatetextField.setBounds(334, 350, 86, 20);
		CodGatetextField.getText();
		contentPane.add(CodGatetextField);
		
		JComboBox comboBoxTipiDiCoda = new JComboBox(tipiDiCoda);
		comboBoxTipiDiCoda.setBounds(302, 271, 149, 22);
		contentPane.add(comboBoxTipiDiCoda);
		
		JButton btnInserisci = new JButton("Invia");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				controller.inserisciCodaDiImbarco(codCodatextField.getText(), comboBoxTipiDiCoda.getSelectedItem().toString(), CodGatetextField.getText());
			}
		});
		btnInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInserisci.setBounds(618, 328, 142, 42);
		contentPane.add(btnInserisci);
		
		
		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setForeground(Color.BLACK);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElimina.setBounds(299, 407, 149, 42);
		contentPane.add(lblElimina);
		
		JLabel lblEliminaCodTratta = new JLabel("Inserisci CodTratta della riga da eliminare");
		lblEliminaCodTratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEliminaCodTratta.setBounds(243, 445, 275, 22);
		contentPane.add(lblEliminaCodTratta);
		
		eliminatextField = new JTextField();
		eliminatextField.setBounds(333, 478, 86, 20);
		contentPane.add(eliminatextField);
		eliminatextField.setColumns(10);
		
		
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

				controller.eliminaCodaDiImbarco(eliminatextField.getText());
			}
		});

		btnElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnElimina.setBounds(618, 465, 142, 42);
		contentPane.add(btnElimina);
		
		
		
		
		
		
	}
}
