package Game_logical;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import chess_Game.Chess_Board;

public class QUEEN extends Piece
{
	// Piece_Type type;
	String turn;
	ImageIcon ii = new ImageIcon("images//validPath.png");

		
	public QUEEN(int x, int y, int piece_in_button_id, String turn)
	{
		super(x, y, piece_in_button_id);
		// type = piece_name;
		this.turn = turn; // Keeps track of currently whose turn is going on
	}
		
		
	//Bishop
	boolean upRight(int dest_x,int dest_y)
	{
		int i,j;
		i = dest_x + 1;
		j = dest_y - 1;
		while(i < x_pos && j > y_pos)
		{
			if(Game_main_class.Board[i][j] != 0)
				return true;     // Path is blocked
			i++;
			j--;
		}
		return false; // Path is not blocked
	}
	
	boolean downRight(int dest_x,int dest_y)
	{
		int i,j;
		i = dest_x - 1;
		j = dest_y - 1;
		while(i > x_pos && j > y_pos)
		{
			if(Game_main_class.Board[i][j] != 0)
				return true;     // Path is blocked
			i--;
			j--;
		}
		return false;
	}
	boolean upLeft(int dest_x,int dest_y)
	{
		int i,j;
		i = dest_x + 1;
		j = dest_y + 1;
		while(i < x_pos && j < y_pos)
		{
			if(Game_main_class.Board[i][j] != 0)
				return true;     // Path is blocked
			i++;
			j++;
		}
		return false; // Path is not blocked
	}
		
	boolean downLeft(int dest_x,int dest_y)
	{
		int i,j;
		i = dest_x - 1;
		j = dest_y + 1;
		while(i > x_pos && j < y_pos)
		{
			if(Game_main_class.Board[i][j] != 0)
				return true;     // Path is blocked
			i--;
			j++;
		}
		return false; // Path is not blocked
	}
	//end of bishop moves
	
	//start of rook moves
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
	//end of rook moves
		
		


	boolean isValidPath(int dest_x, int dest_y)
	{
		int x_distance = Math.abs(dest_x - x_pos); // row distance
		int y_distance = Math.abs(dest_y - y_pos); // column distance
		
		System.out.println("x = " + x_pos + "\ny = " + y_pos);
		System.out.println("x dist = " + x_distance + "y dist = " + y_distance);
		System.out.println("x dest = " + dest_x + " y dest = " + dest_y);
		
		//Rook moves
		if((x_distance == 0 && y_distance != 0) || (x_distance != 0 && y_distance == 0))
		{
			if(turn == "white" && piece_id <= 16 && (Game_main_class.Board[dest_x][dest_y] > 16 || Game_main_class.Board[dest_x][dest_y] == 0))
			{
				if((dest_x < x_pos && up_block(dest_x, dest_y) == false) || (dest_x > x_pos && down_block(dest_x, dest_y) == false) || 
						(dest_y < y_pos && left_block(dest_x, dest_y) == false) || (dest_y > y_pos && right_block(dest_x, dest_y) == false))
				{
					if(Game_main_class.Board[dest_x][dest_y] == 0)
					{
						Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] > 16)   // Cutting opponents
					{
						Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
						return true;
					}
					else                   //  This will never reach
						return false;
				}
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
						Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] <= 16)   // Cutting opponents
					{
						Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
						return true;
					} 
					else                   //  This will never reach
						return false;
				}	
				else
					return false;
			}
			else
				return false;
		}
		
		//Bihop moves
		else if ((x_distance == y_distance) && (x_distance != 0))
		{
			if(turn == "white" && piece_id <= 16)
			{
				if((dest_x < x_pos && dest_y > y_pos && upRight(dest_x, dest_y) == false) || (dest_x < x_pos && dest_y < y_pos && upLeft(dest_x, dest_y) == false) ||
						(dest_x > x_pos && dest_y < y_pos && downLeft(dest_x, dest_y) == false) || (dest_x > x_pos && dest_y > y_pos && downRight(dest_x, dest_y) == false))
				{
					if( Game_main_class.Board[dest_x][dest_y]  == 0)
					{
						Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] > 16)
					{
						Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
						return true;
					}
					else
						return false;
				}
				else
					return false;
			}
			else if(turn == "black" && piece_id > 16)
			{
				if((dest_x < x_pos && dest_y > y_pos && upRight(dest_x, dest_y) == false) || (dest_x < x_pos && dest_y < y_pos && upLeft(dest_x, dest_y) == false) ||
						(dest_x > x_pos && dest_y < y_pos && downLeft(dest_x, dest_y) == false) || (dest_x > x_pos && dest_y > y_pos && downRight(dest_x, dest_y) == false))
				{
					if( Game_main_class.Board[dest_x][dest_y]  == 0)
					{
						Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] <= 16)
					{
						Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
						return true;
					}
					else
						return false;
				}
				else 
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}


	public boolean[][] drawPath(boolean[][] path)
	{
		// For testing
		Game_main_class.Board[1][3] = 0;
		Game_main_class.Board[1][4] = 0;
		Game_main_class.Board[1][5] = 0;
		Game_main_class.Board[3][4] = 17;
		Game_main_class.Board[2][6] = 20;
		
		
			
		//boolean path[][] = new boolean[8][8];
		for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) 
			{
				path[i][j] = isValidPath(i,j);
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
					
					
					
		return null;    // Check later
	}
	ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(84, 84, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
}
