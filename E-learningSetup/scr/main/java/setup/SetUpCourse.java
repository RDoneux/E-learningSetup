package setup;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class SetUpCourse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1083605244886018202L;

	public SetUpCourse() {
		setBackground(Color.GREEN);

		setLayout(new BorderLayout());

		add(new InstructorDisplay(), BorderLayout.CENTER);
	}

}
