package mainmenu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import settings.SettingsButton;
import setup.SetUpButton;

public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2706103664824212654L;

	public MainMenu() {

		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		c.weightx = 1;
		c.weighty = 0.4;
		c.anchor = GridBagConstraints.SOUTH;
		add(new SetUpButton(), c);

		c.gridy = 1;
		c.weighty = 0.2;
		c.anchor = GridBagConstraints.CENTER;
		add(new SettingsButton(), c);

		c.gridy = 2;
		c.weighty = 0.4;
		c.anchor = GridBagConstraints.NORTH;
		add(new Exit(), c);

	}

}
