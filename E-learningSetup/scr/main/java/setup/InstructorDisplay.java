package setup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructorDisplay extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4824027576097436535L;
	private ArrayList<JLabel> items = new ArrayList<>();
	private Font labelFont = new Font("lucida Console", Font.PLAIN, 16);

	public InstructorDisplay() {

		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, 1));

		add(Box.createRigidArea(new Dimension(Short.MAX_VALUE, 20)));

	}

	public void addItem(String item) {

		add(Box.createRigidArea(new Dimension(Short.MAX_VALUE, 8)));

		JLabel addedItem = new JLabel(item);
		addedItem.addMouseListener(this);
		addedItem.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		addedItem.setFont(labelFont);
		items.add(addedItem);
		add(addedItem);

		revalidate();
		repaint();
	}

	public void createFolders(String date, String type) {

		String stringDate[] = date.split("-");

		String filePath = "L:\\COURSE STORE\\Totara Courses " + stringDate[2] + "\\" + stringDate[1] + " "
				+ stringDate[2];

		for (JLabel label : items) {
			File fileLocation = new File(filePath + "\\" + date + " " + type + "\\" + label.getText());
			if (!fileLocation.exists()) {
				fileLocation.mkdirs();

				switch (type) {
				case "Re-certification":
					exportResource("presentation/Re-Certification - Presentation Feedback.docx", fileLocation,
							label.getText() + " ~ Presentation Feedback.docx");
					break;
				case "Assessment Day":
					break;
				default:
					break;
				}

			}
			System.out.println(fileLocation.getPath());
		}

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
		// TODO Auto-generated method stub

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
				System.out.println(items.get(i).getText());
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
