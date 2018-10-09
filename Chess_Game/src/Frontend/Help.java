package Frontend;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Help extends JPanel {
	//
	JFrame window = new JFrame("Chess Game");
	Help(){
		
		window.add(this);
	
		window.setSize(1198,765);
		window.setVisible(true);
		 window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		     window.setSize(screenSize.width, screenSize.height);
		  window.setResizable(false);
		  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  try {
				File sound=new File("songs//helpmusic.wav");
			AudioInputStream sis=AudioSystem.getAudioInputStream(sound);
			Clip clip =AudioSystem.getClip();
			
			clip.open(sis);
			clip.start();
			
			}catch(Exception e) {System.out.println(e);}
	}
	
}
