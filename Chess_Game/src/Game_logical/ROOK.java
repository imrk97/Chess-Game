//created by imrk97

package Game_logical;

import chess_Game.*;

public class ROOK extends Piece 
{
	Piece_Type type;
	String turn;
	int up,down,left,right,x;
	int row,col;
	
	public ROOK(int x, int y, int piece_in_button_id, String turn)
	{
		super(x, y, piece_in_button_id);
		// type=Piece_Type.Rook;
		this.turn = turn;
	}
	
	boolean up_block(int dest_x, int dest_y)
	{
		for(int i=dest_x+1;i<x_pos;i++)
			if(Game_main_class.Board[i][dest_y] != 0)
				return true;    //  Blocked
		return false;    // Not blocked
	}
	
	boolean down_block(int dest_x, int dest_y)
	{
		for(int i=dest_x-1;i>x_pos;i--)
			if(Game_main_class.Board[i][dest_y] != 0)
				return true;
		return false;
	}
	
	boolean left_block(int dest_x, int dest_y)
	{
		for(int i=dest_y+1;i<y_pos;i++)
			if(Game_main_class.Board[dest_x][i] != 0)
				return true;
		return false;
	}
	
	boolean right_block(int dest_x, int dest_y)
	{
		for(int i=dest_y-1;i>y_pos;i--)
			if(Game_main_class.Board[dest_x][i] != 0)
				return true;
		return false;
	}
	
	boolean isValidPath(int dest_x, int dest_y)
	{
		int x_distance = Math.abs(dest_x - x_pos); // row distance
		int y_distance = Math.abs(dest_y - y_pos); // column distance
		
		System.out.println("x = " + x_pos + "\ny = " + y_pos);
		System.out.println("x dist = " + x_distance + "y dist = " + y_distance);
		System.out.println("x dest = " + dest_x + " y dest = " + dest_y);
		//moves horizontally
		if((x_distance == 0 && y_distance != 0) || (x_distance != 0 && y_distance == 0))
		{
			if(turn == "white" && piece_id <= 16 && (Game_main_class.Board[dest_x][dest_y] > 16 || Game_main_class.Board[dest_x][dest_y] == 0))
			{
				if((dest_x < x_pos && up_block(dest_x, dest_y) == false) || (dest_x > x_pos && down_block(dest_x, dest_y) == false) || 
						(dest_y < y_pos && left_block(dest_x, dest_y) == false) || (dest_y > y_pos && right_block(dest_x, dest_y) == false))
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] > 16)   // Cutting opponents
					{
						return true;
					}
					else                   //  This will never reach
						return false;
				}
				/*else if(dest_x > x_pos && down_block(dest_x, dest_y) == false)
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] > 16)   // Cutting opponents
					{
						return true;
					}
					else                   //  This will never reach
						return false;
				}
				else if(dest_y < y_pos && left_block(dest_x, dest_y) == false)
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] > 16)   // Cutting opponents
					{
						return true;
					}
					else                   //  This will never reach
						return false;
				}
				else if(dest_y > y_pos && right_block(dest_x, dest_y) == false)
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] > 16)   // Cutting opponents
					{
						return true;
					}
					else                   //  This will never reach
						return false;
				}*/
				else
					return false;
			}
			else if(turn == "black" && piece_id >= 17 && Game_main_class.Board[dest_x][dest_y] < 17)
			{
				if((dest_x < x_pos && up_block(dest_x, dest_y) == false) || (dest_x > x_pos && down_block(dest_x, dest_y) == false) ||
						(dest_y < y_pos && left_block(dest_x, dest_y) == false) || (dest_y > y_pos && right_block(dest_x, dest_y) == false))
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] < 16)   // Cutting opponents
					{
						return true;
					} 
					else                   //  This will never reach
						return false;
				}
				/*else if(dest_x > x_pos && down_block(dest_x, dest_y) == false)
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] < 16)   // Cutting opponents
					{
						return true;
					} 
					else                   //  This will never reach
						return false;
				}
				else if(dest_y < y_pos && left_block(dest_x, dest_y) == false)
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] < 16)   // Cutting opponents
					{
						return true;
					} 
					else                   //  This will never reach
						return false;
				}
				else if(dest_y > y_pos && right_block(dest_x, dest_y) == false)
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] < 16)   // Cutting opponents
					{
						return true;
					} 
					else                   //  This will never reach
						return false;
				}*/
				else
					return false;
			}
			else return false;
		}
		else
			return false;
	}

	public boolean[][] drawPath() 
	{
		//Testing purpose only
		Game_main_class.Board[1][0] = 0;
		Game_main_class.Board[0][1] = 0;
		Game_main_class.Board[0][2] = 0;
		Game_main_class.Board[1][7] = 0;
		Game_main_class.Board[0][6] = 0;
		Game_main_class.Board[0][5] = 30;
		
		
		
		boolean path[][] = new boolean[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				/*path[i][j] = false;*/path[i][j] = isValidPath(i,j);
			}
		}
		
		
		
		// ------------------------------------------------------------------------------
		// For testing purpose only
				
		
		
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
		return null;       //  Change this later
	}		
}			
