package pieces;

/**
 * Piece is an abstract class which means that it cannot be instantiated
 *Rook, Knight, Queen, King and Pawn are subclasses of Piece
 */
public abstract class Piece {
private String pieceId;
private String pieceColor;
private String imagePath;


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
