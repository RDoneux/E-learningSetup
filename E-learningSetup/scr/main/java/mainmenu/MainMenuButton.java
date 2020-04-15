package mainmenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import display.Frame;

public class MainMenuButton extends JButton implements ActionListener, MouseListener {

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
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		addActionListener(this);
		addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Frame.addPanel(new MainMenu());

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

		setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

		setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
