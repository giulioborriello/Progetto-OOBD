package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class Fedelt�GUI extends JFrame {
	Controller controller;
	private JPanel contentPane;
	private JTextField textFieldCentokilometri;
	private JTextField txtCodiatatextfield;
	private JTextField txtCodfiscaletextfield;
	private JTextField txtPuntitextfield;
	private JTextField txtRicercatextfield;
	private JTextField txtEliminatextfield;

    String [] ValoriScelta = {"Seleziona tutti","CentoKilometri","CodiATA","CodFiscale"};
		

	/**
	 * Create the frame.
	 */
	public Fedelt�GUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserisci");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(363, 11, 132, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Centochilometri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(43, 70, 146, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CodiATA");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(272, 70, 122, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CodFiscale");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(448, 70, 132, 31);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Punti");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(610, 70, 73, 31);
		contentPane.add(lblNewLabel_1_3);
		
		textFieldCentokilometri = new JTextField();
	    textFieldCentokilometri.setBounds(53, 101, 109, 31);
		contentPane.add(textFieldCentokilometri);
		textFieldCentokilometri.setColumns(10);
		
		txtCodiatatextfield = new JTextField();
		txtCodiatatextfield.setColumns(10);
		txtCodiatatextfield.setBounds(255, 101, 109, 31);
		contentPane.add(txtCodiatatextfield);
		
		txtCodfiscaletextfield = new JTextField();
		txtCodfiscaletextfield.setColumns(10);
		txtCodfiscaletextfield.setBounds(439, 101, 109, 31);
		contentPane.add(txtCodfiscaletextfield);
		
		txtPuntitextfield = new JTextField();
		txtPuntitextfield.setColumns(10);
		txtPuntitextfield.setBounds(586, 101, 109, 31);
		contentPane.add(txtPuntitextfield);
		
		JButton btnNewButton_1 = new JButton("Invia");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.inserisciFedelt�(textFieldCentokilometri.getText(), txtCodiatatextfield.getText(), txtCodfiscaletextfield.getText(), txtPuntitextfield.getText());
//			}
//		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(728, 92, 85, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ricerca");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(369, 171, 73, 31);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox(ValoriScelta);
		comboBox.setBounds(197, 235, 95, 20);
		contentPane.add(comboBox);
		
		txtRicercatextfield = new JTextField();
		txtRicercatextfield.setBounds(339, 224, 132, 43);
		contentPane.add(txtRicercatextfield);
		txtRicercatextfield.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Elimina");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(371, 306, 73, 50);
		contentPane.add(lblNewLabel_3);
		
		txtEliminatextfield = new JTextField();
		txtEliminatextfield.setColumns(10);
		txtEliminatextfield.setBounds(339, 367, 132, 43);
		contentPane.add(txtEliminatextfield);
		
		JButton btnNewButton_3 = new JButton("Men\u00F9");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMen�();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(29, 447, 101, 57);
		contentPane.add(btnNewButton_3);
		
		
		
		JButton btnNewButton_1_1 = new JButton("Invia");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiFedelt�(comboBox.getSelectedItem().toString(), txtRicercatextfield.getText());
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(507, 224, 85, 40);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Invia");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(522, 366, 85, 40);
		contentPane.add(btnNewButton_1_2);
	}
}
