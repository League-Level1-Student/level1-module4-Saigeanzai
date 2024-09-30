package _09_whack_a_mole;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Whak_a_mole implements ActionListener{

	Random rand;
	JFrame frame;
	JPanel mainPanel;
	JPanel panel;
	JLabel label;
	JButton button;

	public void setup() {

		frame = new JFrame();
		mainPanel = new JPanel();

		

		button = new JButton();
		panel = new JPanel();
		
		panel.setSize(300,300);
		frame.setSize(300,300);
		
		
		GridLayout layout = new GridLayout(8,3);
		panel.setLayout(layout);
		drawMethod(new Random());
		mainPanel.add(panel);
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void drawMethod(Random rand) {
		int number = rand.nextInt(25);
		for(int i=0;i<24;i++) {
			JButton temp = new JButton();
			temp.addActionListener(this);
			if(i==number){
				temp.setText("mole!");
				}
			else {
				temp.setText("");
			}
			panel.add(temp);
			}
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed.equals("mole!")) {
			drawMethod(new Random());
		}
		
	}

}
