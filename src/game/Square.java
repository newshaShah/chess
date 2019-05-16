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

    public Square(int x, int y){
        this.x=x;
        this.y = y;


    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        hasPiece = true;
        ImageIcon img=new ImageIcon(this.getClass().getResource(piece.getImage()));
        image=new JLabel(img);
        this.add(image);
    }

    public void selectSquare()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.red,6));
        this.isSelected=true;
    }
    public void cancleSelection(){
        this.isSelected=true;
        this.setBorder(null);
    }

    public void makePossible(){
        this.setBorder(BorderFactory.createLineBorder(Color.green,6));
        this.possibleSquare = true;
    }
    public void removePiece(){
        this.piece = null;
        this.remove(image);
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    public boolean isPossibleSquare() {
        return possibleSquare;
    }
    public Piece getPiece(){
        return piece;
    }
}
