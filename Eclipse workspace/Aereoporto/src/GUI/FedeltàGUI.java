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

public class FedeltàGUI extends JFrame {
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
	public FedeltàGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Inserisci = new JLabel("Inserisci");
		lbl_Inserisci.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_Inserisci.setBounds(363, 11, 132, 59);
		contentPane.add(lbl_Inserisci);
		
		JLabel lbl_ContaChilometri = new JLabel("Centochilometri");
		lbl_ContaChilometri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ContaChilometri.setBounds(43, 70, 146, 31);
		contentPane.add(lbl_ContaChilometri);
		
		JLabel lbl_CodIATA = new JLabel("CodiATA");
		lbl_CodIATA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_CodIATA.setBounds(272, 70, 122, 31);
		contentPane.add(lbl_CodIATA);
		
		JLabel lbl_CodFiscale = new JLabel("CodFiscale");
		lbl_CodFiscale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_CodFiscale.setBounds(448, 70, 132, 31);
		contentPane.add(lbl_CodFiscale);
		
		JLabel lbl_Punti = new JLabel("Punti");
		lbl_Punti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Punti.setBounds(610, 70, 73, 31);
		contentPane.add(lbl_Punti);
		
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
		
		JButton Button_InviaInserisci = new JButton("Invia");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.inserisciFedeltà(textFieldCentokilometri.getText(), txtCodiatatextfield.getText(), txtCodfiscaletextfield.getText(), txtPuntitextfield.getText());
//			}
//		});
		Button_InviaInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaInserisci.setBounds(728, 92, 85, 40);
		contentPane.add(Button_InviaInserisci);
		
		JLabel lbl_Ricerca = new JLabel("Ricerca");
		lbl_Ricerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Ricerca.setBounds(369, 171, 73, 31);
		contentPane.add(lbl_Ricerca);
		
		JComboBox comboBox_Ricerca = new JComboBox(ValoriScelta);
		comboBox_Ricerca.setBounds(197, 235, 95, 20);
		contentPane.add(comboBox_Ricerca);
		
		txtRicercatextfield = new JTextField();
		txtRicercatextfield.setBounds(339, 224, 132, 43);
		contentPane.add(txtRicercatextfield);
		txtRicercatextfield.setColumns(10);
		
		JLabel lbl_Elimina = new JLabel("Elimina");
		lbl_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Elimina.setBounds(371, 306, 73, 50);
		contentPane.add(lbl_Elimina);
		
		txtEliminatextfield = new JTextField();
		txtEliminatextfield.setColumns(10);
		txtEliminatextfield.setBounds(339, 367, 132, 43);
		contentPane.add(txtEliminatextfield);
		
		JButton Button_BackToMenu = new JButton("Men\u00F9");
		Button_BackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		Button_BackToMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_BackToMenu.setBounds(29, 447, 101, 57);
		contentPane.add(Button_BackToMenu);
		
		
		
		JButton Button_InviaRicerca = new JButton("Invia");
		Button_InviaRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiFedeltà(comboBox_Ricerca.getSelectedItem().toString(), txtRicercatextfield.getText());
			}
		});
		Button_InviaRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaRicerca.setBounds(507, 224, 85, 40);
		contentPane.add(Button_InviaRicerca);
		
		JButton Button_InviaElimina = new JButton("Invia");
		Button_InviaElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_InviaElimina.setBounds(522, 366, 85, 40);
		contentPane.add(Button_InviaElimina);
	}
}
