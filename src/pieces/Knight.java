package pieces;

import game.Square;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author Newsha Shahbodaghkhan
 *Bishop class show the Knight's moves that moves and set its ID imagePath and color
 */

public class Knight extends Piece {
    /**
     *
     * @param ID set ID of Knight
     * @param imagePath set image of Knight
     * @param color set color of Knight
     */
    public Knight(String ID, String imagePath, String color) {
        setPieceId(ID);
        setImage(imagePath);
        setPieceColor(color);
    }
    @Override
    /**
     * @param boardSquare is the current board situation
     * @param x is the x of Knight in board
     * @param y is the y of Knight in board
     * @return arraylist of next possible squares of Knight
     */
    public ArrayList<Square> move(Square [][] boardSquares, int x, int y) {
        ArrayList<Square> possibleSquares=new ArrayList<>();
        //possibleSquares.clear();
        int posx[] = {x + 1, x + 1, x + 2, x + 2, x - 1, x - 1, x - 2, x - 2};
        int posy[] = {y - 2, y + 2, y - 1, y + 1, y - 2, y + 2, y - 1, y + 1};
        for (int i = 0; i < 8; i++)
            if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8))
                if ((boardSquares[posx[i]][posy[i]].getPiece() == null || !boardSquares[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor()))) {
                    possibleSquares.add(boardSquares[posx[i]][posy[i]]);
                }



    return possibleSquares;
    }
}
