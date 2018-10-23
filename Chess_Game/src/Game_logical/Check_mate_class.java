/**
 * Created by Rahul on 22-Oct-2018
 * 
 */

/**
 * @author Payel
 *
 */

package Game_logical;

import java.awt.Color;

//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
import chess_Game.Chess_Board;
//import chess_Game.Dead_pieces;

public class Check_mate_class
{
	String turn;
	static int king_x,king_y;
	boolean path[][] = new boolean[8][8];
	int piece_in_button;
	Player pl_obj = new Player();
	KING k = new KING();
	
	public Check_mate_class(int x, int y, int piece_in_button_id, String turn)
	{
		this.turn = turn;
		king_x = x;
		king_y = y;
		//piece_in_button = piece_in_button_id;
		KING king = new KING(x, y, piece_in_button_id, turn);
		king.drawPath(path);
	}
	
	boolean kingMovable(int row,int col)
	{
		for (int i = row-1; i <= row+1; i++) //0
		{
			for (int j = col-1; j <= col+1; j++)  //3 
			{
				if(i >= 0 && i < 8 && j >=0 && j < 8 && path[i][j] == true)
				{
					return true;         //  King is movable
				}
			}
		}
		return false;
	}
	public boolean checkMate(int row,int col)
	{
		if(kingMovable(row, col) == true)
		{
			Chess_Board.reDraw();
			Chess_Board.button[row][col].setBackground(new Color(219, 6, 12));
			System.out.println("King movable");
			return false;             // King is movable, so check-mate is not occurred
		}
		else
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					if((turn == "white" && Game_main_class.Board[i][j] >= 1 && Game_main_class.Board[i][j] <= 16) 
							|| (turn == "black" && Game_main_class.Board[i][j] >= 17 && Game_main_class.Board[i][j] <= 32))
					{
						piece_in_button = Game_main_class.Board[i][j];
						//turn = pl_obj.nowTurn();
						
						Chess_Board.fillArray(path,false);
						if((piece_in_button >= 9 && piece_in_button <= 16) || (piece_in_button >= 25 && piece_in_button <= 32)) // Pawn
						{
							PAWN pawn = new PAWN(i,j,piece_in_button,turn);
							pawn.drawPath(path);
							//r=i;
							//c=j;
							System.out.println("Now 1");
						}
						else if(piece_in_button == 1 || piece_in_button == 8 || piece_in_button == 17 || piece_in_button == 24)  // Rook
						{
							ROOK rook = new ROOK(i,j,piece_in_button,turn);
							rook.drawPath(path);
							//r=i;
							//c=j;
							//rook.actionPerformed(e);
							System.out.println("Rook now");
						}
						else if(piece_in_button == 2 || piece_in_button == 7 || piece_in_button == 18 || piece_in_button == 23)  // Knight
						{
							KNIGHT knight = new KNIGHT(i,j,piece_in_button,turn);
							knight.drawPath(path);
							//r=i;
							//c=j;
							System.out.println("Knight now");
						}
						else if(piece_in_button == 3 || piece_in_button == 6 || piece_in_button == 19 || piece_in_button == 22)  // Bishop
						{
							BISHOP bishop = new BISHOP(i,j,piece_in_button,turn);
							bishop.drawPath(path);
							//r=i;
							//c=j;
							System.out.println("Bishop now");
						}
//						else if(piece_in_button == 4 || piece_in_button == 20)  // King
//						{
//							KING king = new KING(i,j,piece_in_button,turn);
//							king.drawPath(path);
//							//r=i;
//							//c=j;
//							System.out.println("King now");
//						}
						else if(piece_in_button == 5 || piece_in_button == 21)  // Queen
						{
							QUEEN queen = new QUEEN(i,j,piece_in_button,turn);
							queen.drawPath(path);
							//r=i;
							//c=j;
							System.out.println("Queen now");
						}
						//click = 2;
						
						for(int p=0;p<8;p++)
						{
							for(int q=0;q<8;q++)
							{
								if(path[p][q] == true)
								{
									//if(inCheck == false || (inCheck == true && k.king_inCheck(w_k_r,w_k_c) == true))
									//{
									//	inCheck = true;
									//	System.out.println("Checking for check");
									//}
									//change_turn = true;
									if(Game_main_class.Board[p][q] == 0)
									{
										
										Chess_Board.placePieceInBoard(p, q, i, j);
										if(k.king_inCheck(king_x, king_y) == true)
										{
											Chess_Board.placePieceInBoard(p, q, i, j);
											System.out.println("do not go i="+i+" j="+j);
										}
										else
										{
											Chess_Board.placePieceInBoard(p, q, i, j);
											System.out.println("Piece="+ Game_main_class.Board[1][2] +"Blocking 1"+k.king_inCheck(king_x, king_y)+k.piece_id);
											return false;
										}
										
										//if(inCheck == true)
										//{
										//	if((pl_obj.nowTurn() == "white" && k.king_inCheck(w_k_r,w_k_c) == true) || (pl_obj.nowTurn() == "black" && k.king_inCheck(b_k_r,b_k_c) == true))
										//	{
										//		System.out.println("Check is not cleared");
										//		placePieceInBoard(i, j, r, c);
												//JOptionPane.showMessageDialog(this, "Your King is on Check!!! Please do clear it first.");
												//change_click = false;
												//change_turn = false;
										//	}
										//	else
										//	{
										//		System.out.println("Check cleared");
										//		inCheck = false;        // King is not in check now
										//		//change_click = true;    // So value of change_click can be changed
										//		change_turn = true;
										//	}
												
										//}
										
									}
									else          // Cutting opponents
									{
										int temp = Game_main_class.Board[p][q];
										Game_main_class.Board[p][q]=0;
										Chess_Board.placePieceInBoard(p, q, i, j);
										if(k.king_inCheck(king_x, king_y) == true)
										{
											Chess_Board.placePieceInBoard(p, q, i, j);
											Game_main_class.Board[p][q] = temp;
										}
										else
										{
											Chess_Board.placePieceInBoard(p, q, i, j);
											Game_main_class.Board[p][q] = temp;
											System.out.println("Blocking 2");
											return false;
										}
										
										
//										if(inCheck == true)
//										{
//											if((pl_obj.nowTurn() == "white" && k.king_inCheck(w_k_r,w_k_c) == true) || (pl_obj.nowTurn() == "black" && k.king_inCheck(b_k_r,b_k_c) == true))
//											{
//												System.out.println("Check is not cleared");
//												placePieceInBoard(i, j, r, c);
//												Game_main_class.Board[i][j] = temp;
//												JOptionPane.showMessageDialog(this, "Your King is on Check!!! Please do clear it first.");
//												//change_click = false;
//												change_turn = false;
//											}
//											else
//											{
//												System.out.println("Check cleared");
//												inCheck = false;        // King is not in check now
//												//change_click = true;    // So value of change_click can be changed
//												change_turn = true;
//											}
//												
//										}
										//else
										//{
										//	Dead_pieces.Dead_piece_place(pl_obj.nowTurn(), (ImageIcon)button[i][j].getIcon());
										//}
										
										
										
										//Game_main_class.Board[i][j] = Game_main_class.Board[r][c];
										//Game_main_class.Board[r][c] = 0;
									}
									
//									if((Game_main_class.Board[i][j] >= 9 && Game_main_class.Board[i][j] <= 16 && i == 7) || 
//											(Game_main_class.Board[i][j] >=25 && Game_main_class.Board[i][j] <= 32 && i == 0))
//										PAWN.pawnPromotion(pl_obj.nowTurn(), i, j);
//									else if(Game_main_class.Board[i][j] == 4)
//									{
//										w_k_r = i;
//										w_k_c = j;
//									}
//									else if(Game_main_class.Board[i][j] == 20)
//									{
//										b_k_r = i;
//										b_k_c = j;
//									}
//									
									
									Chess_Board.reDraw();/////////////////////////////////////////////////////////////////////////////////
//									if(change_turn == true)
//									{
//										Game_main_class.turn = true;   // Changing the turn
//										Game_main_class.game_loop();   // Changing the turn
//										
//										System.out.println("Checking for check");
//										if(pl_obj.nowTurn() == "white")           // Checking if nowturn's king is in check situation
//										{
//											k.piece_id = 4;
//											if(k.king_inCheck(w_k_r,w_k_c) == true)
//												inCheck = true;
//										}
//										else
//										{
//											k.piece_id = 20;
//											if(k.king_inCheck(b_k_r,b_k_c) == true)
//												inCheck = true;
//										}
//										//if((pl_obj.nowTurn() == "white" && k.king_inCheck(w_k_r,w_k_c) == true) || (pl_obj.nowTurn() == "black" && k.king_inCheck(b_k_r,b_k_c) == true))
//										//	inCheck = true;
//										//Player.changeTurn();
//									}
//									
								}
							}
						}
						
					}
				}
			}
		}
		System.out.println("Can not block");
		return true;
	}
}
