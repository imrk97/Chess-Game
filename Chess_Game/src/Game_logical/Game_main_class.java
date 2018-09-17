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
	public static int Board[][] = new int[8][8];
	public static void main(String args[])
	{
		Pieces_btn obj = new Pieces_btn(0,0);
		new Chess_Board();  //Loading the Chess Board (The GUI) and Placing the pieces(GUI)
		//obj.loadPieces();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(Board[i][j]+" ");
			}
			System.out.println();
		}
		//System.out.println("Hello");
		//Writing after git  repository
		
		//infinite while loop for changing the turns infinitely
	}
}
