/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
/*package chess_Game;                  // start

import javax.swing.JFrame;
import javax.swing.JPanel;



import Game_logical.BISHOP;
import Game_logical.Game_main_class;
import Game_logical.KNIGHT;
import Game_logical.PAWN;
import Game_logical.Piece;
import Game_logical.Player;
import Game_logical.ROOK;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chess_Board extends JFrame implements ActionListener
{
	JPanel p = new JPanel();
	Pieces_btn button[][] = new Pieces_btn[8][8];*/             // end
	/*public static void main(String args[])
	{
		new Chess_Board();
	}*/
/*	public Chess_Board()                            // start
	{
		super("Chess Game");
		pack();
		setSize(700,700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(8,8,2,2));
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				button[i][j]=new Pieces_btn(i,j);
				button[i][j].addActionListener(this);
				if((i+j) % 2 == 0)
					button[i][j].setBackground(new Color(255,229,181));
				else
					button[i][j].setBackground(new Color(176,100,43));
				p.add(button[i][j]);
			}
		}*/                                           // end
		/*getContentPane().*///add(p);                // start-end
		
/*		setVisible(true);                              // start
	}
	
	//Override
	public void actionPerformed(ActionEvent e)
	{
		int piece_in_button;
		Piece_Type arr[] = Piece_Type.values();
		String turn;
		Player pl_obj = new Player();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(e.getSource() == button[i][j])
				{
					System.out.println("i="+i+"j="+j);
					
					piece_in_button = Game_main_class.Board[i][j];
					turn = pl_obj.nowTurn();
					if(piece_in_button == 9)
					{
						// For testing purpose only
						
						
						PAWN pawn = new PAWN(i,j,piece_in_button,turn);
						pawn.drawPath();
						System.out.println("Pressed 1");
					}
					else if(piece_in_button == 2)
					{
						KNIGHT knight = new KNIGHT(i,j,piece_in_button,turn);
						knight.drawPath();
						System.out.println("Knight pressed");
					}
					else if(piece_in_button == 3)
					{
						BISHOP bishop = new BISHOP(i,j,piece_in_button,turn);
						bishop.drawPath();
						
						System.out.println("Bishop pressed");
					}
					else if(piece_in_button == 1)
					{
						ROOK rook = new ROOK(i,j,piece_in_button,turn);
						rook.drawPath();
						
						System.out.println("Rook pressed");
					}
				}
			}
		}
		//System.out.println("Button clicked "+e.getActionCommand());
	}
}
*/                                                                      //     end
package chess_Game;
//For testing

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Game_logical.BISHOP;
import Game_logical.Game_main_class;
import Game_logical.KNIGHT;
import Game_logical.PAWN;
import Game_logical.Player;
import Game_logical.QUEEN;
import Game_logical.ROOK;

//import chess_Game.Pieces_btn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Window.Type;

public class Chess_Board extends JFrame implements ActionListener
{
	//JButton btn[][] = new JButton[8][8];
	Pieces_btn button[][] = new Pieces_btn[8][8];
	/*public static void main(String args[])
	{
		new Chess_Board1();
	}*/
	public Chess_Board()
	{
		super("Chess Game");
		setContentPane(new JLabel(new ImageIcon("images//Background.jpg")));
		setResizable(false);
		//setSize(1017,538);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		///Dimension contentSize = this.getContentPane().getSize();
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//this.setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(null);
	//
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, (int) ((screenSize.height-40)*1.72/4), screenSize.height-35);
		panel.add(panel_1);
		
		JPanel p = new JPanel();
		//p.setBounds(310, 0, 740, 740);
		p.setBounds((int) ((screenSize.height-40)*1.72/4), 0, screenSize.height-35, screenSize.height-35);
		panel.add(p);
		p.setLayout(new GridLayout(8, 8, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds((int) ((screenSize.height-40)*1.72/4)+(screenSize.height-35), 0, (int) ((screenSize.height-40)*1.72/4), screenSize.height-35);
		panel.add(panel_2);
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				//btn[i][j]=new JButton();
				button[i][j]=new Pieces_btn(i,j);
				button[i][j].addActionListener(this);
				//btn[i][j].addActionListener(this);
				if((i+j) % 2 == 0)
					button[i][j].setBackground(new Color(255,229,181));//btn[i][j].setBackground(new Color(255,229,181));
				else
					button[i][j].setBackground(new Color(176,100,43));//btn[i][j].setBackground(new Color(176,100,43));
				p.add(button[i][j]);//p.add(btn[i][j]);
			}
		}
		
		getContentPane().add(panel);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		//System.out.println("Button pressed");
		
		int piece_in_button;
		Piece_Type arr[] = Piece_Type.values();
		String turn;
		Player pl_obj = new Player();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(e.getSource() == button[i][j])
				{
					System.out.println("i="+i+"j="+j);
					
					piece_in_button = Game_main_class.Board[i][j];
					turn = pl_obj.nowTurn();
					if(piece_in_button == 9)
					{
						// For testing purpose only
						
						
						PAWN pawn = new PAWN(i,j,piece_in_button,turn);
						pawn.drawPath();
						System.out.println("Pressed 1");
					}
					else if(piece_in_button == 2)
					{
						KNIGHT knight = new KNIGHT(i,j,piece_in_button,turn);
						knight.drawPath();
						System.out.println("Knight pressed");
					}
					else if(piece_in_button == 3)
					{
						BISHOP bishop = new BISHOP(i,j,piece_in_button,turn);
						bishop.drawPath();
						
						System.out.println("Bishop pressed");
					}
					else if(piece_in_button == 1)
					{
						ROOK rook = new ROOK(i,j,piece_in_button,turn);
						rook.drawPath();
						
						System.out.println("Rook pressed");
					}
					else if(piece_in_button == 5)
					{
						QUEEN queen = new QUEEN(i,j,piece_in_button,turn);
						queen.drawPath();
						
						System.out.println("Queen pressed");
					}
				}
			}
		}
	}
}




