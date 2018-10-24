package Frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chess_Game.Chess_Board;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Startgame extends JFrame implements ActionListener
{
	String options[] = {"WHITE","BLACK"};
	JComboBox box1;
	JComboBox box2;	
	JButton btnst;
	String player1,player2;
	public JTextField textfield1;
	public JTextField textfield2;
	
	//JLabel lb1 =new JLabel(" player 1 ");
	//JLabel lb2 =new JLabel(" player 2 ");
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
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		box1 = new JComboBox(options);
		box1.setBorder(new LineBorder(Color.WHITE, 5, true));
		box1.setBounds(600, 579, 245, 59);
		box1.setFont(new java.awt.Font("Times New Roman", 1, 22));
		box1.setSelectedIndex(0);
		box1.addActionListener(this);
		panel.add(box1);

		box2 = new JComboBox(options);
		box2.setBorder(new LineBorder(Color.WHITE, 5, true));
		box2.setBounds(1130, 579, 245, 59);
		box2.setFont(new java.awt.Font("Times New Roman", 1, 22));
		box2.setSelectedIndex(1);
		box2.addActionListener(this);
		panel.add(box2);

				
		btnst = new JButton();
		btnst.setBorder(new LineBorder(Color.WHITE, 5, true));
		btnst.setBounds(850, 629, 245, 59);
		btnst.setIcon(resize(start));
		btnst.addActionListener(this);
		panel.add(btnst);
		
		textfield1 =new JTextField();
		textfield1.setBorder(new LineBorder(Color.WHITE, 5, true));
		textfield1.setBounds(850, 229, 245, 59);
		textfield1.setFont(new java.awt.Font("Times New Roman", 1, 22));
		textfield1.addActionListener(this);
		panel.add(textfield1);
		
		textfield2 =new JTextField();
		textfield2.setBorder(new LineBorder(Color.WHITE, 5, true));
		textfield2.setBounds(850, 380, 245, 59);
		textfield2.setFont(new java.awt.Font("Times New Roman", 1, 22));
		textfield2.addActionListener(this);
		panel.add(textfield2);
		
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
			if(box1.getItemAt(box1.getSelectedIndex()) == "WHITE")
				player1=textfield1.getText();
			else if(box1.getItemAt(box1.getSelectedIndex()) == "BLACK")
				player2=textfield1.getText();
			if(box2.getItemAt(box2.getSelectedIndex()) == "WHITE")
				player1=textfield2.getText();
			else if(box2.getItemAt(box2.getSelectedIndex()) == "BLACK")
				player2=textfield2.getText();
			this.dispose();
			new Chess_Board(player1,player2);
		}
		else if(e.getSource() == box1)
		{
			if(box1.getItemAt(box1.getSelectedIndex()) == "WHITE")
			{
				box2.setSelectedIndex(1);
				System.out.println("White");
			}
			else
			{
				box2.setSelectedIndex(0);
				System.out.println("Black");
			}
		}
		else if(e.getSource() == box2)
		{
			if(box2.getItemAt(box2.getSelectedIndex()) == "WHITE")
			{
				box1.setSelectedIndex(1);
				System.out.println("White");
			}
			else
			{
				box1.setSelectedIndex(0);
				System.out.println("Black");
			}
		}
		
	}
}