package Game_logical;

public class BISHOP extends Piece {
	// Piece_Type type;
	String turn;
	
	
	public BISHOP(int x, int y, int piece_in_button_id, String turn) {
		super(x, y, piece_in_button_id);
		// type = piece_name;
		this.turn = turn; // Keeps track of currently whose turn is going on
	}
	
	boolean upRight(int dest_x,int dest_y)
	{
		int i,j;
		i = dest_x + 1;
		j = dest_y - 1;
		while(i < x_pos && j > y_pos)/////////////////
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
		while(i > x_pos && j > y_pos)/////////////////
		{
			if(Game_main_class.Board[i][j] != 0)
				return true;     // Path is blocked
			i--;
			j--;
		}
		return false;////////////
	}
	
	boolean upLeft(int dest_x,int dest_y)
	{
		int i,j;
		i = dest_x + 1;
		j = dest_y + 1;
		while(i < x_pos && j < y_pos)/////////////////
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
		while(i > x_pos && j < y_pos)/////////////////
		{
			if(Game_main_class.Board[i][j] != 0)
				return true;     // Path is blocked
			i--;
			j++;
		}
		return false; // Path is not blocked
	}
	
	boolean isValidPath(int dest_x, int dest_y)
	{
		int x_distance = Math.abs(dest_x - x_pos); // row distance
		int y_distance = Math.abs(dest_y - y_pos); // column distance

		System.out.println("x = " + x_pos + "y = " + y_pos);
		System.out.println("x dist = " + x_distance + "y dist = " + y_distance);
		System.out.println("x dest = " + dest_x + " y dest = " + dest_y);

		if ((x_distance == y_distance) && (x_distance != 0))
		{
			if(turn == "white" && piece_id <= 16)
			{
				if((dest_x < x_pos && dest_y > y_pos && upRight(dest_x, dest_y) == false) || (dest_x < x_pos && dest_y < y_pos && upLeft(dest_x, dest_y) == false) ||
						(dest_x > x_pos && dest_y < y_pos && downLeft(dest_x, dest_y) == false) || (dest_x > x_pos && dest_y > y_pos && downRight(dest_x, dest_y) == false))
				{
					if(Game_main_class.Board[dest_x][dest_y] > 16)
					{
						return true;
					}
					else if( Game_main_class.Board[dest_x][dest_y]  == 0)
					{
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
					if(Game_main_class.Board[dest_x][dest_y] <= 16)
					{
						return true;
					}
					else if( Game_main_class.Board[dest_x][dest_y]  == 0)
					{
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
	public boolean[][] drawPath()
	{
		// For testing
		Game_main_class.Board[2][0] = 30;
		Game_main_class.Board[1][1] = 0;
		Game_main_class.Board[1][3] = 0;
		Game_main_class.Board[4][6] = 2;
		Game_main_class.Board[5][7] = 20;
		
		
		
		boolean path[][] = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				path[i][j] = isValidPath(i,j);
			}
		}
			

		// ------------------------------------------------------------------------------
		// For testing purpose only
		/*
		//Game_main_class.Board[4][2] = 30;
		path[3][1] = isValidPath(3,1);
		path[2][0] = isValidPath(2,0);
		path[2][4] = isValidPath(2,4);
		//path[4][2] = isValidPath(4,2);
		path[5][7] = isValidPath(5,7);*/
		
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
		return null;           // modify this line
	}

	
}
