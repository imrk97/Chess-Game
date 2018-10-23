/**
 * Created by Rahul on 10-Sep-2018
 * 
 */

/**
 * @author Payel
 *
 */
package Game_logical;

import chess_Game.Piece_Type;

public abstract class Piece
{
	Piece_Type type;
	int x_pos,y_pos;                 //  Here x,y are in row column convention, not in graph convention
	public int piece_id;
	//Player player;
	Piece(){}
	Piece(int x,int y,int piece_id)
	{
		x_pos = x;
		y_pos = y;
		this.piece_id = piece_id;
		//type = piece_name;
		//this.player = player;
	}
	abstract boolean isValidPath(int dest_x,int dest_y);
	abstract void drawPath(boolean path[][]);
}
