/**
 * Created by Rahul on 16-Oct-2018
 * 
 */

/**
 * @author Payel
 *
 */
package chess_Game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Dead_pieces
{
	private static int w_row = 0;
	private static int w_col = 1;
	private static int b_row = 0;
	private static int b_col = 0;
	
	static void Dead_piece_place(String turn,ImageIcon img)
	{
		if(turn == "black")     //  Black piece cuts a white piece
		{
			if(w_row == 8)
			{
				w_row = 0;
				w_col = 0;
			}
			Chess_Board.lbl1[w_row][w_col].setOpaque(true);
			Chess_Board.lbl1[w_row][w_col].setBackground(Color.BLACK);
			Chess_Board.lbl1[w_row][w_col].setIcon(img);
			w_row++;
		}
		else                    //  White piece cuts a black piece
		{
			if(b_row == 8)
			{
				b_row = 0;
				b_col = 1;
			}
			Chess_Board.lbl2[b_row][b_col].setOpaque(true);
			Chess_Board.lbl2[b_row][b_col].setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
			Chess_Board.lbl2[b_row][b_col].setBackground(Color.WHITE);
			Chess_Board.lbl2[b_row][b_col].setIcon(img);
			b_row++;
		}
	}
}
