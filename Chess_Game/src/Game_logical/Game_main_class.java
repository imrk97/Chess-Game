/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
/**
 * @author Payel
 *
 */
package Game_logical;
import chess_Game.Chess_Board;
import chess_Game.Pieces_btn;

public class Game_main_class
{
	Tile Board[][] = new Tile[8][8];
	public static void main(String args[])
	{
		Pieces_btn obj = new Pieces_btn(0,0);
		new Chess_Board();  //Loading the Chess Board (The GUI)
		obj.loadPieces();
		//Placing the pieces(GUI)
		
		//Writing after git  repository
		//infinite while loop for changing the turns infinitely
	}
}
