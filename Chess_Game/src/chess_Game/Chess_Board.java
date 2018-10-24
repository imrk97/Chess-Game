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
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Game_logical.After_checkMate;
import Game_logical.BISHOP;
import Game_logical.Check_mate_class;
import Game_logical.Game_main_class;
import Game_logical.KING;
import Game_logical.KNIGHT;
import Game_logical.PAWN;
import Game_logical.Player;
import Game_logical.QUEEN;
import Game_logical.ROOK;
import database_score.Addname;
import database_score.update_score;

//import chess_Game.Pieces_btn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JMenuBar;
//import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import Frontend.Menu1;

import javax.swing.border.LineBorder;

public class Chess_Board extends JFrame implements ActionListener
{
	//JButton btn[][] = new JButton[8][8];
	private static String white_player,black_player;
	public static String winner = "";
	public static String looser = "";		
	private static boolean inCheck = false;                             // it knows if the king is in check or not
	public static Pieces_btn button[][] = new Pieces_btn[8][8];
	public static JLabel lbl1[][] = new JLabel[8][2];
	public static JLabel lbl2[][] = new JLabel[8][2];
	static int w_k_r = 0,w_k_c = 3;
	static int b_k_r = 7,b_k_c = 3;
	ImageIcon icon = new ImageIcon("images//blank_tile.png");
	JPanel panel;
	JPanel panel_1;
	JPanel panel_2;
	JPanel p;
	int click = 1;
	int r,c;
	int store_x,store_y;
	private boolean shift_king = false;
	KING k = new KING();
	boolean pathDrawn[][] = new boolean[8][8];
	private static boolean change_click = true;     // the value of click will be changed or not
	private static boolean change_turn = true;
	/*public static void main(String args[])
	{
		new Chess_Board1();
	}*/
	public Chess_Board(String player1,String player2)
	{
		super("Chess Game");
		
		white_player = player1;
		black_player = player2;
		System.out.println("Players : "+white_player+" "+black_player);
		//menuBar = new JMenuBar();
		//setJMenuBar(menuBar);
		
		//lblNewLabel = new JLabel("New label");
		//menuBar.add(lblNewLabel);
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
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, (int) ((screenSize.height-40)*1.72/4), screenSize.height-35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBounds((int)(((screenSize.height-40)*1.72/4)-((screenSize.height-35)/4)), 0, (int)((screenSize.height-35)/4), screenSize.height-35);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(8, 2, 2, 2));
		
		
		p = new JPanel();
		p.setBorder(new MatteBorder(2, 4, 2, 4, (Color) new Color(0, 0, 0)));
		//p.setBounds(310, 0, 740, 740);
		p.setBounds((int) ((screenSize.height-40)*1.72/4), 0, screenSize.height-35, screenSize.height-35);
		panel.add(p);
		p.setLayout(new GridLayout(8, 8, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds((int) ((screenSize.height-40)*1.72/4)+(screenSize.height-35), 0, (int) ((screenSize.height-40)*1.72/4), screenSize.height-35);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBounds(0, 0, (int)((screenSize.height-35)/4), screenSize.height-35);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(8, 2, 2, 2));
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<2;j++)
			{
				lbl1[i][j] = new JLabel();
				lbl1[i][j].setOpaque(false);
				lbl1[i][j].setIcon(Pieces_btn.resize(icon));
				lbl1[i][j].setBorder(new LineBorder(Color.WHITE, 2, true));
				panel_3.add(lbl1[i][j]);
				lbl2[i][j] = new JLabel();
				lbl2[i][j].setOpaque(false);
				lbl2[i][j].setIcon(Pieces_btn.resize(icon));
				lbl2[i][j].setBorder(new LineBorder(Color.WHITE, 2, true));
				panel_4.add(lbl2[i][j]);
			}
		}
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
						
						fillArray(pathDrawn,false);
						
						
						if((turn == "white" && piece_in_button >= 1 && piece_in_button <= 16) || (turn == "black" && piece_in_button >= 17 && piece_in_button <= 32))
						{
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
						else
							JOptionPane.showMessageDialog(this, "Not your turn!!");
						
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
							//if(inCheck == false || (inCheck == true && k.king_inCheck(w_k_r,w_k_c) == true))
							//{
							//	inCheck = true;
							//	System.out.println("Checking for check");
							//}
							change_turn = true;
							if(Game_main_class.Board[i][j] == 0)
							{
								//int temp = Game_main_class.Board[i][j];
								//Game_main_class.Board[i][j] = Game_main_class.Board[r][c];
								//Game_main_class.Board[r][c] = temp;
								placePieceInBoard(i, j, r, c);
								if(Game_main_class.Board[i][j] == 4)
								{
									shift_king = true;     // king is shifted
									store_x = w_k_r;
									store_y = w_k_c;
									w_k_r = i;
									w_k_c = j;
								}
								else if(Game_main_class.Board[i][j] == 20)
								{
									shift_king = true;     // king is shifted
									store_x = b_k_r;
									store_y = b_k_c;
									b_k_r = i;
									b_k_c = j;
								}
								if(inCheck == true)
								{
									if((pl_obj.nowTurn() == "white" && k.king_inCheck(w_k_r,w_k_c) == true) || (pl_obj.nowTurn() == "black" && k.king_inCheck(b_k_r,b_k_c) == true))
									{
										System.out.println("Check is not cleared");
										placePieceInBoard(i, j, r, c);
										JOptionPane.showMessageDialog(this, "Your King is on Check!!! Please do clear it first.");
										//change_click = false;
										change_turn = false;
										if(pl_obj.nowTurn() == "white" && shift_king == true)
										{
											w_k_r = store_x;
											w_k_c = store_y;
										}
										else if(pl_obj.nowTurn() == "black" && shift_king == true)
										{
											b_k_r = store_x;
											b_k_c = store_y;
										}
									}
									else
									{
										System.out.println("Check cleared");
										inCheck = false;        // King is not in check now
										//change_click = true;    // So value of change_click can be changed
										change_turn = true;
									}
										
								}
								shift_king = false;
								
							}
							else          // Cutting opponents
							{
								int temp = Game_main_class.Board[i][j];
								Game_main_class.Board[i][j]=0;
								placePieceInBoard(i, j, r, c);
								if(Game_main_class.Board[i][j] == 4)
								{
									shift_king = true;     // king is shifted
									store_x = w_k_r;
									store_y = w_k_c;
									w_k_r = i;
									w_k_c = j;
								}
								else if(Game_main_class.Board[i][j] == 20)
								{
									shift_king = true;     // king is shifted
									store_x = b_k_r;
									store_y = b_k_c;
									b_k_r = i;
									b_k_c = j;
								}
								
								if(inCheck == true)
								{
									if((pl_obj.nowTurn() == "white" && k.king_inCheck(w_k_r,w_k_c) == true) || (pl_obj.nowTurn() == "black" && k.king_inCheck(b_k_r,b_k_c) == true))
									{
										System.out.println("Check is not cleared");
										placePieceInBoard(i, j, r, c);
										Game_main_class.Board[i][j] = temp;
										JOptionPane.showMessageDialog(this, "Your King is on Check!!! Please do clear it first.");
										//change_click = false;
										change_turn = false;
										if(pl_obj.nowTurn() == "white" && shift_king == true)
										{
											w_k_r = store_x;
											w_k_c = store_y;
										}
										else if(pl_obj.nowTurn() == "black" && shift_king == true)
										{
											b_k_r = store_x;
											b_k_c = store_y;
										}
									}
									else
									{
										System.out.println("Check cleared");
										Dead_pieces.Dead_piece_place(pl_obj.nowTurn(), (ImageIcon)button[i][j].getIcon());
										inCheck = false;        // King is not in check now
										//change_click = true;    // So value of change_click can be changed
										change_turn = true;
									}
								}
								else
								{
									Dead_pieces.Dead_piece_place(pl_obj.nowTurn(), (ImageIcon)button[i][j].getIcon());
								}
								
								shift_king = false;
								
								//Game_main_class.Board[i][j] = Game_main_class.Board[r][c];
								//Game_main_class.Board[r][c] = 0;
							}
							
							if((Game_main_class.Board[i][j] >= 9 && Game_main_class.Board[i][j] <= 16 && i == 7) || 
									(Game_main_class.Board[i][j] >=25 && Game_main_class.Board[i][j] <= 32 && i == 0))
								PAWN.pawnPromotion(pl_obj.nowTurn(), i, j);
//							else if(Game_main_class.Board[i][j] == 4)
//							{
//								w_k_r = i;
//								w_k_c = j;
//							}
//							else if(Game_main_class.Board[i][j] == 20)
//							{
//								b_k_r = i;
//								b_k_c = j;
//							}
							
							
							reDraw();
							if(change_turn == true)
							{
								Game_main_class.turn = true;   // Changing the turn
								Game_main_class.game_loop();   // Changing the turn
								
								System.out.println("Checking for check");
								if(pl_obj.nowTurn() == "white")           // Checking if nowturn's king is in check situation
								{
									//k.piece_id = 4;
									if(k.king_inCheck(w_k_r,w_k_c) == true)
									{
										inCheck = true;
										Check_mate_class mate = new Check_mate_class(w_k_r, w_k_c, 4, pl_obj.nowTurn());
										if(mate.checkMate(w_k_r, w_k_c) == true)
										{
											JOptionPane.showMessageDialog(this, "Check-mate");
											if(pl_obj.nowTurn() == "white")
											{
												winner = black_player;
												looser = white_player;
											}
											else
											{
												winner = white_player;
												looser = black_player;
											}
											this.dispose();
											//new Menu1();
											new After_checkMate(winner,looser);
											
										}
									}
								}
								else       //  Checking the same for black's turn
								{
									if(k.king_inCheck(b_k_r,b_k_c) == true)
									{
										inCheck = true;
										Check_mate_class mate = new Check_mate_class(b_k_r, b_k_c, 20, pl_obj.nowTurn());
										if(mate.checkMate(b_k_r, b_k_c) == true)
										{
											JOptionPane.showMessageDialog(this, "Check-mate");
											if(pl_obj.nowTurn() == "white")
											{
												winner = black_player;
												looser = white_player;
											}
											else
											{
												winner = white_player;
												looser = black_player;
											}
											this.dispose();
											new Menu1();
											new After_checkMate(winner,looser);
										}
									}
								}
								//if((pl_obj.nowTurn() == "white" && k.king_inCheck(w_k_r,w_k_c) == true) || (pl_obj.nowTurn() == "black" && k.king_inCheck(b_k_r,b_k_c) == true))
								//	inCheck = true;
								//Player.changeTurn();
							}
							
						}
						else if(r == i && c == j)
						{
							reDraw();
						}
						else
						{
							reDraw();
							JOptionPane.showMessageDialog(this, "Invalid move!!");
							change_turn = false;
						}
							
						
						//reDraw();
						if(change_click == true)
							click = 1;
					}
				}
			}
		}
	}
	
	
	public static void fillArray(boolean[][] pathDrawn2, boolean b)
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				pathDrawn2[i][j] = b;
			}
		}
		
	}

	
	public static void placePieceInBoard(int i,int j,int r,int c)     //   A swapping procedure
	{
		int temp = Game_main_class.Board[i][j];
		Game_main_class.Board[i][j] = Game_main_class.Board[r][c];
		Game_main_class.Board[r][c] = temp;
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
					button[i][j].setIcon(Pieces_btn.resize(Pieces_btn.w_bishop1));
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








