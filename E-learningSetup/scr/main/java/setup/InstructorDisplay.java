package setup;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.Constants;

public class InstructorDisplay extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4824027576097436535L;
	private ArrayList<JLabel> items = new ArrayList<>();
	private ArrayList<Component> spaces = new ArrayList<>();
	private Font labelFont = new Font("lucida Console", Font.PLAIN, 16);
	private JLabel success = new JLabel("");

	public InstructorDisplay() {

		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, 1));

		add(Box.createRigidArea(new Dimension(Short.MAX_VALUE, 20)));

		success.setFont(labelFont);
		success.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		add(success);

	}

	public void addItem(String item) {

		if (!success.getText().equals("")) {
			success.setText("");
		}

		Component space = Box.createRigidArea(new Dimension(Short.MAX_VALUE, 8));

		JLabel addedItem = new JLabel(item);
		addedItem.addMouseListener(this);
		addedItem.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		addedItem.setFont(labelFont);
		items.add(addedItem);
		spaces.add(space);
		add(space);
		add(addedItem);

		revalidate();
		repaint();
	}

	public void createFolders(String date, String type) {

		String stringDate[] = date.split("-");

		String filePath =  Constants.masterFile + stringDate[2] + "\\" + stringDate[1] + " "
				+ stringDate[2];

		File generalFileLocation = new File(filePath + "\\" + date + " " + type);

		Thread thread = new Thread(new Runnable() {
			public void run() {

				// display the progress bar and creating folders label
				ProgressBar.update(0, items.size());

				if (!generalFileLocation.exists()) {
					generalFileLocation.mkdirs();
				}
				// export the two general resources to course folder
				exportResource("general/Attendance Sheet.docx", generalFileLocation, "Attendance Sheet");
				exportResource("general/Issues Arising Form.docx", generalFileLocation, "Issues Arising");

				// go through each name. Create folder for that candidate and generate
				// presentation feedback and random audit-based intervention assessment form.
				Random r = new Random();
				for (int i = 0; i < items.size(); i++) {
					JLabel label = items.get(i);

					// update the progress bar
					ProgressBar.update(i, items.size());

					File fileLocation = new File(filePath + "\\" + date + " " + type + "\\" + label.getText());
					if (!fileLocation.exists()) {
						fileLocation.mkdirs();
					}
					switch (type) {
					case "Re-certification":
						exportResource("presentation/Re-Certification - Presentation Feedback.docx", fileLocation,
								label.getText() + " ~ Presentation Feedback");
						exportResource("abass/" + Integer.valueOf(r.nextInt(11) + 1) + ".docx", fileLocation,
								label.getText() + " ~ Audit-based Assessment");
						break;
					case "Assessment Day":
						exportResource("presentation/Presentation Feedback.docx", fileLocation,
								label.getText() + " ~ Presentation Feedback");
						exportResource("abass/" + Integer.valueOf(r.nextInt(11) + 1) + ".docx", fileLocation,
								label.getText() + " ~ Audit-based Assessment");
						break;
					default:
						break;
					}
					label.setForeground(Color.GREEN);
					label.setText(label.getText() + " ~ Folder created");
				}

				// reset the display
				for (JLabel label : items) {
					remove(label);
				}
				for (Component comp : spaces) {
					remove(comp);
				}
				items.clear();
				spaces.clear();
				
				ProgressBar.update(items.size(), items.size());
				success.setText("Folders created successfully");

				revalidate();
				repaint();

			}
		});
		thread.start();

	}

	private void exportResource(String resLocation, File destination, String docName) {
		try {
			Files.copy(Paths.get(this.getClass().getClassLoader().getResource(resLocation).toURI()),
					Paths.get(destination.getAbsolutePath() + "//" + docName + ".docx"),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<JLabel> getItems() {
		return items;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < items.size(); i++) {
			if (e.getSource() == items.get(i)) {
				remove(items.get(i));
				remove(spaces.get(i));
				items.remove(i);
				spaces.remove(i);
				revalidate();
				repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < items.size(); i++) {
			if (e.getSource() == items.get(i)) {
				items.get(i).setText("Remove: " + items.get(i).getText());
				items.get(i).setForeground(Color.RED);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < items.size(); i++) {
			if (e.getSource() == items.get(i)) {
				items.get(i).setText(items.get(i).getText().substring(8, items.get(i).getText().length()));
				items.get(i).setForeground(Color.BLACK);
			}
		}
	}

}
