/**
 * Created by Rahul on 24-Sep-2018
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

public class KNIGHT extends Piece {

	//Piece_Type type;
	String turn;
	ImageIcon ii = new ImageIcon("images//validPath.png");
	public KNIGHT(int x,int y,int piece_in_button_id, String turn)
	{
		super(x,y,piece_in_button_id);
		//type = piece_name;
		this.turn = turn;         //  Keeps track of currently whose turn is going on
	}
	
	boolean isValidPath(int dest_x, int dest_y) 
	{
		int x_distance = Math.abs(dest_x - x_pos);  // row distance
		int y_distance = Math.abs(dest_y - y_pos);  // column distance
		
		System.out.println("x = "+x_pos+"y = "+y_pos);
		System.out.println("x dist = "+x_distance+"y dist = "+y_distance);
		System.out.println("x dest = "+dest_x+" y dest = "+dest_y);
		
		if(x_distance == 2 && y_distance == 1)
		{
			if(turn == "white" && piece_id <= 16)
			{
				if(Game_main_class.Board[dest_x][dest_y] == 0)
				{
					Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
					return true;
				}
				else if(Game_main_class.Board[dest_x][dest_y] > 16)
				{
					Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
					return true;
				}
				else {
					System.out.println("A");
					return false;}
			}
			
			else if(turn == "black" && piece_id > 16)
			{
				if(Game_main_class.Board[dest_x][dest_y] == 0)
				{
					Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
					return true;
				}
				else if(Game_main_class.Board[dest_x][dest_y] <= 16)
				{
					Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
					return true;
				}
				else{
					System.out.println("B");
					return false;}
			}
			else{
				System.out.println("C");
				return false;}
		}
		else if (x_distance == 1 && y_distance == 2)
		{
			if(turn == "white" && piece_id <= 16)
			{
				if(Game_main_class.Board[dest_x][dest_y] == 0)
				{
					Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
					return true;
				}
				else if(Game_main_class.Board[dest_x][dest_y] > 16)
				{
					Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
					return true;
				}
				else{
					System.out.println("D");
					return false;}
			}
			else if(turn == "black" && piece_id > 16)
			{
				if(Game_main_class.Board[dest_x][dest_y] == 0)
				{
					Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
					return true;
				}
				else if(Game_main_class.Board[dest_x][dest_y] <= 16)
				{
					Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
					return true;
				}
				else{
					System.out.println("E");
					return false;}
			}
			else{
				System.out.println("F");
				return false;}
		}
		else{
			System.out.println("G");
			return false;}
	}
	public	void drawPath(boolean[][] path)
	{
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
		
		//Game_main_class.Board[1][3] = 30;
//		path[2][2] = isValidPath(2,2);
//		path[2][0] = isValidPath(2,0);
//		path[1][3] = isValidPath(1,3);
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
		//return null;           // modify this line
	}
	ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(84, 84, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
}
