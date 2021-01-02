package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public Dialog(String testo) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbTesto = new JLabel("New label");
			lbTesto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbTesto.setVerticalAlignment(SwingConstants.TOP);
			lbTesto.setHorizontalAlignment(SwingConstants.CENTER);
			lbTesto.setBounds(26, 31, 378, 155);
			lbTesto.setText(testo);
			contentPanel.add(lbTesto);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
