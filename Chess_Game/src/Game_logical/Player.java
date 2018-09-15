/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
/**
 * @author Payel
 *
 */
package Game_logical;


public class Player
{
	private static String player = "white";
	//Return who's turn is this
	String nowTurn()
	{
		return player;
	}
	
	void changeTurn()
	{
		if(player.equalsIgnoreCase("white"))
			player = "black";
		else
			player = "white";
	}
}
