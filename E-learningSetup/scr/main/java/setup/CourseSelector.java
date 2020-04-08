package setup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CourseSelector extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6260052370274117328L;

	private JDatePickerImpl datePicker;
	private JComboBox<String> courseType;

	private JButton upload;

	private InstructorDisplay display;

	public CourseSelector(InstructorDisplay display) {

		this.display = display;

		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());

		// set date picker properties
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		datePicker.getJFormattedTextField().setText("Select Course Date");
		datePicker.getJFormattedTextField().setFont(new Font("lucida Console", Font.PLAIN, 14));
		datePicker.setPreferredSize(new Dimension(190, 25));

		upload = new JButton("Create Folders");
		upload.setFont(new Font("lucida Console", Font.PLAIN, 14));
		upload.setPreferredSize(new Dimension(150, 25));
		upload.addActionListener(this);

		String courseTypes[] = { "Assessment Day", "Re-certification" };

		courseType = new JComboBox<String>(courseTypes);
		courseType.setFont(new Font("lucida Console", Font.PLAIN, 14));
		courseType.setPreferredSize(new Dimension(160, 25));

		GridBagConstraints c = new GridBagConstraints();

		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.insets = new Insets(25, 0, 0, 0);
		add(datePicker, c);

		c.gridx = 1;
		add(courseType, c);

		c.gridx = 2;
		add(upload, c);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		display.createFolders(datePicker.getJFormattedTextField().getText(), courseType.getSelectedItem().toString());

	}

}
