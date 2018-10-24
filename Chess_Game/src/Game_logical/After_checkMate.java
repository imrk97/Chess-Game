package Game_logical;


import javax.swing.JFrame;
import javax.swing.JPanel;
import Frontend.Menu1;
import chess_Game.Chess_Board;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class After_checkMate extends JFrame implements ActionListener
{
	JButton btn1;
	JButton btn2;
	String winner,looser;
	public After_checkMate(String winner,String looser)
	{
		super("Check Mate");
		
//		winner = win;
//		looser = lose;
		
		setSize(450,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
//		JPanel panel = new JPanel();
//		getContentPane().add(panel);
		//setUndecorated(true);
		//getContentPane().setBackground(Color.BLACK);
		//setType(Type.UTILITY);
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(250,249,231));
		getContentPane().add(p);
		
		JLabel label = new JLabel("Congratulations !!!");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(132, 34, 180, 27);
		p.add(label);
		
		JLabel lbl1 = new JLabel("Winner :");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl1.setBounds(96, 104, 67, 19);
		p.add(lbl1);
		
		JLabel lbl2 = new JLabel("                                        ");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl2.setBounds(184, 104, 220, 18);
		lbl2.setText(winner);      //String player1
		p.add(lbl2);
		
		JLabel lbl3 = new JLabel("Well tried :");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl3.setBounds(96, 165, 77, 19);
		p.add(lbl3);
		
		JLabel lbl4 = new JLabel("                                          ");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl4.setBounds(184, 165, 220, 18);
		lbl4.setText(looser);      //String player2
		System.out.println("Looser = "+looser);
		p.add(lbl4);
		
		btn1 = new JButton("Play Again");
		btn1.addActionListener(this);
		btn1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btn1.setBounds(79, 221, 113, 23);
		p.add(btn1);
		
		btn2 = new JButton("Main Menu");
		btn2.addActionListener(this);
		btn2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btn2.setBounds(280, 221, 124, 23);
		p.add(btn2);
		
		
		
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn1)             // Play again
		{
			new Chess_Board("abc","abc");  //Loading the Chess Board (The GUI) and Placing the pieces(GUI)
			this.dispose();
		}
		else if(e.getSource() == btn2)        // Quit button
		{
			this.dispose();
			//new Menu1();
		}
	}
	/*public static void main(String args[])
	{
		After_checkMate n = new After_checkMate();
	}*/
}