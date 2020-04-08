package display;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mainmenu.MainMenu;

public class Frame {

	private static JFrame frame;
	private static JPanel currentPanel;

	public Frame() {

		frame = new JFrame();
		frame.setSize(new Dimension(500, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("E-learning setup");
		frame.setLayout(new BorderLayout());

		addPanel(new MainMenu());
		frame.add(new Signature(), BorderLayout.SOUTH);

		frame.revalidate();
		frame.repaint();

	}

	public static void addPanel(JPanel panel) {

		if (currentPanel != null) {
			frame.remove(currentPanel);
		}
		currentPanel = panel;
		frame.add(panel, BorderLayout.CENTER);

		frame.revalidate();
		frame.repaint();

	}

	public static void main(String args[]) {

		new Frame();

	}

}
