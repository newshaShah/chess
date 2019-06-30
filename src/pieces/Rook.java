package pieces;

import game.Square;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  @author Newsha Shahbodaghkhan
 *  *King class show the Rook's moves that moves and set its ID imagePath and color
 */
public class Rook extends Piece {
    /**
     *
     * @param ID set ID of Rook
     * @param imagePath set image of Rook
     * @param color set color of Rook
     */
    public Rook(String ID,String imagePath,String color){
        setPieceId(ID);
        setImage( imagePath);
        setPieceColor(color);
    }
    @Override
    /**
     * @param boardSquare is the current board situation
     * @param x is the x of Rook in board
     * @param y is the y of Rook in board
     * @return arraylist of next possible squares of Rook
     */
    public ArrayList<Square> move(Square [][] boardSquares, int x, int y){
        //The java.util.ArrayList.clear() method removes all of the elements from this list.The list will be empty after this call returns.
        ArrayList<Square> possibleSquares=new ArrayList<>();


        int tempx=x-1;
        while(tempx>=0)
        {
            if(boardSquares[tempx][y].getPiece()==null)
                possibleSquares.add(boardSquares[tempx][y]);
            else if(boardSquares[tempx][y].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[tempx][y]);
                break;
            }
            tempx--;
        }
        tempx=x+1;
        while(tempx<8)
        {
            if(boardSquares[tempx][y].getPiece()==null)
                possibleSquares.add(boardSquares[tempx][y]);
            else if(boardSquares[tempx][y].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[tempx][y]);
                break;
            }
            tempx++;
        }
        int tempy=y-1;
        while(tempy>=0)
        {
            if(boardSquares[x][tempy].getPiece()==null)
                possibleSquares.add(boardSquares[x][tempy]);
            else if(boardSquares[x][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[x][tempy]);
                break;
            }
            tempy--;
        }
        tempy=y+1;
        while(tempy<8)
        {
            if(boardSquares[x][tempy].getPiece()==null)
                possibleSquares.add(boardSquares[x][tempy]);
            else if(boardSquares[x][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                possibleSquares.add(boardSquares[x][tempy]);
                break;
            }
            tempy++;
        }




        return possibleSquares;
    }
}
