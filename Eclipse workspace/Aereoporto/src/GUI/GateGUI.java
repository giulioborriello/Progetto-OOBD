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
		
		JLabel lblGiorni = new JLabel("Giorni mese:");
		lblGiorni.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiorni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiorni.setBounds(134, 298, 108, 19);
		contentPane.add(lblGiorni);
		
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
		
		JComboBox comboBoxRicerca_1 = new JComboBox(mesi);
		comboBoxRicerca_1.setBounds(252, 299, 76, 20);
		contentPane.add(comboBoxRicerca_1);
		
		JComboBox comboBoxRicerca_2 = new JComboBox(anni);
		comboBoxRicerca_2.setBounds(344, 299, 50, 20);
		contentPane.add(comboBoxRicerca_2);
		
		JLabel lblMesi_1_1 = new JLabel("Anno");
		lblMesi_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMesi_1_1.setBounds(275, 337, 33, 19);
		contentPane.add(lblMesi_1_1);
		
		JComboBox MesiAnnoComboBox = new JComboBox(anni);
		MesiAnnoComboBox.setBounds(265, 431, 50, 20);
		contentPane.add(MesiAnnoComboBox);
		
		JButton btnRicerca_1 = new JButton("Invia");
		btnRicerca_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ricercaTempisticaMesi(MesiAnnoComboBox.getSelectedItem().toString());
			}
		});
		btnRicerca_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca_1.setBounds(404, 426, 71, 27);
		contentPane.add(btnRicerca_1);
		
		JButton btnRicerca_1_1 = new JButton("Invia");
		btnRicerca_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ricercaTempisticaGiorni(comboBoxRicerca_1.getSelectedItem().toString(), comboBoxRicerca_2.getSelectedItem().toString());
			}
		});
		btnRicerca_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca_1_1.setBounds(404, 294, 71, 27);
		contentPane.add(btnRicerca_1_1);
		
		
		JComboBox comboBoxRicerca_2_1 = new JComboBox(anni);
		comboBoxRicerca_2_1.setBounds(265, 367, 50, 20);
		contentPane.add(comboBoxRicerca_2_1);
		
		JButton btnRicerca_1_2 = new JButton("Invia");
		btnRicerca_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ricercaTempisticaSettimane(comboBoxRicerca_2_1.getSelectedItem().toString());
			}
		});
		btnRicerca_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca_1_2.setBounds(404, 360, 71, 27);
		contentPane.add(btnRicerca_1_2);
		
		JLabel lblMesi_1_2 = new JLabel("Mese");
		lblMesi_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesi_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMesi_1_2.setBounds(273, 272, 35, 19);
		contentPane.add(lblMesi_1_2);
		
		
		
		JLabel lblMesi_1_1_1 = new JLabel("Anno");
		lblMesi_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesi_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMesi_1_1_1.setBounds(353, 268, 33, 19);
		contentPane.add(lblMesi_1_1_1);
		
		JLabel lblMesi_1_1_1_1 = new JLabel("Anno");
		lblMesi_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesi_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMesi_1_1_1_1.setBounds(274, 404, 33, 19);
		contentPane.add(lblMesi_1_1_1_1);
		
		
	}
}