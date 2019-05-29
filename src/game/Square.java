package game;

import pieces.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * A chess board has 64 squares on a square might exist a piece or not
 */
public class Square extends JButton {

    private int x;
    private int y;
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

    public int getMyX() {
        return x;
    }

    public int getMyY(){
        return y;
    }

    public JLabel getImage() {
        return image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }

    public Square(int x, int y, Piece piece){
        this.x=x;
        this.y = y;
        this.piece=piece;

    }

    /**
     *
     * @param piece put a piece on a chess square
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
        hasPiece = true;
//        ImageIcon img=new ImageIcon(this.getClass().getResource(piece.getImage()));
//        image=new JLabel(img);
      //  JLabel imgLabel = new JLabel(new ImageIcon(piece.getImage()));
        image= new JLabel(new ImageIcon(piece.getImage()));
        this.add(image);
       // this.add(image);
    }

    /**
     * selects a square by redrawing its line border
     */
    public void selectSquare()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.red,6));
        this.isSelected=true;
    }

    public boolean isSelected(){
        return isSelected;
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

    protected void canclePossibility(){
        this.possibleSquare=false;
    }

    /**
     * removes a piece of a square
     */
    public void removePiece(){
        this.piece = null;
        this.remove(image);
//        this.remove(this.piece);
//        this.remove(image);
//        this.setImage(null);
       // this.remove(new JLabel(new ImageIcon(null));
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
