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
	private String[] tipiRicerca = {"Seleziona tutti","N gate","CodTratta",};
	private String[] mesi = {"1", "2", "3", "4","5","6","7","8", "9", "10", "11", "12"};
	private String[] anni = {"2000","2001","2002","2003","2004","2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", 
			"2016", "2017", "2018", "2019", "2020", "2021","2022","2023","2024","2025"};
	JButton btnMenu;
	
	public GateGUI(Controller c) {
		controller = c;	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 339);
		setBounds(100, 100, 676, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("Gate");
		
		JLabel lblRicerca = new JLabel("Ricerca");
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setBounds(259, 51, 136, 42);
		contentPane.add(lblRicerca);
		
		JComboBox comboBoxRicerca = new JComboBox(tipiRicerca);
		comboBoxRicerca.setBounds(130, 116, 94, 22);
		contentPane.add(comboBoxRicerca);
		
		textFieldRicerca = new JTextField();
		textFieldRicerca.setBounds(282, 119, 94, 20);
		contentPane.add(textFieldRicerca);
		textFieldRicerca.setColumns(10);
		

		JButton btnRicerca = new JButton("Invia");
		btnRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiGate(comboBoxRicerca.getSelectedItem().toString(), textFieldRicerca.getText());
			}
		});
		btnRicerca.setBounds(408, 107, 85, 40);
		contentPane.add(btnRicerca);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMenu.setBounds(87, 204, 105, 57);
		btnMenu.setBounds(35, 560, 105, 57);
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
		
		JLabel lblMesi = new JLabel("Mesi:");
		lblMesi.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMesi.setBounds(175, 426, 40, 19);
		contentPane.add(lblMesi);
		
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
		
		
	}
}