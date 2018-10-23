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
//import chess_Game.Pieces_btn;

public class Game_main_class
{
	public static int Board[][] = new int[8][8];
	public static boolean turn;
	public static void main(String args[])
	{
		
		new Chess_Board();  //Loading the Chess Board (The GUI) and Placing the pieces(GUI)
		
		
		for(int i=0;i<8;i++)    //Delete this later
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(Board[i][j]+" ");
			}
			System.out.println();
		}
		
		
		//infinite while loop for changing the turns infinitely
//		while(true)             //   checkmate==false
//		{
//			turn = false; // Turn is not over
//			if(turn == true)
//			{
//				Player.changeTurn();
//			}
//		}
		
	}
	public static void game_loop()
	{
		//turn = false; // Turn is not over
		if(turn == true)
		{
			Player.changeTurn();
			turn = false;
		}
	}
}
