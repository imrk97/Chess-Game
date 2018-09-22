//created by imrk97

package Game_logical;

import chess_Game.*;

public class ROOK extends Piece {
	Piece_Type type;
	String turn;

	ROOK(int x, int y, int piece_in_button_id, String turn) {
		super(x, y, piece_in_button_id);
		// type=Piece_Type.Rook;
		this.turn = turn;
	}

	boolean isValidPath(int dest_x, int dest_y) {
		int x_distance = Math.abs(dest_x - x_pos); // row distance
		int y_distance = Math.abs(dest_y - y_pos); // column distance

		System.out.println("x = " + x_pos + "\ny = " + y_pos);
		System.out.println("x dist = " + x_distance + "y dist = " + y_distance);
		System.out.println("x dest = " + dest_x + " y dest = " + dest_y);
		// horizontal moving
		if ((x_distance >= 1 || x_distance <= 7) && y_distance == 0 && dest_x < 8 && dest_x > -1
				&& Game_main_class.Board[dest_x][dest_y] == 0) {
			if (turn == "black" && piece_id == 1 && piece_id == 8) {
				return true;
			} else if (turn == "white" && piece_id == 17 && piece_id <= 24) {
				return true;
			} else {
				System.out.println("ROOK horizontal\n");
				return false;
			}

		}
		// vertical moving
		else if ((y_distance >= 1 || y_distance <= 7) && x_distance == 0 && dest_x < 8 && dest_x > -1
				&& Game_main_class.Board[dest_x][dest_y] == 0) {
		}
		if (turn == "black" && piece_id == 1 && piece_id == 8) {
			return true;
		} else if (turn == "white" && piece_id == 17 && piece_id <= 24) {
			return true;
		} else {
			System.out.println("ROOK Vertical\n");
			return false;
		}

	}

	public boolean[][] drawPath() {
		boolean path[][] = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				path[i][j] = false;// path[i][j] = isValidPath(i,j);
			}
		}
		// For testing purpose only

		Game_main_class.Board[2][1] = 18;
		path[2][1] = isValidPath(2, 1);
		path[2][0] = isValidPath(2, 0);
		path[3][0] = isValidPath(3, 0);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
		return path;
	}

}
