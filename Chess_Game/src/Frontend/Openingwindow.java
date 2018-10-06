package ChessyPack;

import java.awt.Graphics;
import java.io.EOFException;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Openingwindow extends JPanel {
    
	JFrame window = new JFrame();
	Openingwindow()
	{
		try {
			File sound=new File("songs//X.wav");
		AudioInputStream sis=AudioSystem.getAudioInputStream(sound);
		Clip clip =AudioSystem.getClip();
		clip.open(sis);
		clip.start();
		
		}catch(Exception e) {System.out.println(e);}
		window.setLocation(75,5);
		window.add(this);
		window.setSize(1198,735);
		window.setVisible(true);
	
	}
	public void paint(Graphics g)
	{
		ImageIcon background =new ImageIcon("images//mainscreen.jpg");
		g.drawImage(background.getImage(),0,0,null);
	}

}
