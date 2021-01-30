package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;
import Entit‡.Fedelt‡;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RisultatiFedelt‡GUI extends JFrame {

	private Controller controller;
	
	private JPanel contentPane;
	
	
	public RisultatiFedelt‡GUI(List<Fedelt‡> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Fedelt‡");
		setResizable(false);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		String titoli = "Codice Fiscale " + "Codice IATA" + "Codice CentoKilometri " + "Punti ";
		listModel.addElement(titoli);
		
		
		for(Fedelt‡ fedelt‡: list) {
			String string = fedelt‡.getCliente().getCodFiscale() + " " + fedelt‡.getCompagnia().getCodIATA() + " " + fedelt‡.getCentoKilometri() + " " + fedelt‡.getPunti();
			listModel.addElement(string);
			
		}
		
		JList jlist = new JList(listModel);
		jlist.setBounds(10, 11, 673, 363);
		contentPane.add(jlist);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openFedelt‡();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 385, 180, 57);
		contentPane.add(btnNewButton_3);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public RisultatiFedelt‡GUI(int NumeroRitardi, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Fedelt‡");
		
		
	
		
		
		
		JButton btnTornaIndietro = new JButton("Torna indietro ");
		btnTornaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openFedelt‡();
			}
		});
		btnTornaIndietro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTornaIndietro.setBounds(10, 385, 180, 57);
		contentPane.add(btnTornaIndietro);
		
		JLabel lblValore = new JLabel("New label");
		lblValore.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblValore.setHorizontalAlignment(SwingConstants.CENTER);
		lblValore.setBounds(116, 63, 418, 265);
		contentPane.add(lblValore);
		lblValore.setText(String.valueOf(NumeroRitardi));
		
		JLabel lblTitolo = new JLabel("NumeroRitardi");
		lblTitolo.setBounds(288, 11, 135, 57);
		contentPane.add(lblTitolo);
	}

}
