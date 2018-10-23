//created by imrk97

package Game_logical;

import java.awt.Color;
import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
//import javax.swing.border.LineBorder;

import chess_Game.*;

public class ROOK extends Piece
{
	Piece_Type type;
	String turn;
	//int up,down,left,right,x;
	ImageIcon ii = new ImageIcon("images//validPath.png");
	int row,col;
	//boolean path[][] = new boolean[8][8];
	
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
		//moves horizontally and vertically
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
						//Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
						Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
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
						Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
						return true;
					}
					else if(Game_main_class.Board[dest_x][dest_y] <= 16)   // Cutting opponents
					{
						//Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
						Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
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

	public void drawPath(boolean[][] path) 
	{
		//Testing purpose only
		//Game_main_class.Board[1][0] = 0;
//		Game_main_class.Board[0][1] = 0;
//		Game_main_class.Board[0][2] = 0;
//		Game_main_class.Board[1][7] = 0;
//		Game_main_class.Board[0][6] = 0;
//		Game_main_class.Board[0][5] = 30;
//		Game_main_class.Board[4][0] = 27;
//		
		
		
		//boolean path[][] = new boolean[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
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
		
		
		//return path;       //  Change this later
	}
	ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(84, 84, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
	
	/*public void actionPerformed(ActionEvent e) 
	{
		//boolean drawnpath[][] = drawPath();
		System.out.println("abc");
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(e.getSource() == Chess_Board.button[i][j] && path[i][j] == true)
				{
					System.out.println("ABC");
					int temp = Game_main_class.Board[i][j];
					Game_main_class.Board[i][j] = Game_main_class.Board[x_pos][y_pos];
					Game_main_class.Board[x_pos][y_pos] = temp;
				}
			}
		}
		Chess_Board.reDraw();
	}*/
}			
