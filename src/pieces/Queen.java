package pieces;

import game.Square;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(String ID,String imagePath,String color){
        setPieceId(ID);
        setImage( imagePath);
        setPieceColor(color);
    }
    public ArrayList<Square> move(Square [][] boardSquares, int x, int y) {
        //The java.util.ArrayList.clear() method removes all of the elements from this list.The list will be empty after this call returns.
        possibleSquares.clear();
        int tempx = x - 1;
        while (tempx >= 0) {
            if (boardSquares[tempx][y].getPiece() == null)
                possibleSquares.add(boardSquares[tempx][y]);
            else if (boardSquares[tempx][y].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[tempx][y]);
                break;
            }
            tempx--;
        }

        tempx = x + 1;
        while (tempx < 8) {
            if (boardSquares[tempx][y].getPiece() == null)
                possibleSquares.add(boardSquares[tempx][y]);
            else if (boardSquares[tempx][y].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[tempx][y]);
                break;
            }
            tempx++;
        }



        int tempy = y - 1;
        while (tempy >= 0) {
            if (boardSquares[x][tempy].getPiece() == null)
                possibleSquares.add(boardSquares[x][tempy]);
            else if (boardSquares[x][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[x][tempy]);
                break;
            }
            tempy--;
        }
        tempy = y + 1;
        while (tempy < 8) {
            if (boardSquares[x][tempy].getPiece() == null)
                possibleSquares.add(boardSquares[x][tempy]);
            else if (boardSquares[x][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[x][tempy]);
                break;
            }
            tempy++;
        }


        tempx = x + 1;
        tempy = y - 1;
        while (tempx < 8 && tempy >= 0) {
            if (boardSquares[tempx][tempy].getPiece() == null)
                possibleSquares.add(boardSquares[tempx][tempy]);
            else if (boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx++;
            tempy--;
        }
        tempx = x - 1;
        tempy = y + 1;

        while (tempx >= 0 && tempy < 8) {
            if (boardSquares[tempx][tempy].getPiece() == null)
                possibleSquares.add(boardSquares[tempx][tempy]);
            else if (boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx--;
            tempy++;
        }
        tempx = x - 1;
        tempy = y - 1;
        while (tempx >= 0 && tempy >= 0) {
            if (boardSquares[tempx][tempy].getPiece() == null)
                possibleSquares.add(boardSquares[tempx][tempy]);
            else if (boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx--;
            tempy--;
        }
        tempx = x + 1;
        tempy = y + 1;
        while (tempx < 8 && tempy < 8) {
            if (boardSquares[tempx][tempy].getPiece() == null)
                possibleSquares.add(boardSquares[tempx][tempy]);
            else if (boardSquares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else {
                possibleSquares.add(boardSquares[tempx][tempy]);
                break;
            }
            tempx++;
            tempy++;
        }
        return possibleSquares;
    }
}
