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


import chess_Game.Chess_Board;

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
							
							System.out.println("Now 1");
						}
						else if(piece_in_button == 1 || piece_in_button == 8 || piece_in_button == 17 || piece_in_button == 24)  // Rook
						{
							ROOK rook = new ROOK(i,j,piece_in_button,turn);
							rook.drawPath(path);
							
							System.out.println("Rook now");
						}
						else if(piece_in_button == 2 || piece_in_button == 7 || piece_in_button == 18 || piece_in_button == 23)  // Knight
						{
							KNIGHT knight = new KNIGHT(i,j,piece_in_button,turn);
							knight.drawPath(path);
							
							System.out.println("Knight now");
						}
						else if(piece_in_button == 3 || piece_in_button == 6 || piece_in_button == 19 || piece_in_button == 22)  // Bishop
						{
							BISHOP bishop = new BISHOP(i,j,piece_in_button,turn);
							bishop.drawPath(path);
							
							System.out.println("Bishop now");
						}
						else if(piece_in_button == 5 || piece_in_button == 21)  // Queen
						{
							QUEEN queen = new QUEEN(i,j,piece_in_button,turn);
							queen.drawPath(path);
							
							System.out.println("Queen now");
						}
						
						for(int p=0;p<8;p++)
						{
							for(int q=0;q<8;q++)
							{
								if(path[p][q] == true)
								{
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
											Chess_Board.fillArray(path, false);
											Chess_Board.reDraw();
											Chess_Board.button[king_x][king_y].setBackground(new Color(219, 6, 12));
											return false;
										}
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
											Chess_Board.fillArray(path, false);
											Chess_Board.reDraw();
											Chess_Board.button[king_x][king_y].setBackground(new Color(219, 6, 12));
											return false;
										}
									}
									Chess_Board.reDraw();
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
