package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.prefs.BackingStoreException;
import javax.swing.*;
import javax.swing.border.*;
import static com.company.Main.preferences;
import static com.company.TrayGUI.Status;

public class WindowSettings extends JFrame {
	public WindowSettings() {
		initComponents();
	}

	private void okButtonActionPerformed(ActionEvent e) throws BackingStoreException {
		preferences.putData(Arrays.asList(textArea1.getText().split("\\n")));
		Status();
		dispose();
	}

	private void cancelButtonActionPerformed(ActionEvent e) {
		dispose();
	}

	private void aplyActionPerformed(ActionEvent e) throws BackingStoreException {
		preferences.putData(Arrays.asList(textArea1.getText().split("\\n")));
		Status();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		label1 = new JLabel();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();
		aplyButton = new JButton();

		//======== this ========
		setTitle("URLS");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new BorderLayout());

				//======== scrollPane1 ========
				{

					//---- textArea1 ----
					try {
						textArea1.setText(String.join("\n", preferences.getData()));
					} catch (BackingStoreException e) {
						e.printStackTrace();
					}
					scrollPane1.setViewportView(textArea1);
				}
				contentPanel.add(scrollPane1, BorderLayout.CENTER);

				//---- label1 ----
				label1.setText("Введите адреса сайтов:");
				contentPanel.add(label1, BorderLayout.NORTH);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 85, 0};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("OK");
				okButton.addActionListener(e -> {
					try {
						okButtonActionPerformed(e);
					} catch (BackingStoreException e1) {
						e1.printStackTrace();
					}
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Отмена");
				cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- aplyButton ----
				aplyButton.setText("Применить");
				aplyButton.addActionListener(e -> {
					try {
						aplyActionPerformed(e);
					} catch (BackingStoreException e1) {
						e1.printStackTrace();
					}
				});
				buttonBar.add(aplyButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		// Параметры окна
		setSize(395,320);
		setMinimumSize(new Dimension(310, 300));
		setVisible(true);
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JLabel label1;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	private JButton aplyButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
