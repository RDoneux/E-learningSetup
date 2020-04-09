package setup;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
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

		// title panel holds course selector and progress bar
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, 1));
		
		titlePanel.add(new CourseSelector(display), BorderLayout.CENTER);
		titlePanel.add(new ProgressBar());

		add(titlePanel, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);
		add(new AddInstructor(display), BorderLayout.SOUTH);
		
	}

}
