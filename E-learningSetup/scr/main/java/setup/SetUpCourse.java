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

		InstructorDisplay display = new InstructorDisplay();

		add(new CourseSelector(display), BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);
		add(new AddInstructor(display), BorderLayout.SOUTH);
		
	}

}
