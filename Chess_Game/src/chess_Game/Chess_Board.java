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
import Game_logical.KING;
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
	
	public static Pieces_btn button[][] = new Pieces_btn[8][8];
	JPanel panel;
	JPanel panel_1;
	JPanel panel_2;
	JPanel p;
	int click = 1;
	int r,c;
	boolean pathDrawn[][] = new boolean[8][8];
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
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(null);
	//
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, (int) ((screenSize.height-40)*1.72/4), screenSize.height-35);
		panel.add(panel_1);
		
		p = new JPanel();
		//p.setBounds(310, 0, 740, 740);
		p.setBounds((int) ((screenSize.height-40)*1.72/4), 0, screenSize.height-35, screenSize.height-35);
		panel.add(p);
		p.setLayout(new GridLayout(8, 8, 0, 0));
		
		panel_2 = new JPanel();
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
					if(click == 1)
					{
						System.out.println("i="+i+"j="+j);
						
						piece_in_button = Game_main_class.Board[i][j];
						turn = pl_obj.nowTurn();
						if((piece_in_button >= 9 && piece_in_button <= 16) || (piece_in_button >= 25 && piece_in_button <= 32)) // Pawn
						{
							PAWN pawn = new PAWN(i,j,piece_in_button,turn);
							pawn.drawPath(pathDrawn);
							r=i;
							c=j;
							System.out.println("Pressed 1");
						}
						else if(piece_in_button == 1 || piece_in_button == 8 || piece_in_button == 17 || piece_in_button == 24)  // Rook
						{
							ROOK rook = new ROOK(i,j,piece_in_button,turn);
							rook.drawPath(pathDrawn);
							r=i;
							c=j;
							//rook.actionPerformed(e);
							System.out.println("Rook pressed");
						}
						else if(piece_in_button == 2 || piece_in_button == 7 || piece_in_button == 18 || piece_in_button == 23)  // Knight
						{
							KNIGHT knight = new KNIGHT(i,j,piece_in_button,turn);
							knight.drawPath(pathDrawn);
							r=i;
							c=j;
							System.out.println("Knight pressed");
						}
						else if(piece_in_button == 3 || piece_in_button == 6 || piece_in_button == 19 || piece_in_button == 22)  // Bishop
						{
							BISHOP bishop = new BISHOP(i,j,piece_in_button,turn);
							bishop.drawPath(pathDrawn);
							r=i;
							c=j;
							System.out.println("Bishop pressed");
						}
						else if(piece_in_button == 4 || piece_in_button == 20)  // King
						{
							KING king = new KING(i,j,piece_in_button,turn);
							king.drawPath(pathDrawn);
							r=i;
							c=j;
							System.out.println("King pressed");
						}
						else if(piece_in_button == 5 || piece_in_button == 21)  // Queen
						{
							QUEEN queen = new QUEEN(i,j,piece_in_button,turn);
							queen.drawPath(pathDrawn);
							r=i;
							c=j;
							System.out.println("Queen pressed");
						}
						click = 2;
					}
					else if(click == 2)
					{
						for(int x=0;x<8;x++)
						{
							for(int y=0;y<8;y++)
							{
								System.out.print(pathDrawn[i][j]+" ");
							}
							System.out.println();
						}
						if(pathDrawn[i][j] == true)
						{
							int temp = Game_main_class.Board[i][j];
							Game_main_class.Board[i][j] = Game_main_class.Board[r][c];
							Game_main_class.Board[r][c] = temp;
						}
						reDraw();
						click = 1;
					}
				}
			}
		}
	}
	
	
	public static void reDraw()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if((i+j) % 2 == 0)
					button[i][j].setBackground(new Color(255,229,181));//btn[i][j].setBackground(new Color(255,229,181));
				else
					button[i][j].setBackground(new Color(176,100,43));//btn[i][j].setBackground(new Color(176,100,43));
				//White
				if(Game_main_class.Board[i][j] == 0)
				{
					button[i][j].setIcon(null);
				}
				else if(Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8)
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_rook1));
				}
				else if(Game_main_class.Board[i][j] == 2)
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_knight1));
				}
				else if(Game_main_class.Board[i][j] == 7)
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_knight2));
				}
				else if(Game_main_class.Board[i][j]==3 || Game_main_class.Board[i][j]==6) 
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_pawn1));
				}
				else if(Game_main_class.Board[i][j]==4)
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_king));
				}
				else if(Game_main_class.Board[i][j]==5) 
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_queen));
				}
				else if(Game_main_class.Board[i][j]>=9 && Game_main_class.Board[i][j]<=16) 
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_pawn1));
				}
				
				//black
				else if(Game_main_class.Board[i][j]==17 || Game_main_class.Board[i][j]==24) 
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.b_rook1));
				}
				else if (Game_main_class.Board[i][j]==18) 
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.b_knight1));
				}			
				else if (Game_main_class.Board[i][j]==23) 
				{
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.b_knight2));
				}
			    else if (Game_main_class.Board[i][j]==19 || Game_main_class.Board[i][j]==22) 
				{
			    	button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.b_bishop1));
				}
			    else if(Game_main_class.Board[i][j]==20) 
			    {
			    	button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.b_king));
			    }
			    else if (Game_main_class.Board[i][j]==21)
			    {
			    	button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.b_queen));
			    }
			    else if (Game_main_class.Board[i][j]>=25 && Game_main_class.Board[i][j]<=32)
			    {
			    	button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.b_pawn1));
			    }
			}
		}
	}
}

















