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

import org.apache.commons.io.FileUtils;

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

		String filePath = "L:\\COURSE STORE\\Totara Courses" + " " + stringDate[2] + "\\" + stringDate[1] + " "
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
				// exportResource("general/Attendance Sheet.docx", generalFileLocation, "Attendance Sheet"); no longer required after move to face to face training
				exportResource("general/Issues Arising Form.docx", generalFileLocation, "Issues Arising");

				createPresentationFolder(generalFileLocation.getAbsolutePath());

				// go through each name. Create folder for that candidate and generate
				// presentation feedback and random audit-based intervention assessment form.
				for (int i = 0; i < items.size(); i++) {
					JLabel label = items.get(i);

					// update the progress bar
					ProgressBar.update(i, items.size());

					File fileLocation = new File(filePath + "\\" + date + " " + type + "\\" + label.getText());
					if (!fileLocation.exists()) {
						fileLocation.mkdirs();
					}

					switch (type) {
					// this has been left in incase there is a change to the requirements of each course moving forwards
					case "Re-certification":
						exportResource("record/General - Record Sheet V1.docx", fileLocation,
								label.getText() + " ~ Record Sheet");
						break;
					case "Assessment Day":
						exportResource("record/General - Record Sheet V1.docx", fileLocation,
								label.getText() + " ~ Record Sheet");
						break;
					case "Instructor":
						exportResource("record/General - Record Sheet V1.docx", fileLocation,
								label.getText() + " ~ Record Sheet");
						break;
					case "Principal Instructor":
						exportResource("record/General - Record Sheet V1.docx", fileLocation,
								label.getText() + " ~ Record Sheet");
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

			private void createPresentationFolder(String generalFileLocation) {

				File absoluteFileLocation = new File(generalFileLocation + "/presentations");
				if(!absoluteFileLocation.exists()){
					absoluteFileLocation.mkdir();
				}
		
			}
			
		});
		thread.start();

	}

	private String getAuditName(int i) {
		switch (i) {
		case 1:
			return "S";
		case 2:
			return "PPS1";
		case 3:
			return "TS";
		case 4:
			return "FD";
		case 5:
			return "FAP";
		case 6:
			return "FCR";
		case 7:
			return "OPE";
		default:
			return null;
		}
	}

	private void exportResource(String resLocation, File destination, String docName) {

		try {
			FileUtils.copyURLToFile(this.getClass().getClassLoader().getResource(resLocation),
					new File(destination.getAbsolutePath() + "//" + docName + ".docx"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//
//
//
//			Files.copy(Paths.get(this.getClass().getClassLoader().getResource(resLocation).toURI()),
//					Paths.get(destination.getAbsolutePath() + "//" + docName + ".docx"),
//					StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException | URISyntaxException ex) {
//			ex.printStackTrace();
//		}
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
