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
import javax.swing.WindowConstants;

//import com.sun.prism.Image;



public class Openingwindow extends JPanel {
    
	JFrame window = new JFrame("Chess Game");
	Openingwindow()
	{
	//	window.setLocation(350, 150);
		window.add(this);
		window.setSize(1198,765);
		window.setVisible(true);
		 window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		     window.setSize(screenSize.width, screenSize.height);
		  window.setResizable(false);
		  
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
		
		File sound=new File("songs//X.wav");
		AudioInputStream sis=AudioSystem.getAudioInputStream(sound);
		Clip clip =AudioSystem.getClip();
		clip.open(sis);
		clip.start();
		clip.loop(20);
		
		Thread.sleep(8000);
		
	   
		// are na na sheta to kortei para jae menu te ota cholt ethakbe help khulle music stop ar nutun start
		window.dispose();
		
		Menu1 x=new Menu1();
		
		
		}catch(Exception e) {System.out.println(e);};
	}
	public void paint(Graphics g) {
	
		
	ImageIcon background = new ImageIcon("images//newscreen.jpg");
	g.drawImage(background.getImage(),0,0,null);
	
}
	
}	







