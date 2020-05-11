package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainmenu.MainMenu;
import settings.Constants;

public class Frame {

	private static JFrame frame;
	private static JPanel currentPanel;

	private static Dimension SCREEN_SIZE;

	public Frame() {


		
		SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

		frame = new JFrame();
		frame.setSize(new Dimension(550, SCREEN_SIZE.height - 100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("E-learning setup");
		frame.setLayout(new BorderLayout());

		try {
			frame.setIconImage(ImageIO.read(this.getClass().getResourceAsStream("/images/file.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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

	public static Dimension getWindowSize() {
		return new Dimension(frame.getWidth(), frame.getHeight());
	}

	public static void main(String args[]) {


		
		Constants.loadSettings();
		new Frame();

	}

}
