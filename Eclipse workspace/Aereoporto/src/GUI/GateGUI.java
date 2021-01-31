package GUI;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;

public class GateGUI extends JFrame {
	private Controller controller;
	private JPanel contentPane;
	private JTextField textFieldRicerca;
	private String[] tipiRicerca = {"N gate","CodTratta",};
	private String[] giorni = {"1","2","3","4","5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21","22","23","24","25", "26", "27", "28", "29", "30", "31"};
	private String[] mesi = {"1", "2", "3", "4","5","6","7","8", "9", "10", "11", "12"};
	private String[] anni = {"2000","2001","2002","2003","2004","2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", 
			"2016", "2017", "2018", "2019", "2020", "2021","2022","2023","2024","2025"};
	private String[] Ngate = {"1", "2", "3", "4", "5"};
	
	JButton btnMenu;
	private JTextField CodGateInserimentoTextField;
	private JTextField CodTrattaInserimentoTextField;
	private JComboBox comboBoxNgateInserimento;
	private JTextField textFieldCodGateElimina;
	
	public GateGUI(Controller c) {
		controller = c;	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 893);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setTitle("Gate");
		
		JLabel lblRicerca = new JLabel("Ricerca");
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setBounds(252, 11, 136, 42);
		contentPane.add(lblRicerca);
		
		JComboBox comboBoxRicerca = new JComboBox(tipiRicerca);
		comboBoxRicerca.setBounds(19, 96, 94, 22);
		contentPane.add(comboBoxRicerca);
		
		textFieldRicerca = new JTextField();
		textFieldRicerca.setBounds(19, 129, 94, 20);
		contentPane.add(textFieldRicerca);
		textFieldRicerca.setColumns(10);
		
		JLabel lbl_Data = new JLabel("Data");
		lbl_Data.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Data.setBounds(298, 65, 35, 14);
		contentPane.add(lbl_Data);
		
		JLabel lbl_Mese = new JLabel("Mese");
		lbl_Mese.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Mese.setBounds(298, 101, 35, 14);
		contentPane.add(lbl_Mese);
		
		JLabel lbl_Giorno = new JLabel("Giorno");
		lbl_Giorno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Giorno.setBounds(167, 99, 46, 14);
		contentPane.add(lbl_Giorno);
		
		JComboBox comboBox_Giorno = new JComboBox(giorni);
		comboBox_Giorno.setBounds(139, 123, 103, 22);
		contentPane.add(comboBox_Giorno);
		
		JComboBox comboBox_Mese = new JComboBox(mesi);
		comboBox_Mese.setBounds(264, 125, 103, 22);
		contentPane.add(comboBox_Mese);
		
		JComboBox comboBox_Anno = new JComboBox(anni);
		comboBox_Anno.setBounds(384, 125, 103, 22);
		contentPane.add(comboBox_Anno);
		
		JLabel lbl_Anno = new JLabel("Anno");
		lbl_Anno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Anno.setBounds(418, 101, 35, 14);
		contentPane.add(lbl_Anno);
		
		
		JButton btnRicerca = new JButton("Invia");
		btnRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String data = comboBox_Giorno.getSelectedItem().toString() + "-" + comboBox_Mese.getSelectedItem().toString() + "-" + comboBox_Anno.getSelectedItem().toString(); 
				
				
				controller.openRisultatiGate(comboBoxRicerca.getSelectedItem().toString(), textFieldRicerca.getText(), data);
			}
		});
		btnRicerca.setBounds(512, 107, 85, 40);
		contentPane.add(btnRicerca);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMenu.setBounds(19, 786, 105, 57);
		contentPane.add(btnMenu);
		contentPane.setLayout(null);
		
		JLabel lblTempistiche = new JLabel("Tempistiche");
		lblTempistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempistiche.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTempistiche.setBounds(261, 217, 108, 25);
		contentPane.add(lblTempistiche);
		
		JLabel lblGiorniMese = new JLabel("Giorni mese:");
		lblGiorniMese.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiorniMese.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiorniMese.setBounds(134, 298, 108, 19);
		contentPane.add(lblGiorniMese);
		
		JLabel lblSettimane = new JLabel("Settimane:");
		lblSettimane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettimane.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSettimane.setBounds(153, 364, 81, 19);
		contentPane.add(lblSettimane);
		
		JLabel lblMesi_Tempistiche = new JLabel("Mesi:");
		lblMesi_Tempistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesi_Tempistiche.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMesi_Tempistiche.setBounds(175, 426, 40, 19);
		contentPane.add(lblMesi_Tempistiche);
		
		JComboBox comboBoxRicerca_GiorniMeseMesi = new JComboBox(mesi);
		comboBoxRicerca_GiorniMeseMesi.setBounds(252, 299, 76, 20);
		contentPane.add(comboBoxRicerca_GiorniMeseMesi);
		
		JComboBox comboBoxRicerca_GiorniMeseAnno = new JComboBox(anni);
		comboBoxRicerca_GiorniMeseAnno.setBounds(344, 299, 50, 20);
		contentPane.add(comboBoxRicerca_GiorniMeseAnno);
		
		JLabel lblRicercaSettimane_Anno = new JLabel("Anno");
		lblRicercaSettimane_Anno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercaSettimane_Anno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRicercaSettimane_Anno.setBounds(275, 337, 33, 19);
		contentPane.add(lblRicercaSettimane_Anno);
		
		JComboBox comboBoxRicerca_Anno = new JComboBox(anni);
		comboBoxRicerca_Anno.setBounds(265, 431, 50, 20);
		contentPane.add(comboBoxRicerca_Anno);
		
		JButton btnRicerca_Mesi = new JButton("Invia");
		btnRicerca_Mesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ricercaTempisticaMesi(comboBoxRicerca_Anno.getSelectedItem().toString());
			}
		});
		btnRicerca_Mesi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca_Mesi.setBounds(404, 426, 71, 27);
		contentPane.add(btnRicerca_Mesi);
		
		JButton btnRicerca_GiorniMese = new JButton("Invia");
		btnRicerca_GiorniMese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ricercaTempisticaGiorni(comboBoxRicerca_GiorniMeseMesi.getSelectedItem().toString(), comboBoxRicerca_GiorniMeseAnno.getSelectedItem().toString());
			}
		});
		btnRicerca_GiorniMese.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca_GiorniMese.setBounds(404, 294, 71, 27);
		contentPane.add(btnRicerca_GiorniMese);
		
		
		JComboBox comboBoxRicerca_Settimane = new JComboBox(anni);
		comboBoxRicerca_Settimane.setBounds(265, 367, 50, 20);
		contentPane.add(comboBoxRicerca_Settimane);
		
		JButton btnRicerca_Settimane = new JButton("Invia");
		btnRicerca_Settimane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ricercaTempisticaSettimane(comboBoxRicerca_Settimane.getSelectedItem().toString());
			}
		});
		btnRicerca_Settimane.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca_Settimane.setBounds(404, 360, 71, 27);
		contentPane.add(btnRicerca_Settimane);
		
		JLabel lblRicercaGiorniMese_Mese = new JLabel("Mese");
		lblRicercaGiorniMese_Mese.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercaGiorniMese_Mese.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRicercaGiorniMese_Mese.setBounds(273, 272, 35, 19);
		contentPane.add(lblRicercaGiorniMese_Mese);
		
		
		
		JLabel lblRicercaGiorniMese_Anno = new JLabel("Anno");
		lblRicercaGiorniMese_Anno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercaGiorniMese_Anno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRicercaGiorniMese_Anno.setBounds(353, 268, 33, 19);
		contentPane.add(lblRicercaGiorniMese_Anno);
		
		JLabel lblRicercaMesi_Anno = new JLabel("Anno");
		lblRicercaMesi_Anno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercaMesi_Anno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRicercaMesi_Anno.setBounds(274, 404, 33, 19);
		contentPane.add(lblRicercaMesi_Anno);
		
		JLabel lblInserimento = new JLabel("Inserimento");
		lblInserimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInserimento.setBounds(259, 496, 108, 25);
		contentPane.add(lblInserimento);
		
		JLabel lblCodGateInserimento = new JLabel("CodGate");
		lblCodGateInserimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodGateInserimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodGateInserimento.setBounds(119, 540, 108, 25);
		contentPane.add(lblCodGateInserimento);
		
		CodGateInserimentoTextField = new JTextField();
		CodGateInserimentoTextField.setColumns(10);
		CodGateInserimentoTextField.setBounds(126, 576, 94, 20);
		contentPane.add(CodGateInserimentoTextField);
		
		comboBoxNgateInserimento = new JComboBox(Ngate);
		comboBoxNgateInserimento.setBounds(273, 575, 94, 22);
		contentPane.add(comboBoxNgateInserimento);
		
		JLabel lblnGate = new JLabel("NGate");
		lblnGate.setHorizontalAlignment(SwingConstants.CENTER);
		lblnGate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnGate.setBounds(264, 540, 108, 25);
		contentPane.add(lblnGate);
		
		JLabel lblCodTratta = new JLabel("CodTratta");
		lblCodTratta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodTratta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodTratta.setBounds(418, 540, 108, 25);
		contentPane.add(lblCodTratta);
		
		CodTrattaInserimentoTextField = new JTextField();
		CodTrattaInserimentoTextField.setColumns(10);
		CodTrattaInserimentoTextField.setBounds(428, 576, 94, 20);
		contentPane.add(CodTrattaInserimentoTextField);
		
		JButton btnInserisci = new JButton("Invia");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.inserisciGate(CodGateInserimentoTextField.getText(), comboBoxNgateInserimento.getSelectedItem().toString(), CodTrattaInserimentoTextField.getText());

			}
		});
		btnInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInserisci.setBounds(585, 564, 85, 40);
		contentPane.add(btnInserisci);
		
		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblElimina.setBounds(264, 618, 108, 25);
		contentPane.add(lblElimina);
		
		JLabel lblCodGate_Elimina = new JLabel("CodGate");
		lblCodGate_Elimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodGate_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodGate_Elimina.setBounds(264, 654, 108, 25);
		contentPane.add(lblCodGate_Elimina);
		
		textFieldCodGateElimina = new JTextField();
		textFieldCodGateElimina.setColumns(10);
		textFieldCodGateElimina.setBounds(271, 690, 94, 20);
		contentPane.add(textFieldCodGateElimina);
		
		
		JButton btnElimina = new JButton("Invia");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eliminaGate(textFieldCodGateElimina.getText());
			}
		});
		btnElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnElimina.setBounds(585, 674, 85, 40);
		contentPane.add(btnElimina);
		
		
		
		
		
	}
}