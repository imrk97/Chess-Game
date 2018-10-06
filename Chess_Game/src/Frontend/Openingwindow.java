package Frontend;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.Image;

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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    window.setSize(screenSize.width, screenSize.height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new JLabel(new ImageIcon("images//mainscreen1.jpg")));
		//Image scaledImage = originalImage.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		//window.setContentPane(new JLabel(new ImageIcon("images//mainscreen.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		//window.setLocation(75,5);
		window.add(this);
	//	window.setSize(1198,735);
		window.setVisible(true);
		
	}
	/*public void paint(Graphics g)
	{
		Image background =new ImageIcon("images//mainscreen.jpg");
		//g.drawImage(background.getImage(),0,0,null);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}*/

}
