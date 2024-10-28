package _10_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Slot_machine_game implements ActionListener {

	JFrame frame;
	JPanel mainPanel;
	JPanel secondPanel;
	JPanel imagePanel;
	JPanel buttonPanel;
	JButton button;
	Random rand;
	JLabel label1 = createLabelImage("cherries.jpg");
	JLabel label2 = createLabelImage("oranges.jpg");
	JLabel label3 = createLabelImage("lemons.jpg");

	public void setup() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		button = new JButton();
		secondPanel = new JPanel();
		buttonPanel = new JPanel();
		imagePanel = new JPanel();

		frame.add(mainPanel);
		mainPanel.add(secondPanel);
		secondPanel.add(imagePanel);
		secondPanel.add(buttonPanel);
		imagePanel.add(label1);
		imagePanel.add(label2);
		imagePanel.add(label3);
		buttonPanel.add(button);

		button.addActionListener(this);

		frame.pack();
	}

	public JLabel createLabel(int number) {
		JLabel temp = new JLabel();
		//rand = new Random();
		//int number = rand.nextInt(3);

		if (number == 0) {
			
				temp = createLabelImage("cherries.jpg");
			
		} else if (number == 1) {
			
				temp = createLabelImage("lemons.jpg");
		
		} else if (number == 2) {
			
				temp = createLabelImage("oranges.jpg");
			
		}
		return temp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		JButton buttonPressed = (JButton) e.getSource();
		int number = ran.nextInt(3);
		int number2 = ran.nextInt(3);
		int number3 = ran.nextInt(3);
System.out.println("Spinning the wheels");
		if (buttonPressed.equals(button)) {
			imagePanel.removeAll();
			imagePanel.updateUI();
			rand = new Random();
			JLabel label1 = createLabel(number);
			JLabel label2 = createLabel(number2);
			JLabel label3 = createLabel(number3);
			imagePanel.add(label1);
			imagePanel.add(label2);
			imagePanel.add(label3);
		}
		
		if (number==number2&&number2==number3) {
			System.out.println("YOU WIN!");
		}
	}

	private JLabel createLabelImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		ImageIcon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
	
		return imageLabel;
	}
}
