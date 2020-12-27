package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenùGUI extends JFrame {
	Controller controller;
	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public MenùGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gate");
		btnNewButton.setBounds(205, 181, 124, 70);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Slot");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controller.OpenSlot();
			}
		});
		btnNewButton_1.setBounds(485, 181, 124, 70);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tratta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(205, 100, 124, 70);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Fedelt\u00E0");
		btnNewButton_3.setBounds(205, 262, 124, 70);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Compagnia");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setBounds(485, 262, 124, 70);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Coda di imbarco");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_5.setBounds(205, 343, 124, 70);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Biglietto");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_6.setBounds(485, 100, 124, 70);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("Scegli dove effettuare le operazioni");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(129, 11, 564, 80);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_7 = new JButton("Cliente");
		btnNewButton_7.setBounds(485, 343, 124, 70);
		contentPane.add(btnNewButton_7);
	}
}
