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
import java.lang.Math;

public class PAWN extends Piece
{
	Piece_Type type;
	public PAWN(int x,int y,/*Player player,*/Piece_Type arr)
	{
		super(x,y,player);
		type = arr;
	}
	boolean isValidPath(int dest_x,int dest_y)
	{
		int x_distance = Math.abs(dest_x - x_pos);
		int y_distance = Math.abs(dest_y - y_pos);
		if(y_distance == 2 && x_distance == 0 && dest_y < 8 && dest_y > -1)
		{
			if((y_pos == 1 && player.nowTurn() == "white") || (y_pos == 6 && player.nowTurn() == "black"))
			{
				return true;
			}
			else
				return false;
		}
		else if(y_distance == 1 && dest_y < 8 && dest_y > -1)
		{
			//if(x_distance == 0 && )
		}
		else
			return false;
	}
	
	int [][]drawPath()
	{
		
	}
}
