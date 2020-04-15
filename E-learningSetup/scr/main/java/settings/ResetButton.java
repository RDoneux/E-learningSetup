package settings;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ResetButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 689967023540830798L;

	private String font = "lucida Console";
	private String masterFile = "L:\\COURSE STORE\\Totara Courses";
	private SettingsMenu menu;

	public ResetButton(SettingsMenu menu) {

		this.menu = menu;
		Font font = new Font("lucida Console", Font.PLAIN, 16);

		setText("Reset Values");
		setFont(font);
		setMinimumSize(new Dimension(160, 30));
		setPreferredSize(new Dimension(160, 30));
		setMaximumSize(new Dimension(160, 30));
		setAlignmentX(JButton.CENTER_ALIGNMENT);

		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Constants.font = font;
		Constants.masterFile = masterFile;

		menu.fileLocation.setText(masterFile);
		menu.fontType.setText(font);
		
		Constants.saveSettings();

	}

}
