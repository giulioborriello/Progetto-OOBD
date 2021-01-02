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
	private JTextField textFieldCodSlot;
	private JTextField textFieldCodCoda;
	private JTextField textFieldTempoStimato;
	private JTextField textFieldData;
	private JTextField textFieldCodaDiImbarco;
	private JTextField textFieldAggiornaIndicaCodSlot;
	private JTextField textFieldAggiornaTempoEffettivo;
	private JTextField textFieldElimina;

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
		
		JComboBox comboBoxRicerca = new JComboBox(ValoriScelta);
		comboBoxRicerca.setBounds(157, 85, 94, 22);
		contentPane.add(comboBoxRicerca);
		
		JTextArea textAreaRicerca = new JTextArea();
		textAreaRicerca.setBounds(330, 85, 136, 22);
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
		lblRicerca.setBounds(321, 22, 136, 42);
		contentPane.add(lblRicerca);
		
		JLabel lblInserisci = new JLabel("Inserimento");
		lblInserisci.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setForeground(new Color(0, 0, 0));
		lblInserisci.setBounds(321, 145, 136, 42);
		contentPane.add(lblInserisci);
		
		JLabel lblCodSlot = new JLabel("CodSlot");
		lblCodSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodSlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodSlot.setBounds(0, 194, 149, 22);
		contentPane.add(lblCodSlot);
		
		textFieldCodSlot = new JTextField();
		textFieldCodSlot.setBounds(33, 227, 86, 20);
		contentPane.add(textFieldCodSlot);
		textFieldCodSlot.setColumns(10);
		
		JLabel lblCodCoda = new JLabel("CodCoda");
		lblCodCoda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodCoda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodCoda.setBounds(157, 194, 149, 22);
		contentPane.add(lblCodCoda);
		
		textFieldCodCoda = new JTextField();
		textFieldCodCoda.setBounds(189, 227, 86, 20);
		contentPane.add(textFieldCodCoda);
		textFieldCodCoda.setColumns(10);
		
		JLabel lblTempoStimato = new JLabel("Tempo di imbarco stimato");
		lblTempoStimato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempoStimato.setBounds(307, 194, 191, 22);
		contentPane.add(lblTempoStimato);
		
		textFieldTempoStimato = new JTextField();
		textFieldTempoStimato.setBounds(359, 227, 86, 20);
		contentPane.add(textFieldTempoStimato);
		textFieldTempoStimato.setColumns(10);
		
		JLabel lblTempoEffettivo = new JLabel("Tempo di imbarco effettivo");
		lblTempoEffettivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempoEffettivo.setBounds(541, 198, 191, 14);
		contentPane.add(lblTempoEffettivo);
		
		JTextField textFieldTempoEffettivo = new JTextField();
		textFieldTempoEffettivo.setBounds(584, 227, 86, 20);
		contentPane.add(textFieldTempoEffettivo);
		textFieldTempoEffettivo.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(207, 276, 46, 14);
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(189, 301, 86, 20);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		JLabel lblCodaDiImbarco = new JLabel("Coda di imbarco");
		lblCodaDiImbarco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodaDiImbarco.setBounds(20, 274, 116, 14);
		contentPane.add(lblCodaDiImbarco);
		
		textFieldCodaDiImbarco = new JTextField();
		textFieldCodaDiImbarco.setBounds(33, 301, 86, 20);
		contentPane.add(textFieldCodaDiImbarco);
		textFieldCodaDiImbarco.setColumns(10);
		
		JButton btnNewButtonInserisci = new JButton("Invia");
		btnNewButtonInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.inserisciSlot(textFieldCodSlot.getText(), textFieldCodCoda.getText(), textFieldTempoStimato.getText(),
						textFieldTempoEffettivo.getText(), textFieldCodaDiImbarco.getText(), textFieldData.getText());
			}
		});
		btnNewButtonInserisci.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonInserisci.setBounds(584, 289, 142, 42);
		contentPane.add(btnNewButtonInserisci);
		
		
		
		
		JLabel lblAggiorna = new JLabel("Aggiorna tempo di imbarco effettivo");
		lblAggiorna.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiorna.setForeground(Color.BLACK);
		lblAggiorna.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAggiorna.setBounds(211, 366, 366, 42);
		contentPane.add(lblAggiorna);
		
		JLabel lblAggiornaInidicaCodSlot = new JLabel("Inserisci CodSlot della riga da modificare");
		lblAggiornaInidicaCodSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAggiornaInidicaCodSlot.setBounds(54, 409, 275, 40);
		contentPane.add(lblAggiornaInidicaCodSlot);
		
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
//		btnAggiorna.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.aggiornaSlot(textFieldAggiornaIndicaCodSlot.getText(), textFieldAggiornaTempoEffettivo.getText());
//			}
//		});
		btnAggiorna.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAggiorna.setBounds(588, 447, 142, 42);
		contentPane.add(btnAggiorna);
		
		
		JLabel lblElimina = new JLabel("Elimina");
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setForeground(Color.BLACK);
		lblElimina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElimina.setBounds(184, 525, 366, 42);
		contentPane.add(lblElimina);
		
		JLabel lblIndicaCodSlot = new JLabel("Inserisci CodSlot della riga da eliminare");
		lblIndicaCodSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndicaCodSlot.setBounds(235, 560, 275, 40);
		contentPane.add(lblIndicaCodSlot);
		
		textFieldElimina = new JTextField();
		textFieldElimina.setColumns(10);
		textFieldElimina.setBounds(326, 611, 86, 20);
		contentPane.add(textFieldElimina);
		
		
		JButton btnElimina = new JButton("Invia");
//		btnElimina.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.eliminaSlot(textFieldElimina.getText());
//			}
//		});
		btnElimina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnElimina.setBounds(584, 589, 142, 42);
		contentPane.add(btnElimina);
		
		JButton btnNewButton_4 = new JButton("Menu");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));

	}
}
