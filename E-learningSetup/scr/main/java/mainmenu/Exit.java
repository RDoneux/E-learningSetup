package mainmenu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Exit extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4530679477103609334L;
	public Exit() {

		Font font = new Font("lucida Console", Font.PLAIN, 16);

		setText("Exit");
		setFont(font);
		setMinimumSize(new Dimension(280, 40));
		setPreferredSize(new Dimension(280, 40));
		setMaximumSize(new Dimension(280, 40));
		setAlignmentX(JButton.CENTER_ALIGNMENT);

		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
