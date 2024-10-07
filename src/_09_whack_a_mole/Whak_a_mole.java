package _09_whack_a_mole;

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
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
	int score=0;
	int missScore=0;
	Date mydate;

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
		int number = rand.nextInt(24);
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
		Random ran = new Random();
		mydate = new Date();
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed.getText().equals("mole!")) {
			panel.removeAll();
			panel.updateUI();
			drawMethod(ran);
			score +=1;
			System.out.println(score);
			playSound("music.wav");
		}
		if(buttonPressed.getText().equals("")) {
			speak("miss!");
			panel.removeAll();
			panel.updateUI();
			drawMethod(ran);
			missScore +=1;
			System.out.println("You missed!");
		}
		if(score==10) {
			endGame(mydate, score);
		}
		if(missScore==5) {
			System.out.println("Game Over!");
			endGame(mydate,score);
		}
	}
	
	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
	
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
	
	private void playSound(String fileName) { 
	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	    sound.play();
	}
}
