package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ControllerPackage.Controller;
import Entità.Cliente;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class RisultatiClienteGUI extends JFrame {
	
	private Controller controller;
	
	private JPanel contentPane;
	private JTable table;
	

	@SuppressWarnings("serial")
	public RisultatiClienteGUI(List<Cliente> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Cliente");
		setResizable(false);
		
		
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openCliente();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(55, 385, 180, 57);
		contentPane.add(btnNewButton_3);
		
		
		
		Vector<String> columns = new Vector<String>();
		columns.add("Codice Fiscale");
		columns.add("Nome");
		columns.add("Cognome");		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		for(Cliente cliente: list) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(cliente.getCodFiscale());
			vector.add(cliente.getNome());
			vector.add(cliente.getCognome());			
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
	}
	
	
}
