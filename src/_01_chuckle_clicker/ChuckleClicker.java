package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;

	
	public void makeButtons() {
		// JOptionPane.showMessageDialog(null, "Make Buttons");

		frame = new JFrame();
		panel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		button1.setText("joke");
		button2.setText("punchline");
		panel.add(button1);
		panel.add(button2);

		frame.pack();

		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	// (ActionEvent e)
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		JButton buttonPressed = (JButton) arg0.getSource();

		if (buttonPressed.equals(button1)) {
			JOptionPane.showMessageDialog(null, "hi");
		    JOptionPane.showMessageDialog(null, " Q. What kind of dance was the frog prince best at? A. Hip hop");
			
		}
		if (buttonPressed.equals(button2)) {
			JOptionPane.showMessageDialog(null, "hi");
			JOptionPane.showMessageDialog(null, "I wanted to be a doctor, but I didn’t have the patients.");
		}
	}

}
