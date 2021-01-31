
package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControllerPackage.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class SlotGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTextField textFieldCodSlot;
	private JTextField textFieldCodCoda;
	private JTextField textFieldTempoStimato;
	private JTextField textFieldData;
	private JTextField textFieldAggiornaIndicaCodSlot;
	private JTextField textFieldAggiornaTempoEffettivo;
	private JTextField textFieldElimina;
	private JTextField textFieldTempoEffettivo;
	
	private String[] tipiRicerca = {"Seleziona tutti","CodSlot","CodCoda","Data"};
	private JTextField textFieldOrarioDiPartenza;
	
	
	public SlotGUI(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Slot");
		setResizable(false);
		
		JComboBox comboBoxRicerca = new JComboBox(tipiRicerca);
		comboBoxRicerca.setBounds(157, 85, 94, 22);
		contentPane.add(comboBoxRicerca);
		
		JTextArea textAreaRicerca = new JTextArea();
		textAreaRicerca.setBounds(309, 85, 136, 22);
		contentPane.add(textAreaRicerca);
		
		JButton btnRicerca = new JButton("Invia");
		btnRicerca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.openRisultatiSlot(comboBoxRicerca.getSelectedItem().toString(), textAreaRicerca.getText());
			}
	});
		btnRicerca.setBounds(584, 73, 142, 42);
		contentPane.add(btnRicerca);
		
		JLabel lblRicerca = new JLabel("Ricerca");
		lblRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setBounds(309, 11, 136, 42);
		contentPane.add(lblRicerca);
		
		JLabel lblInserisci = new JLabel("Inserimento");
		lblInserisci.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setForeground(new Color(0, 0, 0));
		lblInserisci.setBounds(309, 141, 136, 42);
		contentPane.add(lblInserisci);
		
		JLabel lblCodSlot = new JLabel("CodSlot");
		lblCodSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodSlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodSlot.setBounds(35, 193, 149, 22);
		contentPane.add(lblCodSlot);
		
		textFieldCodSlot = new JTextField();
		textFieldCodSlot.setBounds(66, 226, 86, 20);
		contentPane.add(textFieldCodSlot);
		textFieldCodSlot.setColumns(10);
		
		JLabel lblCodCoda = new JLabel("CodCoda");
		lblCodCoda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodCoda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodCoda.setBounds(193, 192, 149, 22);
		contentPane.add(lblCodCoda);
		
		textFieldCodCoda = new JTextField();
		textFieldCodCoda.setBounds(225, 225, 86, 20);
		contentPane.add(textFieldCodCoda);
		textFieldCodCoda.setColumns(10);
		
		JLabel lblTempoStimato = new JLabel("Tempo di imbarco stimato");
		lblTempoStimato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempoStimato.setBounds(331, 194, 171, 22);
		contentPane.add(lblTempoStimato);
		
		textFieldTempoStimato = new JTextField();
		textFieldTempoStimato.setBounds(373, 226, 86, 20);
		contentPane.add(textFieldTempoStimato);
		textFieldTempoStimato.setColumns(10);
		
		JLabel lblTempoEffettivo = new JLabel("Tempo di imbarco effettivo");
		lblTempoEffettivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempoEffettivo.setBounds(21, 275, 177, 14);
		contentPane.add(lblTempoEffettivo);
		
		textFieldTempoEffettivo = new JTextField();
		textFieldTempoEffettivo.setBounds(66, 304, 86, 20);
		contentPane.add(textFieldTempoEffettivo);
		textFieldTempoEffettivo.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(245, 275, 46, 14);
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(225, 304, 86, 20);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		JButton btnNewButtonInserisci = new JButton("Invia");
		btnNewButtonInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controller.inserisciSlot(textFieldCodCoda.getText(), textFieldTempoStimato.getText(),
							textFieldTempoEffettivo.getText(), textFieldData.getText(), textFieldOrarioDiPartenza.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonInserisci.setBounds(584, 289, 142, 42);
		contentPane.add(btnNewButtonInserisci);
		
		
		
		
		JLabel lblAggiorna = new JLabel("Aggiorna tempo di imbarco effettivo");
		lblAggiorna.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiorna.setForeground(Color.BLACK);
		lblAggiorna.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAggiorna.setBounds(194, 366, 366, 42);
		contentPane.add(lblAggiorna);
		
		JLabel lblAggiornaIndicaCodSlot = new JLabel("Inserisci CodSlot della riga da modificare");
		lblAggiornaIndicaCodSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAggiornaIndicaCodSlot.setBounds(54, 409, 275, 40);
		contentPane.add(lblAggiornaIndicaCodSlot);
		
		JLabel lblAggiornaTempoEffettivo = new JLabel("Inserisci il nuovo valore");
		lblAggiornaTempoEffettivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAggiornaTempoEffettivo.setBounds(339, 422, 160, 14);
		contentPane.add(lblAggiornaTempoEffettivo);
		
		textFieldAggiornaIndicaCodSlot = new JTextField();
		textFieldAggiornaIndicaCodSlot.setBounds(146, 460, 86, 20);
		contentPane.add(textFieldAggiornaIndicaCodSlot);
		textFieldAggiornaIndicaCodSlot.setColumns(10);
		
		textFieldAggiornaTempoEffettivo = new JTextField();
		textFieldAggiornaTempoEffettivo.setBounds(376, 460, 86, 20);
		contentPane.add(textFieldAggiornaTempoEffettivo);
		textFieldAggiornaTempoEffettivo.setColumns(10);
		
		
		JButton btnAggiorna = new JButton("Invia");
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.aggiornaSlot(textFieldAggiornaIndicaCodSlot.getText(), textFieldAggiornaTempoEffettivo.getText());
			}
		});
		btnAggiorna.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAggiorna.setBounds(584, 447, 142, 42);
		contentPane.add(btnAggiorna);
		
		
		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setForeground(Color.BLACK);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElimina.setBounds(309, 507, 136, 42);
		contentPane.add(lblElimina);
		
		JLabel lblIndicaCodSlot = new JLabel("Inserisci CodSlot della riga da eliminare");
		lblIndicaCodSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndicaCodSlot.setBounds(240, 560, 275, 40);
		contentPane.add(lblIndicaCodSlot);
		
		textFieldElimina = new JTextField();
		textFieldElimina.setColumns(10);
		textFieldElimina.setBounds(334, 611, 86, 20);
		contentPane.add(textFieldElimina);
		
		
		JButton btnElimina = new JButton("Invia");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eliminaSlot(textFieldElimina.getText());
			}
		});
		btnElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnElimina.setBounds(584, 589, 142, 42);
		contentPane.add(btnElimina);
		
		JButton btnMenù = new JButton("Men\u00F9");
		btnMenù.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.backToMenù();
			}
		});
		btnMenù.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMenù.setBounds(33, 673, 142, 42);
		contentPane.add(btnMenù);
		
		textFieldOrarioDiPartenza = new JTextField();
		textFieldOrarioDiPartenza.setColumns(10);
		textFieldOrarioDiPartenza.setBounds(373, 304, 86, 20);
		contentPane.add(textFieldOrarioDiPartenza);
		
		JLabel lblOrarioDiPartenza = new JLabel("Orario di partenza");
		lblOrarioDiPartenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrarioDiPartenza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrarioDiPartenza.setBounds(353, 277, 149, 14);
		contentPane.add(lblOrarioDiPartenza);
		
		JButton btnNewButton_4 = new JButton("Menu");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));

	}
}
