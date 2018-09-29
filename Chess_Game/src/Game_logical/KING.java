/**
 * Created by Rahul on 28-Sep-2018
 * 
 */

/**
 * @author Payel
 *
 */
package Game_logical;

import chess_Game.Piece_Type;

public class KING extends Piece 
{
	Piece_Type type;
	String turn;
	
	public KING(int x, int y, int piece_in_button_id, String turn)
	{
		super(x, y, piece_in_button_id);
		// type=Piece_Type.Rook;
		this.turn = turn;
	}
	
	
	
	boolean isValidPath(int dest_x, int dest_y)
	{
		
		return false;
	}

	boolean[][] drawPath()
	{
		
		return null;
	}
}	
