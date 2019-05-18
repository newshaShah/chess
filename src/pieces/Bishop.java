package pieces;

import game.Square;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(String ID, String imagePath, String color) {
        setPieceId(ID);
        setImage(imagePath);
        setPieceColor(color);
    }

    public ArrayList<Square> move(Square[][] boardSquares, int x, int y) {
        //The java.util.ArrayList.clear() method removes all of the elements from this list.The list will be empty after this call returns.
        possibleSquares.clear();


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