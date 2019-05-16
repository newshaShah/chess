package game;

import pieces.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * A chess board has 64 squares on a square might exist a piece or not
 */
public class Square extends JButton {

    int x;
    int y;
    private Piece piece;
    private boolean isSelected = false;
    private boolean hasPiece = false;
    private JLabel image;
    private boolean possibleSquare = false;

    /**
     *
     * @param x x coordinate of square
     * @param y y coordinate of square
     */
    public Square(int x, int y){
        this.x=x;
        this.y = y;


    }

    /**
     *
     * @param piece put a piece on a chess square
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
        hasPiece = true;
        ImageIcon img=new ImageIcon(this.getClass().getResource(piece.getImage()));
        image=new JLabel(img);
        this.add(image);
    }

    /**
     * selects a square by redrawing its line border
     */
    public void selectSquare()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.red,6));
        this.isSelected=true;
    }

    /**
     * deselects a square by deleting its red border line
     */
    public void cancleSelection(){
        this.isSelected=false;
        this.setBorder(null);
    }

    /**
     * makes a square possible for moving a piece by making its border line green
     */
    public void makePossible(){
        this.setBorder(BorderFactory.createLineBorder(Color.green,6));
        this.possibleSquare = true;
    }

    /**
     * removes a piece of a square
     */
    public void removePiece(){
        this.piece = null;
        this.remove(image);
    }

    /**
     *
     * @return true if this square has a piece
     */
    public boolean hasPiece() {
        return hasPiece;
    }

    /**
     * @return true if square is possible for moving a piece
     */
    public boolean isPossibleSquare() {
        return possibleSquare;
    }

    /**
     *
     * @return the piece of a square
     */
    public Piece getPiece(){
        return piece;
    }
}
