/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
/**
 * @author Payel
 *
 */
package Game_logical;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
//import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import chess_Game.Chess_Board;

public class PAWN extends Piece
{
	//Piece_Type type;
	String turn;
	ImageIcon ii = new ImageIcon("images//validPath.png");
	
	
	public PAWN(int x,int y,int piece_in_button_id, String turn)
	{
		super(x,y,piece_in_button_id);
		//type = piece_name;
		this.turn = turn;         //  Keeps track of currently whose turn is going on
	}
	boolean isValidPath(int dest_x,int dest_y)
	{
		int x_distance = dest_x - x_pos;  // row distance
		int y_distance = Math.abs(dest_y - y_pos);  // column distance
		
		System.out.println("x = "+x_pos+"y = "+y_pos);
		System.out.println("x dist = "+x_distance+"y dist = "+y_distance);
		System.out.println("x dest = "+dest_x+" y dest = "+dest_y);
		
		//moves two step
		if(Math.abs(x_distance) == 2 && y_distance == 0 && dest_x < 8 && dest_x > -1 && Game_main_class.Board[dest_x][dest_y] == 0)
		{
			//if((y_pos == 1 && alliance == "white" && (Game_main_class.Board[x_pos][y_pos+1] == 0 || Game_main_class.Board[x_pos][y_pos+1] > 16)) || (y_pos == 6 && alliance == "black" && Game_main_class.Board[x_pos][y_pos-1] < 17))
			if(x_pos == 1 && turn == "white" && piece_id >= 9 && piece_id <= 16 && Game_main_class.Board[x_pos+1][y_pos] == 0)
			{
				Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
				return true;
			}
			else if(x_pos == 6 && turn == "black" && piece_id >= 25 && piece_id <= 32 && Game_main_class.Board[x_pos-1][y_pos] == 0)
			{
				Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
				return true;
			}
			else {
				System.out.println("A");
				return false;}
		}
		//moves one step
		else if(Math.abs(x_distance) == 1 && dest_x < 8 && dest_x > -1)
		{
			//goes straight for one step
			if(y_distance == 0 && Game_main_class.Board[dest_x][dest_y] == 0)
			{
				if(turn == "white" && piece_id >= 9 && piece_id <= 16 && x_distance > 0)
				{
					Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
					return true;
				}
				else if(turn == "black" && piece_id >= 25 && piece_id <= 32 && x_distance < 0)
				{
					Chess_Board.button[dest_x][dest_y].setIcon(resize(ii));
					return true;
				}
				else{
					System.out.println("B");
					return false;}
			}
			
			//goes diagonally for one step to cut opponent
			else if(y_distance == 1 && Game_main_class.Board[dest_x][dest_y] != 0)
			{
				if(turn == "white" && piece_id >= 9 && piece_id <= 16 && Game_main_class.Board[dest_x][dest_y] > 16 && x_distance > 0)
				{
					Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
					return true;
				}
				else if(turn == "black" && piece_id >= 25 && piece_id <= 32 && Game_main_class.Board[dest_x][dest_y] < 17 && x_distance < 0)
				{
					Chess_Board.button[dest_x][dest_y].setBackground(new Color(219, 6, 12));
					return true;
				}
				else{
					System.out.println("C");
					return false;}
			}
			else{
				System.out.println("D");
				return false;}
		}
		else{
			System.out.println("E");
			return false;}
	}
	
	public void drawPath(boolean[][] path)
	{
		//boolean path[][] = new boolean[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				path[i][j] = isValidPath(i,j);
			}
		}
		
		
		//----------------------------------------------------------------------------------------------
		// For testing purpose only
		
		
//		Game_main_class.Board[2][1] = 18;
//		path[2][1] = isValidPath(2,1);
//		path[2][0] = isValidPath(2,0);
//		path[3][0] = isValidPath(3,0);
		for(int i = 0;i<8;i++)
		{
			for(int j = 0;j<8;j++)
			{
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
		//return null;
	}
	public static void pawnPromotion(String turn,int i,int j)
	{
		JFrame f = new JFrame();
		f.getContentPane().setForeground(Color.BLACK);
		f.getContentPane().setLayout(null);
		f.setSize(320,350);
		f.setLocationRelativeTo(null);
		f.setUndecorated(true);
		f.getContentPane().setBackground(Color.BLACK);
		f.setType(Type.UTILITY);
		f.setVisible(true);
		
		JLabel lb = new JLabel("What piece do you want to promote your Pawn to?");
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb.setBounds(10, 66, 300, 37);
		JLabel label = new JLabel("Pawn Promotion");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(64, 25, 205, 30);
		ButtonGroup g = new ButtonGroup();
		JRadioButton rb_queen = new JRadioButton("QUEEN");
		rb_queen.setForeground(Color.WHITE);
		rb_queen.setFont(new Font("Lucida Handwriting", Font.ITALIC, 14));
		rb_queen.setOpaque(false);
		rb_queen.setBounds(40,110,100,30);
		JRadioButton rb_rook = new JRadioButton("ROOK");
		rb_rook.setForeground(Color.WHITE);
		rb_rook.setFont(new Font("Lucida Handwriting", Font.ITALIC, 14));
		rb_rook.setOpaque(false);
		rb_rook.setBounds(40, 155, 100, 30);
		JRadioButton rb_knight = new JRadioButton("KNIGHT");
		rb_knight.setForeground(Color.WHITE);
		rb_knight.setFont(new Font("Lucida Handwriting", Font.ITALIC, 14));
		rb_knight.setOpaque(false);
		rb_knight.setBounds(40, 200, 100, 30);
		JRadioButton rb_bishop = new JRadioButton("BISHOP");
		rb_bishop.setForeground(Color.WHITE);
		rb_bishop.setFont(new Font("Lucida Handwriting", Font.ITALIC, 14));
		rb_bishop.setOpaque(false);
		rb_bishop.setBounds(40,245,100,30);
		g.add(rb_queen);
		g.add(rb_rook);
		g.add(rb_knight);
		g.add(rb_bishop);
		JButton ok = new JButton("Ok");
		ok.setBorderPainted(false);
		ok.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		ok.setForeground(Color.WHITE);
		ok.setBackground(Color.BLACK);
		ok.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		ok.setBounds(232, 256, 60, 30);
		f.getContentPane().add(rb_bishop);
		f.getContentPane().add(rb_knight);
		f.getContentPane().add(rb_rook);
		f.getContentPane().add(rb_queen);
		f.getContentPane().add(ok);
		f.getContentPane().add(lb);
		f.getContentPane().add(label);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rb_queen.isSelected())
				{
					//System.out.println("Queen");
					if(turn == "white")
						Game_main_class.Board[i][j] = 5;
					else
						Game_main_class.Board[i][j] = 21;
					Chess_Board.reDraw();
					f.dispose();
				}
				else if(rb_rook.isSelected())
				{
					//System.out.println("Rook");
					if(turn == "white")
						Game_main_class.Board[i][j] = 1;
					else
						Game_main_class.Board[i][j] = 17;
					Chess_Board.reDraw();
					f.dispose();
				}
				else if(rb_knight.isSelected())
				{
					//System.out.println("Knight");
					if(turn == "white")
						Game_main_class.Board[i][j] = 2;
					else
						Game_main_class.Board[i][j] = 18;
					Chess_Board.reDraw();
					f.dispose();
				}
				else if(rb_bishop.isSelected())
				{
					//System.out.println("Bishop");
					if(turn == "white")
						Game_main_class.Board[i][j] = 3;
					else
						Game_main_class.Board[i][j] = 19;
					Chess_Board.reDraw();
					f.dispose();
				}
				else
					JOptionPane.showMessageDialog(f, "Please select an option before clicking on Ok");
				
			}
		});
		
		
	}
	ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(84, 84, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
}
