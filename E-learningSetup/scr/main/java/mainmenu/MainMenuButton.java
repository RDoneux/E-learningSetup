package mainmenu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import display.Frame;

public class MainMenuButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1434272086038676218L;

	public MainMenuButton() {

		Font font = new Font("lucida Console", Font.PLAIN, 20);

		try {
			BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream("/images/Home Icon.png"));
			setIcon(new ImageIcon(image.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setMaximumSize(new Dimension(35, 35));
		setPreferredSize(new Dimension(35, 35));
		setFont(font);

		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Frame.addPanel(new MainMenu());

	}

}
