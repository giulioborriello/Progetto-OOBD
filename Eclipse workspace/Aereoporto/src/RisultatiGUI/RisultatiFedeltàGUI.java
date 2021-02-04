package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControllerPackage.Controller;
import Entit‡.Fedelt‡;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RisultatiFedelt‡GUI extends JFrame {

	private Controller controller;
	
	private JPanel contentPane;
	private JTable table;
	
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
		
		
		Vector<String> columns = new Vector<String>();
		columns.add("Codice Fiscale");
		columns.add("Codice IATA");
		columns.add("Codice CentoKilometri");		
		columns.add("Punti");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		for(Fedelt‡ fedelt‡: list) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(fedelt‡.getCliente().getCodFiscale());
			vector.add(fedelt‡.getCompagnia().getCodIATA());
			vector.add(fedelt‡.getCentoKilometri());	
			vector.add(fedelt‡.getPunti());
			data.add(vector);
		}
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setLocation(114, 11);
		scrollpane.setSize(425, 347);
		
		table = new JTable(new DefaultTableModel(data, columns));
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(114, 11, 425, 347);
		
		scrollpane.setViewportView(table);
		contentPane.add(scrollpane);
		
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
