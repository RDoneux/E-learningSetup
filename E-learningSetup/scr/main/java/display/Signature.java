package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Signature extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -923502101547085649L;

	public Signature() {
		
		Font font = new Font("lucida Console", Font.PLAIN, 10);
		
		setBackground(Color.WHITE);
		setMaximumSize(new Dimension(Short.MAX_VALUE, 20));
		
		JLabel label = new JLabel("Created by Rob Doneux");
		label.setFont(font);
		label.setForeground(Color.LIGHT_GRAY);
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		add(label);
		
		
		
	}
	
}
