package _06_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel secondPanel = new JPanel();
	JPanel thirdPanel = new JPanel();
	JPanel fourthPanel = new JPanel();
	JLabel label = new JLabel();
	JTextField firstText = new JTextField();
	JTextField secondText = new JTextField();
	JButton firstButton = new JButton("add");
	JButton secondButton = new JButton("sub");
	JButton thirdButton = new JButton("mul");
	JButton fourthButton = new JButton("div");

	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setTitle("Simple Calculator");

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		frame.add(panel);
		panel.add(secondPanel);
		panel.add(thirdPanel);
		panel.add(fourthPanel);

		firstText.setPreferredSize(new Dimension(140, 30));
		secondText.setPreferredSize(new Dimension(140, 30));
		secondPanel.add(firstText);
		secondPanel.add(secondText);

		thirdPanel.add(firstButton);
		thirdPanel.add(secondButton);
		thirdPanel.add(thirdButton);
		thirdPanel.add(fourthButton);
		
		firstButton.addActionListener(this);
		secondButton.addActionListener(this);
		thirdButton.addActionListener(this);
		fourthButton.addActionListener(this);

		fourthPanel.add(label);

		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed.equals(firstButton)) {
			label.setText(Integer.toString(add()));
		}
		if(buttonPressed.equals(secondButton)) {
			label.setText(Integer.toString(sub()));
		}
		if(buttonPressed.equals(thirdButton)) {
			label.setText(Integer.toString(mul()));
		}
		if(buttonPressed.equals(fourthButton)) {
			label.setText(Integer.toString(div()));
		}
		
	}
	public int add() {
		int firstAnswer = Integer.valueOf(firstText.getText());
		int secondAnswer = Integer.valueOf(secondText.getText());
		return firstAnswer + secondAnswer;
	}
	
	public int sub() {
		int firstAnswer = Integer.valueOf(firstText.getText());
		int secondAnswer = Integer.valueOf(secondText.getText());
		return firstAnswer - secondAnswer;
	}
	
	public int mul() {
		int firstAnswer = Integer.valueOf(firstText.getText());
		int secondAnswer = Integer.valueOf(secondText.getText());
		return firstAnswer*secondAnswer;
	}
	
	public int div() {
		int firstAnswer = Integer.valueOf(firstText.getText());
		int secondAnswer = Integer.valueOf(secondText.getText());
		return firstAnswer/secondAnswer;
	}
	
	
	
	
	
	
	
	
	
	
	
}
