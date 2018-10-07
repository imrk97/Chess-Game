/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
package chess_Game;

//import java.awt.Graphics;
import java.awt.Image;
//import java.awt.image.BufferedImage;
import Game_logical.Game_main_class;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//import Game_logical.Game_main_class;

public class Pieces_btn extends JButton
{	
	int x,y;
	static ImageIcon b_king,b_queen,b_bishop1,b_knight1,b_knight2,b_rook1;
	static ImageIcon b_pawn1;
	static ImageIcon w_king,w_queen,w_bishop1,w_knight1,w_knight2,w_rook1;
	static ImageIcon w_pawn1;
	public Pieces_btn(int i,int j)
	{
		b_queen = new ImageIcon("images//B_Queen.png");
		b_king = new ImageIcon("images//B_King.png");
		b_bishop1 = new ImageIcon("images//B_Bishop.png");
		b_knight1 = new ImageIcon("images//B_Knight1.png");
		b_knight2 = new ImageIcon("images//B_Knight2.png");
		b_rook1 = new ImageIcon("images//B_Rook.png");
		b_pawn1 = new ImageIcon("images//B_Pawn.png");
		w_queen = new ImageIcon("images//W_Queen.png");
		w_king = new ImageIcon("images//W_King.png");
		w_bishop1 = new ImageIcon("images//W_Bishop.png");
		w_knight1 = new ImageIcon("images//W_Knight1.png");
		w_knight2 = new ImageIcon("images//W_Knight2.png");
		w_rook1 = new ImageIcon("images//W_Rook.png");
		w_pawn1 = new ImageIcon("images//W_Pawn.png");
		w_knight1 = new ImageIcon("images//W_Knight1.png");
		if(i==0)
		{
			if(j==0) 
			{
				this.setIcon(resize(w_rook1));
				Game_main_class.Board[i][j] = Piece_Type.W_ROOK1.ordinal();
			}
			else if(j == 1) 
			{
				this.setIcon(resize(w_knight1));
				Game_main_class.Board[i][j] = Piece_Type.W_KNIGHT1.ordinal();
			}
			else if(j == 2) 
			{
				this.setIcon(resize(w_bishop1));
				Game_main_class.Board[i][j] = Piece_Type.W_BISHOP1.ordinal();
			}
			else if(j == 3) 
			{
				this.setIcon(resize(w_king));
				Game_main_class.Board[i][j] = Piece_Type.W_KING.ordinal();
			}
			else if(j == 4) 
			{
				this.setIcon(resize(w_queen));
				Game_main_class.Board[i][j] = Piece_Type.W_QUEEN.ordinal();
			}
			else if(j == 5) 
			{
				this.setIcon(resize(w_bishop1));
				Game_main_class.Board[i][j] = Piece_Type.W_BISHOP2.ordinal();
			}
			else if(j == 6) 
			{
				this.setIcon(resize(w_knight2));
				Game_main_class.Board[i][j] = Piece_Type.W_KNIGHT2.ordinal();
			}
			else/* if(j == 7)*/
			{
				this.setIcon(resize(w_rook1));
				Game_main_class.Board[i][j] = Piece_Type.W_ROOK2.ordinal();
			}	
		}
		else if(i == 1)
		{
			this.setIcon(resize(w_pawn1));
			if(j==0) 
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN1.ordinal();
			else if(j == 1) 
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN2.ordinal();
			else if(j == 2) 
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN3.ordinal();
			else if(j == 3) 
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN4.ordinal();
			else if(j == 4) 
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN5.ordinal();
			else if(j == 5) 
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN6.ordinal();
			else if(j == 6) 
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN7.ordinal();
			else
				Game_main_class.Board[i][j] = Piece_Type.W_PAWN8.ordinal();
		}
		else if(i == 6) 
		{
			this.setIcon(resize(b_pawn1));
			if(j==0) 
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN1.ordinal();
			else if(j == 1) 
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN2.ordinal();
			else if(j == 2) 
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN3.ordinal();
			else if(j == 3) 
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN4.ordinal();
			else if(j == 4) 
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN5.ordinal();
			else if(j == 5) 
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN6.ordinal();
			else if(j == 6) 
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN7.ordinal();
			else
				Game_main_class.Board[i][j] = Piece_Type.B_PAWN8.ordinal();
		}
		else if(i == 7)
		{
			if(j==0) 
			{
				this.setIcon(resize(b_rook1));
				Game_main_class.Board[i][j] = Piece_Type.B_ROOK1.ordinal();
			}
			else if(j == 1) 
			{
				this.setIcon(resize(b_knight1));
				Game_main_class.Board[i][j] = Piece_Type.B_KNIGHT1.ordinal();
			}
			else if(j == 2) 
			{
				this.setIcon(resize(b_bishop1));
				Game_main_class.Board[i][j] = Piece_Type.B_BISHOP1.ordinal();
			}
			else if(j == 3) 
			{
				this.setIcon(resize(b_king));
				Game_main_class.Board[i][j] = Piece_Type.B_KING.ordinal();
			}
			else if(j == 4) 
			{
				this.setIcon(resize(b_queen));
				Game_main_class.Board[i][j] = Piece_Type.B_QUEEN.ordinal();
			}
			else if(j == 5) 
			{
				this.setIcon(resize(b_bishop1));
				Game_main_class.Board[i][j] = Piece_Type.B_BISHOP2.ordinal();
			}
			else if(j == 6) 
			{
				this.setIcon(resize(b_knight2));
				Game_main_class.Board[i][j] = Piece_Type.B_KNIGHT2.ordinal();
			}
			else/* if(j == 7)*/
			{
				this.setIcon(resize(b_rook1));
				Game_main_class.Board[i][j] = Piece_Type.B_ROOK2.ordinal();
			}
		}
		else 
		{
			this.setIcon(null);
			Game_main_class.Board[i][j] = Piece_Type.Blank.ordinal();
		}
	}
	static ImageIcon resize(ImageIcon img)
	{
		Image new_img = img.getImage();
		Image resized_img = new_img.getScaledInstance(84, 84, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resized_img);
	}
	/*public void loadPieces()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(j==2)
					button[i][j].setIcon(resize(b_knight1));
				else if(j==3)
					setIcon(resize(b_king));
			}
		}
	}*/
}
