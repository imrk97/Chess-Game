package Frontend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chess_Game.Pieces_btn;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Menu1 extends JFrame implements ActionListener
{
	//JButton btn[][] = new JButton[8][8];
	Pieces_btn button[][] = new Pieces_btn[8][8];
	/*public static void main(String args[])
	{
		new Chess_Board1();
	}*/
	
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	JButton btn3 = new JButton();
	JButton btn4 = new JButton();
	JButton btn5 = new JButton();
	
	public Menu1()
	{
		
		super("Chess Game");
		ImageIcon start = new ImageIcon("images//start.jpg");
		ImageIcon score = new ImageIcon("images//score.jpg");
		ImageIcon setting = new ImageIcon("images//settings.jpg");
		ImageIcon help = new ImageIcon("images//help.jpg");
		ImageIcon quit = new ImageIcon("images//quit.jpg");
		setContentPane(new JLabel(new ImageIcon("images//back.png")));
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
		btn1.setBounds(558, 129, 245, 59);
		btn1.setIcon(resize(start));
		panel.add(btn1);
		
		btn2.setBorder(new LineBorder(Color.WHITE, 5, true));
		btn2.setBounds(558, 234, 245, 59);
		btn2.setIcon(resize(score));
		panel.add(btn2);
		
		btn3.setBorder(new LineBorder(Color.WHITE, 5, true));
		btn3.setBounds(558, 339, 245, 59);
		btn3.setIcon(resize(setting));
		panel.add(btn3);
		
		btn4.setBorder(new LineBorder(Color.WHITE, 5, true));
		btn4.setBounds(558, 444, 245, 59);
		btn4.setIcon(resize(help));
		panel.add(btn4);
		
		btn5.setBorder(new LineBorder(Color.WHITE, 5, true));
		btn5.setBounds(558, 549, 245, 59);
		btn5.setIcon(resize(quit));
		panel.add(btn5);
		
		setVisible(true);
	}
	ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(245, 59, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn1)
		{
			
		}
		else if(e.getSource() == btn2)
		{
			
		}
		else if(e.getSource() == btn3)
		{
			
		}
		
	}
}