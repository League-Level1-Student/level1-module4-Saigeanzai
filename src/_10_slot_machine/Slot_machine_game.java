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
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	
	
	
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
		secondPanel.add(buttonPanel);
		secondPanel.add(imagePanel);
		buttonPanel.add(button);
		
		imagePanel.add(label1);
		imagePanel.add(label2);
		imagePanel.add(label3);
		
		button.addActionListener(this);
		
		
		
		
		frame.pack();
	}

	
	
	public JLabel createLabel(){
		JLabel temp = new JLabel();
		int number = rand.nextInt(3);

if (number==1) {
	try {
		temp = createLabelImage("cherries.jpg");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
else if (number==2)	{
	try {
		temp = createLabelImage("lemons.jpg");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
else if (number==3) {		
		try {
			temp = createLabelImage("oranges.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
		return temp;
	}
    


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		JButton buttonPressed = (JButton) e.getSource();
		
		
		if(buttonPressed.equals(button)) {
			label1 = createLabel();
			label2 = createLabel();
			label3 = createLabel();
		}
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
}
