package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenùGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	
	public MenùGUI(Controller c) {
		setResizable(false);
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Menù");
		
		JButton btnGate = new JButton("Gate");
		btnGate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openGate();
			}
		});
		btnGate.setBounds(199, 299, 124, 70);
		contentPane.add(btnGate);
		
		JButton btnSlot = new JButton("Slot");
		btnSlot.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openSlot();
			}
		});
		btnSlot.setBounds(479, 299, 124, 70);
		contentPane.add(btnSlot);
		
		JButton btnTratta = new JButton("Tratta");
		btnTratta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTratta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openTratta();
			}
		});
		btnTratta.setBounds(199, 218, 124, 70);
		contentPane.add(btnTratta);
		
		JButton btnFedeltà = new JButton("Fedelt\u00E0");
		btnFedeltà.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFedeltà.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openFedeltà();
			}
		});
		btnFedeltà.setBounds(199, 380, 124, 70);
		contentPane.add(btnFedeltà);
		
		JButton btnCompagnia = new JButton("Compagnia");
		btnCompagnia.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCompagnia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openCompagnia();
			}
		});
		btnCompagnia.setBounds(479, 380, 124, 70);
		contentPane.add(btnCompagnia);
		
		JButton btnCodaDiImbarco = new JButton("Coda di imbarco");
		btnCodaDiImbarco.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCodaDiImbarco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openCodaDiImbarco();
			}
		});
		btnCodaDiImbarco.setBounds(182, 461, 158, 70);
		contentPane.add(btnCodaDiImbarco);
		
		JButton btnBiglietto = new JButton("Biglietto");
		btnBiglietto.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBiglietto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openBiglietto();
			}
		});
		btnBiglietto.setBounds(479, 218, 124, 70);
		contentPane.add(btnBiglietto);
		
		JLabel lblTitolo = new JLabel("Scegli dove effettuare le operazioni");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTitolo.setBounds(126, 45, 564, 35);
		contentPane.add(lblTitolo);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openCliente();
			}
		});
		btnCliente.setBounds(479, 461, 124, 70);
		contentPane.add(btnCliente);
		
		JLabel lblSottotitolo2 = new JLabel("Per inserire un volo seguire la sequenza: Compagnia -> Tratta -> Gate -> Coda Di Imbarco -> Slot");
		lblSottotitolo2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSottotitolo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSottotitolo2.setBounds(45, 106, 695, 25);
		contentPane.add(lblSottotitolo2);
	}
}
