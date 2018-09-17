//created by imrk97

package Game_logical;
import chess_Game.*;
public class ROOK extends Piece {
	Piece_Type type;
	ROOK(int x,int y,Player player){
		super(x,y,player);
		type=Piece_Type.Rook;
		
	}
	boolean isValidPath(int dest_x,int dest_y) {
		
	}
}
