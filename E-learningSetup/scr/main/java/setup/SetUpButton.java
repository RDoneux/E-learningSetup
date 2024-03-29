package setup;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import display.Frame;

public class SetUpButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888899860224984222L;

	public SetUpButton() {

		Font font = new Font("lucida Console", Font.PLAIN, 16);

		setText("Set up e-learning course");
		setFont(font);
		setMinimumSize(new Dimension(280, 40));
		setPreferredSize(new Dimension(280, 40));
		setMaximumSize(new Dimension(280, 40));
		setAlignmentX(JButton.CENTER_ALIGNMENT);

		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Frame.addPanel(new SetUpCourse());

	}

}
