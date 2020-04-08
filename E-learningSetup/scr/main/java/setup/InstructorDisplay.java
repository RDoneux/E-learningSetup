package setup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructorDisplay extends JPanel implements MouseListener {

	private ArrayList<JLabel> items = new ArrayList<>();
	private Font labelFont = new Font("lucida Console", Font.PLAIN, 16);

	public InstructorDisplay() {

		setBackground(Color.BLUE);
		setLayout(new BoxLayout(this, 1));

		add(Box.createRigidArea(new Dimension(Short.MAX_VALUE, 20)));

	}

	public void addItem(String item) {
		JLabel addedItem = new JLabel(item);
		addedItem.addMouseListener(this);
		addedItem.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		addedItem.setFont(labelFont);
		items.add(addedItem);
		add(addedItem);

		revalidate();
		repaint();
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
