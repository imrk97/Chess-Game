/**
 * Created by Rahul on 10-Sep-2018
 * 
 */

/**
 * @author Payel
 *
 */
package Game_logical;

public abstract class Piece
{
	//Type type;
	int x_pos,y_pos;
	Player player;
	Piece(int x,int y,Player player)
	{
		x_pos = x;
		y_pos = y;
		this.player = player;
	}
	abstract boolean isValidPath(int dest_x,int dest_y);
	abstract int [][]drawPath();
}
