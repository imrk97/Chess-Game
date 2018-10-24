package Frontend;
import java.awt.Color;
import java.awt.Desktop;                                   
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
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
import javax.swing.JTextField;

import chess_Game.Chess_Board;
import chess_Game.Pieces_btn;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Startgame extends JFrame implements ActionListener



{
	String options[] = {"WHITE","BLACK"};

	//JButton btn[][] = new JButton[8][8];
	Pieces_btn button[][] = new Pieces_btn[2][2];
	/*public static void main(String args[])
	{
		new Chess_Board1();
	}*/
	
	JButton btnst;
	//JButton btnst1 = new JButton();
	public JTextField textfield =new JTextField();
	public JTextField textfield1 =new JTextField();
	JComboBox box = new JComboBox(options);
	JComboBox box1 = new JComboBox(options);
	JLabel lb1 =new JLabel(" player 1 ");
	JLabel lb2 =new JLabel(" player 2 ");
	public Startgame()
	{
		super("Start Window");
//		initComponents();
		ImageIcon start = new ImageIcon("images//buttonplay.jpg");
//		ImageIcon end = new ImageIcon("images//ChooseAlliance.jpg");
		
		setContentPane(new JLabel(new ImageIcon("images//backgroundstart.jpg")));
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
		
		

		
/*		btnst1.setBorder(new LineBorder(Color.WHITE, 5, true));
		btnst1.setBounds(850, 429, 245, 59);
		btnst1.setIcon(resize(end));
		btnst1.addActionListener(this);
		panel.add(btnst1);
*/		btnst = new JButton();
		btnst.setBorder(new LineBorder(Color.WHITE, 5, true));
		btnst.setBounds(850, 729, 245, 59);
		btnst.setIcon(resize(start));
		btnst.addActionListener(this);
		panel.add(btnst);
		
//		lb1.setBorder(new LineBorder(Color.WHITE, 5, true));
		lb1.setBounds(500, 579, 245, 59);
		lb1.setFont(new java.awt.Font("Times New Roman", 1, 24));

		lb1.setForeground(Color.WHITE);
		//box.setIcon(resize(start));
	//	lb1.addActionListener(this);
		panel.add(lb1);
		
	//	lb2.setBorder(new LineBorder(Color.WHITE, 5, true));
		lb2.setBounds(1030, 579, 245, 59);
		lb2.setFont(new java.awt.Font("Times New Roman", 1, 24));

		lb2.setForeground(Color.WHITE);
		//box.setIcon(resize(start));
	//	lb1.addActionListener(this);
		panel.add(lb2);
		
		
		box.setBorder(new LineBorder(Color.WHITE, 5, true));
		box.setBounds(600, 579, 245, 59);
		//box.setIcon(resize(start));
		box.setFont(new java.awt.Font("Times New Roman", 1, 22));
		box.addActionListener(this);
		//box.addItem("white");
		//box.addItem("black");
	
		
		
		panel.add(box);
		
		
		box1.setBorder(new LineBorder(Color.WHITE, 5, true));
		box1.setBounds(1130, 579, 245, 59);
		//box.setIcon(resize(start));
		box1.setFont(new java.awt.Font("Times New Roman", 1, 22));
		box1.addActionListener(this);
		//box1.addItem("--");
		//box1.addItem("white");
		//box1.addItem("black");
		
		panel.add(box1);
		
		if(box.getItemAt(box.getSelectedIndex()) == "white")
		{
			System.out.println("item selected white");
		}
		else
			System.out.println("item selected black");

	

		textfield.setBorder(new LineBorder(Color.WHITE, 5, true));
		textfield.setBounds(850, 229, 245, 59);
		textfield.setFont(new java.awt.Font("Times New Roman", 1, 22));
		//	textfield.setIcon(resize(start));
		textfield.addActionListener(this);
	//	textfield.getText();
		
		panel.add(textfield);
		
		
		textfield1.setBorder(new LineBorder(Color.WHITE, 5, true));
		textfield1.setBounds(850, 380, 245, 59);
		textfield1.setFont(new java.awt.Font("Times New Roman", 1, 22));
		//	textfield.setIcon(resize(start));
		textfield1.addActionListener(this);
//		textfield1.getText();
		panel.add(textfield1);
		
		
	
		
		
		
		
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
		if(e.getSource() == btnst)
		{
		
			Chess_Board ox=new Chess_Board();
			String player1=textfield.getText();
			String player2=textfield1.getText();
		}

		
		
	}
}