package pieces;

import game.Square;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Newsha Shahbodaghkhan
 *Bishop class show the Bishop's moves that moves and set its ID imagePath and color
 */

public class Bishop extends Piece {
    //constructor

    /**
     *
     * @param ID set ID of bishop
     * @param imagePath set image of bishop
     * @param color set color of bishop
     */
    public Bishop(String ID, String imagePath, String color) {
        setPieceId(ID);
        setImage(imagePath);
        setPieceColor(color);
    }
@Override

/**
 * @param boardSquare is the current board situation
 * @param x is the x of bishop in board
 * @param y is the y of bishop in board
 * @return arraylist of next possible squares of bishop
 */
    public ArrayList<Square> move(Square[][] boardSquares, int x, int y) {
        //The java.util.ArrayList.clear() method removes all of the elements from this list.The list will be empty after this call returns.
    ArrayList<Square> possibleSquares=new ArrayList<>();



        int tempx=x+1,tempy=y-1;
        while(tempx<8&&tempy>=0)
        {
            if(boardSquares[tempx][tempy].getPiece()==null)
            {
                possibleSquares.add(boardSquares[tempx][tempy]);
            }
            else if(boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx++;
            tempy--;
        }
        tempx=x-1;tempy=y+1;
        while(tempx>=0&&tempy<8)
        {
            if(boardSquares[tempx][tempy].getPiece()==null)
                possibleSquares.add(boardSquares[tempx][tempy]);
            else if(boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx--;
            tempy++;
        }
        tempx=x-1;tempy=y-1;
        while(tempx>=0&&tempy>=0)
        {
            if(boardSquares[tempx][tempy].getPiece()==null)
                possibleSquares.add(boardSquares[tempx][tempy]);
            else if(boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx--;
            tempy--;
        }
        tempx=x+1;tempy=y+1;
        while(tempx<8&&tempy<8)
        {
            if(boardSquares[tempx][tempy].getPiece()==null)
                possibleSquares.add(boardSquares[tempx][tempy]);
            else if(boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx++;
            tempy++;
        }



        return possibleSquares;
    }
}