package RisultatiGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entità.Cliente;
import GUI.Controller;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiClienteGUI extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	public RisultatiClienteGUI(List<Cliente> list, Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Risultati Cliente");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(Cliente cliente: list) {
			String string = cliente.getCodFiscale() + cliente.getNome() + " " + cliente.getCognome() + " " + cliente.getEmail();
			listModel.addElement(string);
			
		}
		
		
		JList jlist = new JList(listModel);
		jlist.setBounds(10, 11, 400, 363);
		contentPane.add(jlist);
		
		JButton btnNewButton_3 = new JButton("Torna indietro ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openCliente();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 385, 180, 57);
		contentPane.add(btnNewButton_3);
	}

}
