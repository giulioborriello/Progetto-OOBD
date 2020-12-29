package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entit�.Gate;

import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;

public class RisultatiGateGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RisultatiGateGUI(List<Gate> list) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<Gate> listModel = new DefaultListModel<Gate>();
		
		for(Gate gate:list) {
			System.out.println(gate.getNgate());
			//listModel.addElement(gate);
		}
		
 	    JList<Gate> jlist = new JList<Gate>(listModel);
 	    jlist.setLocation(62, 49);
 	    jlist.setSize(400, 363);
 	    contentPane.add(jlist);
	}
	

	
	
}
