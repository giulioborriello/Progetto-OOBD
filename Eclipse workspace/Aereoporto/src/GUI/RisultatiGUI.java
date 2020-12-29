package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;

public class RisultatiGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RisultatiGUI(String[] list) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 	    JList list = new JList(list);
 	   DefaultListModel listModel = new DefaultListModel();
 	  
 	   for (int i = 0; i < list.l; i++)
 	  	{
 		  	listModel.addElement(arrayList().get(i));
 	  	}
 	  	list.setModel(listModel);
	}
	

	
	
}
