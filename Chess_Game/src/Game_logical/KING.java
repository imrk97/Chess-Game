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
	// Check if king is checked by rook
	boolean checkedByRook(int pos_r,int pos_c)
	{
		int i,j;
		i = pos_r;
		j = pos_c;
		while(j > 0) // Checking left side
		{
			j--;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8)))
				return true;
			else
				break;
		}
		i = pos_r;
		j = pos_c;
		while(j < 7) // Checking right side
		{
			j++;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8)))
				return true;
			else
				break;
		}
		i = pos_r;
		j = pos_c;
		while(i > 0) // Checking up side
		{
			i--;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8)))
				return true;
			else
				break;
		}
		i = pos_r;
		j = pos_c;
		while(i < 7) // Checking down side
		{
			i++;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8)))
				return true;
			else
				break;
		}
		return false;
	}
	
	//Check if king is checked by bishop
	boolean checkedByBishop(int pos_r,int pos_c)
	{
		int i = pos_r,j = pos_c;
		while(i > 0 && j < 7)  // checking up-right
		{
			i--;
			j++;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6)))
				return true;
			else
				break;
		}
		i = pos_r;
		j = pos_c;
		while(i > 0 && j > 0)  // checking up-left
		{
			i--;
			j--;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6)))
				return true;
			else
				break;
		}
		i = pos_r;
		j = pos_c;
		while(i < 7 && j > 0)  // checking down-left
		{
			i++;
			j--;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6)))
				return true;
			else
				break;
		}
		i = pos_r;
		j = pos_c;
		while(i < 7 && j < 7)  // checking down-right
		{
			i++;
			j++;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22)) || (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6)))
				return true;
			else
				break;
		}
		return false;
	}
	
	//Check if king is checked by knight
	boolean checkedByKnight(int pos_r,int pos_c)
	{
		boolean flag = false;
		int i = pos_r,j = pos_c;
		if(i-1 >= 0)
		{
			if(j-2 >= 0 && ((piece_id == 4 && (Game_main_class.Board[i-1][j-2] == 18 || Game_main_class.Board[i-1][j-2] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-1][j-2] == 2 || Game_main_class.Board[i-1][j-2] == 7))))
				flag = true;
			if(j+2 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i-1][j-2] == 18 || Game_main_class.Board[i-1][j-2] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-1][j-2] == 2 || Game_main_class.Board[i-1][j-2] == 7))))
				flag = true;
		}
		if(i+1 <= 7)
		{
			if(j-2 >= 0 && ((piece_id == 4 && (Game_main_class.Board[i+1][j-2] == 18 || Game_main_class.Board[i+1][j-2] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i+1][j-2] == 2 || Game_main_class.Board[i+1][j-2] == 7))))
				flag = true;
			if(j+2 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i-1][j-2] == 18 || Game_main_class.Board[i-1][j-2] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-1][j-2] == 2 || Game_main_class.Board[i-1][j-2] == 7))))
				flag = true;
		}
		if(i+2 <= 7)
		{
			if(j-1 >= 0 && ((piece_id == 4 && (Game_main_class.Board[i+2][j-1] == 18 || Game_main_class.Board[i+2][j-1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i+2][j-1] == 2 || Game_main_class.Board[i+2][j-1] == 7))))
				flag = true;
			if(j+1 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i+2][j+1] == 18 || Game_main_class.Board[i+2][j+1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i+2][j+1] == 2 || Game_main_class.Board[i+2][j+1] == 7))))
				flag = true;
		}
		if(i-2 >= 0)
		{
			if(j-1 >= 0 && ((piece_id == 4 && (Game_main_class.Board[i-2][j-1] == 18 || Game_main_class.Board[i-2][j-1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-2][j-1] == 2 || Game_main_class.Board[i-2][j-1] == 7))))
				flag = true;
			if(j+1 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i-2][j+1] == 18 || Game_main_class.Board[i-2][j+1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-2][j+1] == 2 || Game_main_class.Board[i-2][j+1] == 7))))
				flag = true;
		}
		return flag;
	}
	
	//Check if king is checked by pawn
	boolean checkedByPawn(int pos_r,int pos_c)/////////////////////
	{
		int i = pos_r,j = pos_c;
		boolean flag = false;
		if(i+1 <= 7)   //Downside
		{
			if(j+1 <= 7 && ((piece_id == 4 && Game_main_class.Board[i+1][j+1] >= 25 && Game_main_class.Board[i+1][j+1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i+1][j+1] >= 9 && Game_main_class.Board[i+1][j+1] <= 16)))
				flag = true;
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i+1][j-1] >= 25 && Game_main_class.Board[i+1][j-1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i+1][j-1] >= 9 && Game_main_class.Board[i+1][j-1] <= 16)))
				flag = true;
		}
		else if(i-1 >= 0)    // Upside
		{
			if(j+1 <= 7 && ((piece_id == 4 && Game_main_class.Board[i-1][j+1] >= 25 && Game_main_class.Board[i-1][j+1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i-1][j+1] >= 9 && Game_main_class.Board[i-1][j+1] <= 16)))
				flag = true;
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i-1][j-1] >= 25 && Game_main_class.Board[i-1][j-1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i-1][j-1] >= 9 && Game_main_class.Board[i-1][j-1] <= 16)))
				flag = true;
		}
		return flag;
	}
	
	boolean checkedByKing(int pos_r,int pos_c) {
		int i=pos_r;
		int j=pos_c;
		boolean flag = false;
		if(i+1 <= 7)   //Downside
		{
			if(j+1 <= 7 && ((piece_id == 4 && Game_main_class.Board[i+1][j+1] >= 25 && Game_main_class.Board[i+1][j+1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i+1][j+1] >= 9 && Game_main_class.Board[i+1][j+1] <= 16)))
				flag = true;
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i+1][j-1] >= 25 && Game_main_class.Board[i+1][j-1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i+1][j-1] >= 9 && Game_main_class.Board[i+1][j-1] <= 16)))
				flag = true;
		}
		else if(i-1 >= 0)    // Upside
		{
			if(j+1 <= 7 && ((piece_id == 4 && Game_main_class.Board[i-1][j+1] >= 25 && Game_main_class.Board[i-1][j+1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i-1][j+1] >= 9 && Game_main_class.Board[i-1][j+1] <= 16)))
				flag = true;
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i-1][j-1] >= 25 && Game_main_class.Board[i-1][j-1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i-1][j-1] >= 9 && Game_main_class.Board[i-1][j-1] <= 16)))
				flag = true;
		}
		else
		
		return false;		
	}
	
	boolean isValidPath(int dest_x, int dest_y)
	{
		if((turn == "white" && piece_id == 4) || (turn == "black" && piece_id == 20))
		{
			if(checkedByRook(dest_x, dest_y) == true || checkedByBishop(dest_x, dest_y)==true || checkedByKnight(dest_x, dest_y)==true ||checkedByPawn(dest_x, dest_y)==true || che)
				return false;
		}
		return false;
	}

	boolean[][] drawPath()
	{
		
		return null;
	}
}	
