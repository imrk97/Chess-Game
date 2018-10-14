package Frontend;
import java.awt.Color;
import java.awt.Desktop;                                   
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chess_Game.Chess_Board;
import chess_Game.Pieces_btn;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Settings extends JFrame implements ActionListener
{

	Pieces_btn button[][] = new Pieces_btn[1][1];

	
	JButton btn1 = new JButton();

	public Settings()
	{
		super("Chess Game");

		ImageIcon start = new ImageIcon("images//volumekey.png");
		
		setContentPane(new JLabel(new ImageIcon("images//settingback.jpg")));
		setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		getContentPane().add(panel);
		
		
		btn1.setBorder(new LineBorder(Color.WHITE, 5, true));
		btn1.setBounds(850, 129, 245, 59);
		btn1.setIcon(resize(start));
		btn1.addActionListener(this);
		panel.add(btn1);
		
	
		
		setVisible(true);
	}
	ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(245, 59, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
	
	public  void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn1)
		{
			
		}
		
		
		
	}
}