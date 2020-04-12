package setup;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import display.Frame;

public class ProgressBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4945738588195840654L;

	private static JProgressBar progBar;

	public ProgressBar() {
		setBackground(Color.WHITE);
		progBar = new JProgressBar();
		progBar.setVisible(false);
		progBar.setPreferredSize(new Dimension((int) Frame.getWindowSize().getWidth() / 2, 20));
		progBar.setStringPainted(true);
		add(progBar);
	}

	public static void update(int current, int max) {
		if (!progBar.isVisible()) {
			progBar.setVisible(true);
		}
		progBar.setString("Creating Folders");
		progBar.setValue(current);
		progBar.setMaximum(max);
		if (current == max) {
			progBar.setVisible(false);
		}
	}

}
