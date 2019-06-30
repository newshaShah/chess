package pieces;

import game.Square;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *  @author Newsha Shahbodaghkhan
 *  *King class show the Pawn's moves that moves and set its ID imagePath and color
 */

public class Pawn extends Piece {

    /**
     *
     * @param ID set ID of Pawn
     * @param imagePath set image of Pawn
     * @param color set color of Pawn
     */
    public Pawn(String ID,String imagePath,String color){
        setPieceId(ID);
        setImage( imagePath);
        setPieceColor(color);

    }
    @Override
    /**
     * @param boardSquare is the current board situation
     * @param x is the x of Pawn in board
     * @param y is the y of Pawn in board
     * @return arraylist of next possible squares of Pawn
     */
    public ArrayList<Square> move(Square [][] boardSquares, int x, int y)  {
        //The java.util.ArrayList.clear() method removes all of the elements from this list.The list will be empty after this call returns.
       // possibleSquares.clear();
        ArrayList<Square> possibleSquares=new ArrayList<>();

        if(getPieceColor().equals("w")){
            if(x==0){
                return possibleSquares;
            }
            if(boardSquares[x-1][y].getPiece()==null) {
                possibleSquares.add(boardSquares[x - 1][y]);
                if (x == 6) {
                    if (boardSquares[4][y].getPiece() == null)
                        possibleSquares.add(boardSquares[4][y]);
                }
            }
            if ((y > 0) && (boardSquares[x - 1][y - 1].getPiece() != null) && (!boardSquares[x - 1][y - 1].getPiece().getPieceColor().equals(this.getPieceColor())))
                possibleSquares.add(boardSquares[x - 1][y - 1]);
            if ((y < 7) && (boardSquares[x - 1][y + 1].getPiece() != null) && (!boardSquares[x - 1][y + 1].getPiece().getPieceColor().equals(this.getPieceColor())))
                possibleSquares.add(boardSquares[x - 1][y + 1]);
        }
        else if(getPieceColor().equals("b")) {
            if (x == 8)
                return possibleSquares;
            if (boardSquares[x + 1][y].getPiece() == null) {
                possibleSquares.add(boardSquares[x + 1][y]);
                if (x == 1) {
                    if (boardSquares[3][y].getPiece() == null)
                        possibleSquares.add(boardSquares[3][y]);
                }
            }
            if ((y > 0) && (boardSquares[x + 1][y - 1].getPiece() != null) && (!boardSquares[x + 1][y - 1].getPiece().getPieceColor().equals(this.getPieceColor())))
                possibleSquares.add(boardSquares[x + 1][y - 1]);
            if ((y < 7) && (boardSquares[x + 1][y + 1].getPiece() != null) && (!boardSquares[x + 1][y + 1].getPiece().getPieceColor().equals(this.getPieceColor())))
                possibleSquares.add(boardSquares[x + 1][y + 1]);
        }


        return possibleSquares;

    }

//    @Override
//    public ArrayList<Square> move() {
//        return null;
//    }
}
