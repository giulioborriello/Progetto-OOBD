package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOPostgres.SlotDAOPostgres;
import Entità.Slot;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class SlotGUI extends JFrame {
	String[] ValoriScelta = {"Seleziona tutti","CodSlot","CodCoda","Data"};
	Controller controller;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public SlotGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(ValoriScelta);
		comboBox.setBounds(23, 97, 149, 82);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(321, 137, 136, 22);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = (String) comboBox.getSelectedItem(); 
				if (temp.equals("Seleziona tutti")) {
					SlotDAOPostgres sl = new SlotDAOPostgres(controller.conn);			
					List<Slot> ls = sl.getAllSlot();
					for (Slot slot: ls) {
						System.out.println(slot.getCodSlot());
					}
				
				}
			}
	});
		btnNewButton.setBounds(596, 128, 142, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ricerca");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(321, 40, 136, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserimento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(321, 215, 136, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CodSlot");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 264, 149, 22);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(33, 297, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("CodCoda");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(157, 264, 149, 22);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 297, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tempo di imbarco stimato");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(316, 264, 191, 22);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(359, 297, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tempo di imbarco effettivo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(541, 268, 191, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(584, 297, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(207, 346, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(189, 371, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Coda di imbarco");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(20, 344, 116, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(33, 371, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aggiorna tempo di imbarco effettivo");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(207, 448, 366, 42);
		contentPane.add(lblNewLabel_1_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(142, 552, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Inserisci CodSlot della riga da modificare");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(50, 501, 275, 40);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Inserisci il nuovo valore");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(335, 514, 160, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(372, 552, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Elimina");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(189, 640, 366, 42);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Inserisci CodSlot della riga da eliminare");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(240, 675, 275, 40);
		contentPane.add(lblNewLabel_7_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(331, 726, 86, 20);
		contentPane.add(textField_8);
		
		JButton btnNewButton_1 = new JButton("Invia");
		btnNewButton_1.setBounds(596, 370, 142, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Invia");
		btnNewButton_2.setBounds(596, 541, 142, 42);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Invia");
		btnNewButton_3.setBounds(596, 686, 142, 42);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Indietro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		btnNewButton_4.setBounds(30, 686, 119, 42);
		contentPane.add(btnNewButton_4);
		
	}
}
