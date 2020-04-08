package setup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddInstructor extends JPanel implements KeyListener, MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 103180059958400461L;

	private JTextField userInput;
	private Font inputFont = new Font("lucida Console", Font.PLAIN, 20);
	private InstructorDisplay display;
	private JButton button;

	public AddInstructor(InstructorDisplay display) {

		this.display = display;

		setLayout(new GridBagLayout());

		setPreferredSize(new Dimension(Short.MAX_VALUE, 50));
		setBackground(Color.WHITE);

		userInput = new JTextField("Instructor Name");
		userInput.setForeground(Color.LIGHT_GRAY);
		userInput.setFont(inputFont);
		userInput.setPreferredSize(new Dimension(280, 30));
		userInput.addMouseListener(this);
		userInput.addKeyListener(this);

		button = new JButton("Add Name");
		button.setFont(new Font("lucida Console", Font.PLAIN, 18));
		button.setPreferredSize(new Dimension(125, 30));
		button.addActionListener(this);

		GridBagConstraints c = new GridBagConstraints();

		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 5, 10, 5);
		add(userInput, c);

		c.gridx = 2;
		c.anchor = GridBagConstraints.WEST;
		add(button, c);

	}

	private void addItemToDisplay() {
		display.addItem(userInput.getText());
		userInput.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			addItemToDisplay();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		if (userInput.getText().equals("") || userInput.getText().equals("Instructor Name")) {
			userInput.setText("");
			userInput.setForeground(Color.BLACK);
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		addItemToDisplay();

	}

}
