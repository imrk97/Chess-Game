/**
 * Created by Rahul on 28-Sep-2018
 * 
 */

/**
 * @author Payel
 *
 */
package Game_logical;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import chess_Game.Chess_Board;
import chess_Game.Piece_Type;

public class KING extends Piece 
{
	Piece_Type type;
	String turn;
	ImageIcon ii = new ImageIcon("images//validPath.png");
	//boolean path[][] = new boolean[8][8];
	
	public KING() {}    // Default
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
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("1");
				return true;
			}
			else {
				System.out.println("Aa");
				break;}
		}
		i = pos_r;
		j = pos_c;
		while(j < 7) // Checking right side
		{
			j++;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("2");
				return true;
			}
			else {
				System.out.println("Ab");
				break;}
		}
		i = pos_r;
		j = pos_c;
		while(i > 0) // Checking up side
		{
			i--;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("3");
				return true;
			}
			else {
				System.out.println("Ac");
				break;}
		}
		i = pos_r;
		j = pos_c;
		while(i < 7) // Checking down side
		{
			i++;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 17 || Game_main_class.Board[i][j] == 24 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 1 || Game_main_class.Board[i][j] == 8 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("4");
				return true;
			}
			else {
				System.out.println("Ad");
				break;}
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
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("5");
				return true;
			}
			else {
				System.out.println("B");
				break;}
		}
		i = pos_r;
		j = pos_c;
		while(i > 0 && j > 0)  // checking up-left
		{
			i--;
			j--;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("6");
				return true;
			}
			else {
				System.out.println("B");
				break;}
		}
		i = pos_r;
		j = pos_c;
		while(i < 7 && j > 0)  // checking down-left
		{
			i++;
			j--;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("7");
				return true;
			}
			else {
				System.out.println("B");
				break;}
		}
		i = pos_r;
		j = pos_c;
		while(i < 7 && j < 7)  // checking down-right
		{
			i++;
			j++;
			if(Game_main_class.Board[i][j] == 0)
				continue;
			else if((piece_id == 4 && (Game_main_class.Board[i][j] == 19 || Game_main_class.Board[i][j] == 22 || Game_main_class.Board[i][j] == 21)) 
					|| (piece_id == 20 && (Game_main_class.Board[i][j] == 3 || Game_main_class.Board[i][j] == 6 || Game_main_class.Board[i][j] == 5)))
			{
				System.out.println("8");
				return true;
			}
			else {
				System.out.println("B");
				break;}
		}
		System.out.println("C");
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
			{
				System.out.println("9");
				flag = true;
			}
			if(j+2 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i-1][j+2] == 18 || Game_main_class.Board[i-1][j+2] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-1][j+2] == 2 || Game_main_class.Board[i-1][j+2] == 7))))
			{
				System.out.println("10");
				flag = true;
			}
		}
		if(i+1 <= 7)
		{
			if(j-2 >= 0 && ((piece_id == 4 && (Game_main_class.Board[i+1][j-2] == 18 || Game_main_class.Board[i+1][j-2] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i+1][j-2] == 2 || Game_main_class.Board[i+1][j-2] == 7))))
			{
				System.out.println("11");
				flag = true;
			}
			if(j+2 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i+1][j+2] == 18 || Game_main_class.Board[i+1][j+2] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i+1][j+2] == 2 || Game_main_class.Board[i+1][j+2] == 7))))
			{
				System.out.println("12");
				flag = true;
			}
		}
		if(i+2 <= 7)
		{
			if(j-1 >= 0 && ((piece_id == 4 && (Game_main_class.Board[i+2][j-1] == 18 || Game_main_class.Board[i+2][j-1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i+2][j-1] == 2 || Game_main_class.Board[i+2][j-1] == 7))))
			{
				System.out.println("13");
				flag = true;
			}
			if(j+1 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i+2][j+1] == 18 || Game_main_class.Board[i+2][j+1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i+2][j+1] == 2 || Game_main_class.Board[i+2][j+1] == 7))))
			{
				System.out.println("14");
				flag = true;
			}
		}
		if(i-2 >= 0)
		{
			if(j-1 >= 0 && ((piece_id == 4 && (Game_main_class.Board[i-2][j-1] == 18 || Game_main_class.Board[i-2][j-1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-2][j-1] == 2 || Game_main_class.Board[i-2][j-1] == 7))))
			{
				System.out.println("15");
				flag = true;
			}
			if(j+1 <= 7 && ((piece_id == 4 && (Game_main_class.Board[i-2][j+1] == 18 || Game_main_class.Board[i-2][j+1] == 23))) || 
					((piece_id == 20 && (Game_main_class.Board[i-2][j+1] == 2 || Game_main_class.Board[i-2][j+1] == 7))))
			{
				System.out.println("16");
				flag = true;
			}
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
			{
				System.out.println("17");
				flag = true;
			}
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i+1][j-1] >= 25 && Game_main_class.Board[i+1][j-1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i+1][j-1] >= 9 && Game_main_class.Board[i+1][j-1] <= 16)))
			{
				System.out.println("18");
				flag = true;
			}
		}
		else if(i-1 >= 0)    // Upside
		{
			if(j+1 <= 7 && ((piece_id == 4 && Game_main_class.Board[i-1][j+1] >= 25 && Game_main_class.Board[i-1][j+1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i-1][j+1] >= 9 && Game_main_class.Board[i-1][j+1] <= 16)))
			{
				System.out.println("19");
				flag = true;
			}
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i-1][j-1] >= 25 && Game_main_class.Board[i-1][j-1] <= 32) 
					|| (piece_id == 20 && Game_main_class.Board[i-1][j-1] >= 9 && Game_main_class.Board[i-1][j-1] <= 16)))
			{
				System.out.println("20");
				flag = true;
			}
		}
		return flag;
	}
	
	boolean checkedByKing(int pos_r,int pos_c) {
		int i=pos_r;
		int j=pos_c;
		boolean flag = false;
		if(i+1 <= 7)   //Downside
		{
			if((piece_id == 4 && Game_main_class.Board[i+1][j] == 20) || (piece_id == 20 && Game_main_class.Board[i+1][j] == 4))
			{
				System.out.println("21");
				flag = true;
			}
			else if(j+1 <= 7 && ((piece_id == 4 && Game_main_class.Board[i+1][j+1] == 20) || (piece_id == 20 && Game_main_class.Board[i+1][j+1] == 4)))
			{
				System.out.println("22");
				flag = true;
			}
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i+1][j-1] == 20) || (piece_id == 20 && Game_main_class.Board[i+1][j-1] == 4)))
			{
				System.out.println("23");
				flag = true;
			}
		}
		else if(i-1 >= 0)    // Upside
		{
			if((piece_id == 4 && Game_main_class.Board[i-1][j] == 20) || (piece_id == 20 && Game_main_class.Board[i-1][j] == 4))
			{
				System.out.println("24");
				flag = true;
			}
			else if(j+1 <= 7 && ((piece_id == 4 && Game_main_class.Board[i-1][j+1] == 20) || (piece_id == 20 && Game_main_class.Board[i-1][j+1] == 4)))
			{
				System.out.println("25");
				flag = true;
			}
			else if(j-1 >= 0 && ((piece_id == 4 && Game_main_class.Board[i-1][j-1] == 20) || (piece_id == 20 && Game_main_class.Board[i-1][j-1] == 4)))
			{
				System.out.println("26");
				flag = true;
			}
		}
		else if(j+1<=7 && ((piece_id == 4 && Game_main_class.Board[i][j+1] == 20) || piece_id == 20 && Game_main_class.Board[i][j+1] == 4))
		{
			System.out.println("27");
			flag = true;
		}
		else if(j-1<=7 && ((piece_id == 4 && Game_main_class.Board[i][j-1] == 20) || piece_id == 20 && Game_main_class.Board[i][j-1] == 4))
		{
			System.out.println("28");
			flag = true;
		}
		
		return flag;
	}
	
	boolean isValidPath(int dest_x, int dest_y)
	{
		if((x_pos != dest_x || y_pos != dest_y) && ((turn == "white" && piece_id == 4) || (turn == "black" && piece_id == 20)))
		{
			if((checkedByRook(dest_x, dest_y) == true) || (checkedByBishop(dest_x, dest_y)==true) || (checkedByKnight(dest_x, dest_y)==true) 
					|| (checkedByPawn(dest_x, dest_y)==true) || (checkedByKing(dest_x, dest_y)==true))
				return false;
			else if(turn == "white" && piece_id == 4 && Game_main_class.Board[dest_x][dest_y] >= 1 && Game_main_class.Board[dest_x][dest_y] <= 16)
				return false;
			else if(turn == "black" && piece_id == 20 && Game_main_class.Board[dest_x][dest_y] >= 17 && Game_main_class.Board[dest_x][dest_y] <= 32)
				return false;
			else
			{
				System.out.println("Ka");
				if(Game_main_class.Board[dest_x][dest_y] == 0)
				{
					Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
					//return true;
				}
				else            // Cutting opponents
				{
					Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
					//return true;
				}
				return true;
			}
		}
		else {
			System.out.println("Kb");
			return false;}
	}

	public void drawPath(boolean[][] path)
	{
		// For testing
//				Game_main_class.Board[0][0] = 0;
//				Game_main_class.Board[0][1] = 0;
//				Game_main_class.Board[0][2] = 7;
//				Game_main_class.Board[0][4] = 0;
//				Game_main_class.Board[1][0] = 0;
//				Game_main_class.Board[1][1] = 0;
//				Game_main_class.Board[1][2] = 0;
//				Game_main_class.Board[1][3] = 0;
//				Game_main_class.Board[1][4] = 0;
//				Game_main_class.Board[3][1] = 18;
//				//Game_main_class.Board[4][4] = 17;
//				Game_main_class.Board[1][5] = 0;
//				Game_main_class.Board[2][6] = 19;
				//Game_main_class.Board[0][5] = 0;
				
				
					
				//boolean path[][] = new boolean[8][8];
				int temp = Game_main_class.Board[x_pos][y_pos];
				Game_main_class.Board[x_pos][y_pos] = 0;
				for (int i = x_pos-1; i <= x_pos+1; i++) //0
				{
					for (int j = y_pos-1; j <= y_pos+1; j++)  //3 
					{
						if(i >= 0 && i < 8 && j >=0 && j < 8) {
							System.out.println("i="+i+" j="+j);
							path[i][j] = isValidPath(i,j);}
					}
				}
				Game_main_class.Board[x_pos][y_pos] = temp;
				//path[0][2] = isValidPath(0, 2);
				
				
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
				//return null;    // Check later
		
	}
	public boolean king_inCheck(int row,int col)  // row and col is King's
	{
		for(int a=0;a<8;a++)
		{
			for(int b=0;b<8;b++)
			{
				System.out.print(Game_main_class.Board[a][b]+" ");
			}
			System.out.println();
		}
		piece_id = Game_main_class.Board[row][col];
		if((checkedByRook(row, col) == true) || (checkedByBishop(row, col)==true) || (checkedByKnight(row, col)==true) 
				|| (checkedByPawn(row, col)==true) || (checkedByKing(row, col)==true))
		{
			System.out.println("In check!!!");
			Chess_Board.button[row][col].setBackground(new Color(219, 6, 12));    
			return true;
		}
		else
		{
			System.out.println("Not in check i="+row+"j= "+col);
			
			return false;
		}
			
	}
	ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(84, 84, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
}	
