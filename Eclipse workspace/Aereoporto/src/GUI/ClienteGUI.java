package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ClienteGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	/**
	 * Create the frame.
	 */
	public ClienteGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Inserimenti");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(345, 11, 119, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodiceFiscale.setBounds(40, 85, 104, 40);
		contentPane.add(lblCodiceFiscale);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(193, 85, 85, 40);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCognome.setBounds(358, 85, 85, 40);
		contentPane.add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(507, 85, 85, 40);
		contentPane.add(lblEmail);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(643, 124, 85, 40);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(50, 136, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 136, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(358, 136, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(507, 136, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aggiorna Email");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(309, 194, 176, 58);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblIndicareCodiceFiscale = new JLabel("Indicare Codice Fiscale");
		lblIndicareCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndicareCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndicareCodiceFiscale.setBounds(124, 263, 154, 40);
		contentPane.add(lblIndicareCodiceFiscale);
		
		JLabel lblNuovaEmail = new JLabel("Nuova email");
		lblNuovaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuovaEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNuovaEmail.setBounds(345, 263, 104, 40);
		contentPane.add(lblNuovaEmail);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(161, 307, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(357, 307, 86, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Invia");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(544, 287, 85, 40);
		contentPane.add(btnNewButton_1);
	}

}