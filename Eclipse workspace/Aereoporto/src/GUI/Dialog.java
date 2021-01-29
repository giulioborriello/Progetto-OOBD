package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public Dialog(String testo) {
		setResizable(false);
		setBounds(100, 100, 1250, 510);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbTesto = new JLabel("New label");
			lbTesto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbTesto.setVerticalAlignment(SwingConstants.TOP);
			lbTesto.setHorizontalAlignment(SwingConstants.CENTER);
			lbTesto.setBounds(26, 31, 1198, 396);
			lbTesto.setText(testo);
			contentPanel.add(lbTesto);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
