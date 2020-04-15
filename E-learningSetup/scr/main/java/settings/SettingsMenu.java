package settings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mainmenu.MainMenuButton;

public class SettingsMenu extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5819909456610238046L;

	public JTextArea fontType;
	public JTextArea fileLocation;

	public SettingsMenu() {

		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);

		fontType = new JTextArea(Constants.font);
		fontType.setBorder(null);
		fontType.setBackground(Color.WHITE);
		fontType.addMouseListener(this);
		fontType.setPreferredSize(new Dimension(200, 30));

		fileLocation = new JTextArea(Constants.masterFile);
		fileLocation.setBorder(null);
		fileLocation.setBackground(Color.WHITE);
		fileLocation.addMouseListener(this);
		fileLocation.setPreferredSize(new Dimension(200, 30));

		GridBagConstraints c = new GridBagConstraints();

		c.weightx = 1;
		c.weighty = 0.2;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.EAST;
		add(new JLabel("Font: "), c);

		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		add(fontType, c);

		c.gridy = 1;
		c.gridx = 0;
		c.weighty = 0.8;
		c.anchor = GridBagConstraints.NORTHEAST;
		add(new JLabel("Master File Location: "), c);

		c.gridx = 1;
		c.anchor = GridBagConstraints.NORTHWEST;
		add(fileLocation, c);

		c.anchor = GridBagConstraints.SOUTHEAST;
		add(new MainMenuButton(), c);

		c.gridx = 0;
		c.anchor = GridBagConstraints.SOUTHWEST;
		add(new SaveButton(this), c);

		c.anchor = GridBagConstraints.SOUTH;
		c.gridwidth = 2;
		c.insets = new Insets(10, 70, 10, 10);
		add(new ResetButton(this), c);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

		if (arg0.getSource() == fontType) {
			fontType.setForeground(Color.BLUE);
		}

		if (arg0.getSource() == fileLocation) {
			fileLocation.setForeground(Color.BLUE);
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == fontType) {
			fontType.setForeground(Color.BLACK);
		}

		if (arg0.getSource() == fileLocation) {
			fileLocation.setForeground(Color.BLACK);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		if (arg0.getSource() == fontType) {
			fontType.setSelectionStart(0);
			fontType.setSelectionEnd(fontType.getText().length());
			fontType.setForeground(Color.BLACK);
		}

		if (arg0.getSource() == fileLocation) {
			fileLocation.setSelectionStart(0);
			fileLocation.setSelectionEnd(fileLocation.getText().length());
			fileLocation.setForeground(Color.BLACK);
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
