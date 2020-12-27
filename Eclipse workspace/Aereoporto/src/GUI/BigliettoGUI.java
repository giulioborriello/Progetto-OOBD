package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class BigliettoGUI extends JFrame {

	Controller controller;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	String[] ValoriScelta = {"Seleziona tutti", "Codice Biglietto", "Codice Fiscale", "Nome", "Posto", "Tipo di biglietto",  "Codice Tratta"};
	private JTextField textField_6;
	

	/**
	 * Create the frame.
	 */
	public BigliettoGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Per:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(252, 232, 51, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserimenti");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(316, 23, 119, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCodtratta = new JLabel("CodBiglietto");
		lblCodtratta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodtratta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodtratta.setBounds(28, 82, 85, 40);
		contentPane.add(lblCodtratta);
		
		JLabel lblCodfiscale = new JLabel("CodFiscale");
		lblCodfiscale.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodfiscale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodfiscale.setBounds(146, 82, 85, 40);
		contentPane.add(lblCodfiscale);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(252, 82, 85, 40);
		contentPane.add(lblNome);
		
		JLabel lblPosto = new JLabel("Posto");
		lblPosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosto.setBounds(363, 82, 85, 40);
		contentPane.add(lblPosto);
		
		JLabel lblTipodibiglietto = new JLabel("TipoDiBiglietto");
		lblTipodibiglietto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipodibiglietto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipodibiglietto.setBounds(458, 82, 139, 40);
		contentPane.add(lblTipodibiglietto);
		
		JLabel lblCodtratta_5 = new JLabel("CodTratta");
		lblCodtratta_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodtratta_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodtratta_5.setBounds(621, 82, 85, 40);
		contentPane.add(lblCodtratta_5);
		
		textField = new JTextField();
		textField.setBounds(28, 133, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 133, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(251, 133, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(363, 133, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(488, 133, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(620, 133, 86, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ricerca");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(316, 174, 119, 58);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(751, 115, 85, 40);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox(ValoriScelta);
		comboBox.setBounds(330, 237, 103, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Invia");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(456, 228, 85, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Elimina");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(316, 302, 119, 58);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblCodtratta_1 = new JLabel("CodBiglietto");
		lblCodtratta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodtratta_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodtratta_1.setBounds(174, 357, 139, 40);
		contentPane.add(lblCodtratta_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(336, 371, 86, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton_1_1 = new JButton("Invia");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(456, 359, 85, 40);
		contentPane.add(btnNewButton_1_1);
	}
}
