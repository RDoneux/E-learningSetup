package settings;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import display.Frame;

public class SettingsButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7415216740379094252L;

	public SettingsButton() {

		Font font = new Font("lucida Console", Font.PLAIN, 16);

		setText("Settings");
		setFont(font);
		setMinimumSize(new Dimension(280, 40));
		setPreferredSize(new Dimension(280, 40));
		setMaximumSize(new Dimension(280, 40));
		setAlignmentX(JButton.CENTER_ALIGNMENT);

		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Frame.addPanel(new SettingsMenu());

	}

}
