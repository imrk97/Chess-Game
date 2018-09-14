/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
package chess_Game;

import javax.swing.JFrame;
import javax.swing.JPanel;



import Game_logical.BISHOP;
import Game_logical.Game_main_class;
import Game_logical.KNIGHT;
import Game_logical.PAWN;
import Game_logical.Piece;
import Game_logical.Player;
import Game_logical.ROOK;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chess_Board extends JFrame implements ActionListener
{
	JFrame window = new JFrame();
	JPanel p = new JPanel();
	Pieces_btn button[][] = new Pieces_btn[8][8];
	/*public static void main(String args[])
	{
		new Chess_Board();
	}*/
	public Chess_Board()
	{
		super("Chess Game");
		//pack();
		setSize(700,700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		window.setLocation(75,5);
		window.add(p);
		window.setSize(1032,720);
		window.setVisible(true);
		setResizable(false);
		p.setLocation(75, 5);
		p.setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(8,8,2,2));
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				button[i][j]=new Pieces_btn(i,j);
				button[i][j].addActionListener(this);
				if((i+j) % 2 == 0)
					button[i][j].setBackground(new Color(255,229,181));
				else
					button[i][j].setBackground(new Color(176,100,43));
				p.add(button[i][j]);
			}
		}
		/*this.getContentPane().*/add(p);
		
		setVisible(true);
	}
	
	//Override
	public void actionPerformed(ActionEvent e)
	{
		int piece_in_button;
		Piece_Type arr[] = Piece_Type.values();
		String turn;
		Player pl_obj = new Player();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(e.getSource() == button[i][j])
				{
					System.out.println("i="+i+"j="+j);
					
					piece_in_button = Game_main_class.Board[i][j];
					turn = pl_obj.nowTurn();
					if(piece_in_button == 9)
					{
						// For testing purpose only
						
						
						PAWN pawn = new PAWN(i,j,piece_in_button,turn);
						pawn.drawPath();
						System.out.println("Pressed 1");
					}
					else if(piece_in_button == 2)
					{
						KNIGHT knight = new KNIGHT(i,j,piece_in_button,turn);
						knight.drawPath();
						System.out.println("Knight pressed");
					}
					else if(piece_in_button == 3)
					{
						BISHOP bishop = new BISHOP(i,j,piece_in_button,turn);
						bishop.drawPath();
						
						System.out.println("Bishop pressed");
					}
					else if(piece_in_button == 8)
					{
						ROOK rook = new ROOK(i,j,piece_in_button,turn);
						rook.drawPath();
						
						System.out.println("Rook pressed");
					}
				}
			}
		}
		//System.out.println("Button clicked "+e.getActionCommand());
	}
}








