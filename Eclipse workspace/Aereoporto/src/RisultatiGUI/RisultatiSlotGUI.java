package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControllerPackage.Controller;
import Entità.Slot;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiSlotGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTable table;
	
	public RisultatiSlotGUI(List<Slot> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Slot");
		setResizable(false);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		Vector<String> columns = new Vector<String>();
		columns.add("Codice Slot");
		columns.add("Tempo di imbarco stimato");
		columns.add("Tempo di imbarco effettivo");		
		columns.add("Data");
		columns.add("Codice Coda");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		for(Slot slot: list) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(slot.getCodSlot());
			vector.add(slot.getTempoDiImbarcoStimato());
			vector.add(slot.getTempoDiImbarcoEffettivo());	
			vector.add(slot.getData());
			if(slot.getCoda() != null) {
				vector.add(slot.getCoda().getCodCoda());	
			}
			
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
				controller.openSlot();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 385, 180, 57);
		contentPane.add(btnNewButton_3);
	}

}
