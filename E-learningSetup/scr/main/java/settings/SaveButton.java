package settings;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SaveButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4367773040177324040L;

	private SettingsMenu menu;

	public SaveButton(SettingsMenu menu) {

		this.menu = menu;
		Font font = new Font("lucida Console", Font.PLAIN, 16);

		setText("Save");
		setFont(font);
		setMinimumSize(new Dimension(140, 30));
		setPreferredSize(new Dimension(140, 30));
		setMaximumSize(new Dimension(140, 30));
		setAlignmentX(JButton.CENTER_ALIGNMENT);

		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Constants.font = menu.fontType.getText();
		Constants.masterFile = menu.fileLocation.getText();

		Constants.saveSettings();

	}

}
