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
		c.weighty = 1;
		add(new SetUpButton(), c);

		c.gridy = 1;
		add(new SettingsButton(), c);

		c.gridy = 2;
		add(new Exit(), c);


	}

}
