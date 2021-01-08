package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GateGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTextField textFieldRicerca;
	private String[] SelezioneRicerca = {"Giorno","Mese","Anno"};
	private String[] tipiRicerca = {"Seleziona tutti","N gate","CodTratta",};
	
	public GateGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 828);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Gate");
		
		JLabel lblRicerca = new JLabel("Ricerca");
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setBounds(393, 23, 136, 42);
		contentPane.add(lblRicerca);
		
		JComboBox comboBoxRicerca = new JComboBox(tipiRicerca);
		comboBoxRicerca.setBounds(252, 90, 94, 22);
		contentPane.add(comboBoxRicerca);
		
		textFieldRicerca = new JTextField();
		textFieldRicerca.setBounds(416, 91, 94, 20);
		contentPane.add(textFieldRicerca);
		textFieldRicerca.setColumns(10);
		

		JButton btnRicerca = new JButton("Invia");
		btnRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openRisultatiGate(comboBoxRicerca.getSelectedItem().toString(), textFieldRicerca.getText());
			}
		});
		btnRicerca.setBounds(620, 79, 85, 40);
		contentPane.add(btnRicerca);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backToMenù();
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMenu.setBounds(10, 218, 105, 57);
		contentPane.add(btnMenu);
	}
}
