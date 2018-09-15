/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
package chess_Game;

//import java.awt.Graphics;
import java.awt.Image;
//import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pieces_btn extends JButton
{	
	int x,y;
	ImageIcon b_king,b_queen,b_bishop1,b_bishop2,b_knight1,b_knight2,b_rook1,b_rook2;
	ImageIcon b_pawn1,b_pawn2,b_pawn3,b_pawn4,b_pawn5,b_pawn6,b_pawn7,b_pawn8;
	ImageIcon w_king,w_queen,w_bishop1,w_bishop2,w_knight1,w_knight2,w_rook1,w_rook2;
	ImageIcon w_pawn1,w_pawn2,w_pawn3,w_pawn4,w_pawn5,w_pawn6,w_pawn7,w_pawn8;
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
				this.setIcon(resize(w_rook1));
			else if(j == 1)
				this.setIcon(resize(w_knight1));
			else if(j == 2)
				this.setIcon(resize(w_bishop1));
			else if(j == 3)
				this.setIcon(resize(w_king));
			else if(j == 4)
				this.setIcon(resize(w_queen));
			else if(j == 5)
				this.setIcon(resize(w_bishop1));
			else if(j == 6)
				this.setIcon(resize(w_knight2));
			else/* if(j == 7)*/
				this.setIcon(resize(w_rook1));
				
		}
		else if(i == 1)
		{
			this.setIcon(resize(w_pawn1));
			//this.setIcon(resize(b_king));
		}
		else if(i == 6)
			this.setIcon(resize(b_pawn1));
		else if(i == 7)
		{
			if(j==0)
				this.setIcon(resize(b_rook1));
			else if(j == 1)
				this.setIcon(resize(b_knight1));
			else if(j == 2)
				this.setIcon(resize(b_bishop1));
			else if(j == 3)
				this.setIcon(resize(b_king));
			else if(j == 4)
				this.setIcon(resize(b_queen));
			else if(j == 5)
				this.setIcon(resize(b_bishop1));
			else if(j == 6)
				this.setIcon(resize(b_knight2));
			else/* if(j == 7)*/
				this.setIcon(resize(b_rook1));
		}
		else
			this.setIcon(null);
	}
	ImageIcon resize(ImageIcon img)
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
