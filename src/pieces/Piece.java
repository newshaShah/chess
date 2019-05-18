package pieces;

import game.Square;

import java.util.ArrayList;

/**
 * Piece is an abstract class which means that it cannot be instantiated
 *Rook, Knight, Queen, King and Pawn are subclasses of Piece
 */
public abstract class Piece {
private String pieceId;
private String pieceColor;
private String imagePath;


//possibleSquares is protected in Piece class therefore subclasses have access to it
//for all subclasses used one arrayList and before using it in each class content will be cleared

protected ArrayList<Square> possibleSquares = new ArrayList<>();



    public void setImage(String image) {
        imagePath = image;
    }

    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }

    public void setPieceId(String pieceId) {
        this.pieceId = pieceId;
    }

    public String getPieceColor() {
        return pieceColor;
    }

    public String getPieceId() {
        return pieceId;
    }

    public String getImage() {
        return imagePath;
    }
}
