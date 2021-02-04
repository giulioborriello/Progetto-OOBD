package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControllerPackage.Controller;
import Entità.Biglietto;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiBigliettoGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTable table;
	
	public RisultatiBigliettoGUI(List<Biglietto> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Biglietto");
		setResizable(false);
		
		
		
		
		Vector<String> columns = new Vector<String>();
		columns.add("Codice Biglietto");
		columns.add("Posto");
		columns.add("Tipo");		
		columns.add("Tratta");
		columns.add("Cliente");	
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		
		for(Biglietto biglietto: list) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(biglietto.getCodBiglietto());
			vector.add(biglietto.getPosto());
			vector.add(biglietto.getTipoDiBiglietto());	
			vector.add(biglietto.getTratta().getCodTratta());
			vector.add(biglietto.getCliente().getCodFiscale());
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
			controller.openBiglietto();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(34, 414, 180, 57);
		contentPane.add(btnNewButton_3);
	}
}
