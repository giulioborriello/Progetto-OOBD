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
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CodaDiImbarcoGUI extends JFrame {
	Controller controller;
	String[] ValoriScelta = {"Seleziona tutti","CodCoda","Tipo Di Coda","N gate","CodSlot"};
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CodaDiImbarcoGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ricerca");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(315, 11, 136, 42);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(ValoriScelta);
		comboBox.setBounds(10, 78, 149, 82);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(315, 107, 136, 22);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(618, 98, 142, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserimento");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(315, 175, 136, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("CodCoda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(206, 245, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipoDiCoda = new JLabel("Tipo di coda");
		lblTipoDiCoda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDiCoda.setBounds(477, 237, 98, 22);
		contentPane.add(lblTipoDiCoda);
		
		JLabel lblCodslot = new JLabel("CodSlot");
		lblCodslot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodslot.setBounds(497, 323, 66, 14);
		contentPane.add(lblCodslot);
		
		JLabel lblNGate = new JLabel("N gate");
		lblNGate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNGate.setBounds(216, 315, 46, 22);
		contentPane.add(lblNGate);
		
		textField = new JTextField();
		textField.setBounds(192, 270, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(477, 270, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 348, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(477, 348, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Elimina");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(305, 398, 149, 42);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Inserisci N gate della riga da eliminare");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(239, 451, 275, 40);
		contentPane.add(lblNewLabel_7_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(337, 502, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Invia");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(618, 337, 142, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Menù");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.backToMenù();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(618, 549, 142, 42);
		contentPane.add(btnNewButton_2);
	}

}
