package RisultatiGUI;

import Entità.Tratta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControllerPackage.Controller;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiTrattaGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTable table;
	
	public RisultatiTrattaGUI(List<Tratta> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Tratta");
		setResizable(false);
		
		
		Vector<String> columns = new Vector<String>();
		columns.add("Codice Tratta");
		columns.add("N° Prenotazioni");
		columns.add("Orario Di Partenza");		
		columns.add("Data");
		columns.add("CodIATA");		
		columns.add("Destinazione");
		columns.add("Scali");
		columns.add("CodGate");
		columns.add("Ritardo");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		
		for(Tratta tratta: list) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(tratta.getCodTratta());
			vector.add(tratta.getNprenotazioni());
			vector.add(tratta.getOrarioDiPartenza());	
			vector.add(tratta.getData());
			vector.add(tratta.getCompagnia().getCodIATA());
			vector.add(tratta.getDestinazione());
			vector.add(tratta.getScali());	
			vector.add(tratta.getGate().getCodGate());
			vector.add(tratta.getRitardo());
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
			public void actionPerformed(ActionEvent arg0) {
				controller.openTratta();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 425, 180, 57);
		contentPane.add(btnNewButton_3);
	}
}
