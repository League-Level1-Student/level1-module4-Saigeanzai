package _03_typing_tutor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor {

	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	char currentLetter;

	void setup(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentLetter = TypingTutorRunner.generateRandomLetter();
		
		JLabel label = new JLabel();
	//	label.setText(currentLetter);
	}
	
	
	
	
	
	
	
	
}
