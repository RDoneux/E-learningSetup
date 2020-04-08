package mainmenu;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import setup.SetUpButton;

public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2706103664824212654L;

	public MainMenu() {

		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, 1));
		
		add(new SetUpButton());

	}

}
