package pieces;

import game.Square;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(String ID, String imagePath, String color) {
        setPieceId(ID);
        setImage(imagePath);
        setPieceColor(color);
    }
    public ArrayList<Square> move(Square [][] boardSquares, int x, int y) {
        possibleSquares.clear();
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
