package mainmenu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import display.Frame;

public class MainMenuButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1434272086038676218L;

	public MainMenuButton() {

		Font font = new Font("lucida Console", Font.PLAIN, 20);

		setText("Main Menu");
		setPreferredSize(new Dimension(280,50));
		setFont(font);

		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Frame.addPanel(new MainMenu());
		
	}

}
