package game;

import pieces.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * @author Newsha Shahbodaghkhan
 */

/**
 * This is my Main class GUI is performed in Main
 */


public class Main extends JFrame implements MouseListener {
    //I want to make only one instance of Mainboard
    private static Main Mainboard;
    private static Rook wr01, wr02, br01, br02;
    private static Knight wk01, wk02, bk01, bk02;
    private static Bishop wb01, wb02, bb01, bb02;
    private static Pawn[] wp;
    private static Pawn[] bp;
    private static Queen wq, bq;
    private static King wk, bk;
    //  private JButton[][] chessBoardSquares ;
    private Square[][] chessBoardSquares;

    private ArrayList<JButton> outWhitePieces;
    private int outWhitePiecesNum = 0;
    private ArrayList<JButton> outBlackPieces;
    private int outBlackPiecesNum = 0;
    private boolean select = false;
    private Square lastSquare;
    private Piece lastPiece;
    private ArrayList<Square> possibleMoves;
    private String whosTurn = "w";
    private boolean isMoved = false;
    private boolean inDanger = false;
    private JFrame myFrame;
    private JButton turn;

    private Main() {
        chessBoardSquares = new Square[8][8];
        outBlackPieces = new ArrayList<>(16);
        outWhitePieces = new ArrayList<>(16);
        myFrame = new JFrame("Chess");
        Border emptyBorder = BorderFactory.createEmptyBorder();

        myFrame.setLayout(new BorderLayout(100, 100));
        JPanel centerpanel = new JPanel();
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.BLACK);
        westPanel.setPreferredSize(new Dimension(400, 200));
        westPanel.setLayout(new BorderLayout(3, 1));


        JPanel northOfWest = new JPanel();
        northOfWest.setPreferredSize(new Dimension(400, 300));
        northOfWest.setBackground(new Color(51, 0, 0));

        northOfWest.setLayout(new GridLayout(4, 4));


        JPanel centerOfWest = new JPanel();
        centerOfWest.setPreferredSize(new Dimension(400, 100));
        centerOfWest.setBackground(new Color(153, 102, 0));
        turn = new JButton("Let's start! ");
        turn.setBorder(emptyBorder);
        turn.setBackground(new Color(153, 102, 0));
        turn.setFont(new Font("Arial", Font.PLAIN, 40));
        turn.setForeground(Color.black);
        turn.setPreferredSize(new Dimension(300, 50));
        centerOfWest.add(turn);


        JPanel southOfWest = new JPanel();
        southOfWest.setPreferredSize(new Dimension(400, 300));
        southOfWest.setBackground(new Color(51, 0, 0));
        southOfWest.setLayout(new GridLayout(4, 4));


        westPanel.add(northOfWest, BorderLayout.NORTH);
        westPanel.add(centerOfWest, BorderLayout.CENTER);
        westPanel.add(southOfWest, BorderLayout.SOUTH);

        centerpanel.setBackground(Color.black);
        JPanel eastPanel = new JPanel();


        centerpanel.setLayout(new GridLayout(8, 8));
        myFrame.add(centerpanel, BorderLayout.CENTER);
        myFrame.add(westPanel, BorderLayout.WEST);
        myFrame.add(eastPanel, BorderLayout.EAST);


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardSquares[i][j] = new Square(i, j);
                chessBoardSquares[i][j].setVisible(true);
            }
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == j % 2) {
                    chessBoardSquares[i][j].setBackground(new Color(204, 204, 204));
                }
                if (i % 2 != j % 2) {
                    chessBoardSquares[i][j].setBackground(new Color(51, 51, 51));
                }
            }
        }
        for (int i = 0; i < 16; i++) {
            outBlackPieces.add(new JButton());
            outWhitePieces.add(new JButton());
        }

        for (int i = 0; i < 16; i++) {
            //outWhitePieces.get(i)=new JButton();
            outWhitePieces.get(i).setBackground(new Color(88, 0, 0));
            //  outWhitePieces.get(i).setBorder(emptyBorder);
            northOfWest.add(outWhitePieces.get(i));
            //  outBlackPieces[i]=new JButton();
            outBlackPieces.get(i).setBackground(new Color(88, 0, 0));
            // outBlackPieces[i].setBorder(emptyBorder);
            southOfWest.add(outBlackPieces.get(i));
        }

        for (int i = 0; i < 16; i++) {
            southOfWest.add(outWhitePieces.get(i));
            northOfWest.add(outBlackPieces.get(i));
        }


        // Piece piece;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // piece = null;
                if (i == 0 && j == 0) {
                    // piece = br01;
                    chessBoardSquares[i][j].setPiece(br01);
                } else if (i == 0 && j == 7) {
                    //  piece = br02;
                    chessBoardSquares[i][j].setPiece(br02);
                } else if (i == 7 && j == 0) {
                    //piece = wr01;
                    //  P.setImage("src\\game\\White_Rook.png");
                    chessBoardSquares[i][j].setPiece(wr01);
                } else if (i == 7 && j == 7) {
                    //piece = wr02;
                    chessBoardSquares[i][j].setPiece(wr02);
                } else if (i == 0 && j == 1) {
                    //piece = bk01;
                    chessBoardSquares[i][j].setPiece(bk01);
                } else if (i == 0 && j == 6) {
                    //piece = bk02;
                    chessBoardSquares[i][j].setPiece(bk02);
                } else if (i == 7 && j == 1) {
                    //piece = wk01;
                    chessBoardSquares[i][j].setPiece(wk01);
                } else if (i == 7 && j == 6) {
                    //piece = wk02;
                    chessBoardSquares[i][j].setPiece(wk02);

                } else if (i == 0 && j == 2) {
                    //piece = bb01;
                    chessBoardSquares[i][j].setPiece(bb01);

                } else if (i == 0 && j == 5) {
                    //piece = bb02;
                    chessBoardSquares[i][j].setPiece(bb02);
                } else if (i == 7 && j == 2) {
                    //piece = wb01;
                    chessBoardSquares[i][j].setPiece(wb01);
                } else if (i == 7 && j == 5) {
                    //piece = wb02;
                    chessBoardSquares[i][j].setPiece(wb02);
                } else if (i == 0 && j == 3) {
                    //piece = bk;
                    chessBoardSquares[i][j].setPiece(bq);
                } else if (i == 0 && j == 4) {
                    //piece = bq;

                    chessBoardSquares[i][j].setPiece(bk);
                } else if (i == 7 && j == 3) {
                    //piece = wk;
                    chessBoardSquares[i][j].setPiece(wq);
                } else if (i == 7 && j == 4) {
                    //piece = wq;

                    chessBoardSquares[i][j].setPiece(wk);
                } else if (i == 1) {
                    //  piece = bp[j];
                    chessBoardSquares[1][j].setPiece(bp[j]);
                } else if (i == 6) {
                    //  piece = wp[j];
                    chessBoardSquares[6][j].setPiece(wp[j]);
                }
            }
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                centerpanel.add(chessBoardSquares[i][j]);
            }
        }
        // MouseListener mouseListener = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardSquares[i][j].addMouseListener(this);
            }
        }


        myFrame.setVisible(true);
        myFrame.setResizable(true);
        myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        // ActionListener
    }

    public static void main(String[] args) {

        // Mainboard.setVisible(true);
        wr01 = new Rook("WR01", "src\\game\\White_Rook.png", "w");

        wr02 = new Rook("WR02", "src\\game\\White_Rook.png", "w");
        br01 = new Rook("BR01", "src\\game\\Black_Rook.png", "b");
        br02 = new Rook("BR02", "src\\game\\Black_Rook.png", "b");
        wk01 = new Knight("WK01", "src\\game\\White_Knight.png", "w");
        wk02 = new Knight("WK02", "src\\game\\White_Knight.png", "w");
        bk01 = new Knight("BK01", "src\\game\\Black_Knight.png", "b");
        bk02 = new Knight("BK02", "src\\game\\Black_Knight.png", "b");
        wb01 = new Bishop("WB01", "src\\game\\White_Bishop.png", "w");
        wb02 = new Bishop("WB02", "src\\game\\White_Bishop.png", "w");
        bb01 = new Bishop("BB01", "src\\game\\Black_Bishop.png", "b");
        bb02 = new Bishop("BB02", "src\\game\\Black_Bishop.png", "b");
        wq = new Queen("WQ", "src\\game\\White_Queen.png", "w");
        bq = new Queen("BQ", "src\\game\\Black_Queen.png", "b");
        wk = new King("WK", "src\\game\\White_King.png", "w", 7, 4);
        bk = new King("BK", "src\\game\\Black_King.png", "b", 0, 4);
        wp = new Pawn[8];
        bp = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            wp[i] = new Pawn("WP0" + (i + 1), "src\\game\\White_Pawn.png", "w");
            bp[i] = new Pawn("BP0" + (i + 1), "src\\game\\Black_Pawn.png", "b");
        }
        Mainboard = new Main();
    }

    /**
     * performs changing turn of players
     */

    public void changeTurn() {
        if (whosTurn.equals("w")) whosTurn = "b";
        else whosTurn = "w";

    }
    /*
    public boolean checkmateCheck(Square [][] chessBoardSquares){

    }

     */

    /**
     *
     * @param color is the player color
     * @param board is current board
     * @return true if the player king piece is checked
     */
    private boolean isChecked(String color, Square[][] board) {
        if (color.equals("w")) return wk.isChecked(board);
        else if (color.equals("b")) return bk.isChecked(board);
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {


        inDanger = false;
        //Selecting a square
        if (!select) {
            ((Square) (e.getSource())).selectSquare();
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessBoardSquares[i][j].cancleSelection();
                }
            }
            ((Square) (e.getSource())).selectSquare();
        }
        select = true;

        // showing the possible squares of a select
        if (((Square) (e.getSource())).getPiece() != null && ((Square) (e.getSource())).getPiece().getPieceColor().equals(whosTurn)) {

            lastSquare = ((Square) (e.getSource()));
            lastPiece = ((Square) (e.getSource())).getPiece();


            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
//
                    if (chessBoardSquares[i][j].isSelected()) {
                        Piece piece = chessBoardSquares[i][j].getPiece();
                        possibleMoves = piece.move(chessBoardSquares, i, j);
                    }
                }
            }
            for (Square ps : possibleMoves) {
                ps.makePossible();

            }
        }

//moving a piece to a possible empty square


        else if (((Square) (e.getSource())).getPiece() == null) {

            if (((Square) (e.getSource())).isPossibleSquare() && ((Square) (e.getSource())).isSelected()) {


                if (lastPiece instanceof King) {
                    ((King) (lastPiece)).setx(((Square) (e.getSource())).getMyX());
                    ((King) (lastPiece)).sety(((Square) (e.getSource())).getMyY());
                }
                ((Square) (e.getSource())).setPiece(lastPiece);


                // lastSquare.removePiece();
                isMoved = true;

                chessBoardSquares[lastSquare.getMyX()][lastSquare.getMyY()].removePiece();
                if (isChecked(whosTurn, chessBoardSquares)) {
                    isMoved = false;
                    inDanger = true;
                    ((Square) (e.getSource())).removePiece();
                    chessBoardSquares[lastSquare.getMyX()][lastSquare.getMyY()].setPiece(lastPiece);
                    if (lastPiece instanceof King) {
                        ((King) (lastPiece)).setx(lastSquare.getMyX());
                        ((King) (lastPiece)).sety(lastSquare.getMyY());
                    }

                }


            }

        }
        //zadan mohreh ba rng mokhalef
        else if (!((Square) (e.getSource())).getPiece().getPieceColor().equals(whosTurn)) {

            if (((Square) (e.getSource())).isPossibleSquare() && ((Square) (e.getSource())).isSelected()) {

                if (!(((Square) (e.getSource())).getPiece() instanceof King)) {
                    Piece piece = ((Square) (e.getSource())).getPiece();
                    JLabel imageIcon = new JLabel(new ImageIcon(piece.getImage()));
                    if (piece.getPieceColor().equals("w")) {
                        outWhitePieces.get(outWhitePiecesNum).add(imageIcon);
                        outWhitePiecesNum++;
                    } else {
                        outBlackPieces.get(outBlackPiecesNum).add(imageIcon);
                        outBlackPiecesNum++;
                    }

                    ((Square) (e.getSource())).removePiece();


                    if (lastPiece instanceof King) {
                        ((King) lastPiece).setx(((Square) (e.getSource())).getMyX());
                        ((King) lastPiece).sety(((Square) (e.getSource())).getMyY());
                    }
                    ((Square) (e.getSource())).setPiece(lastPiece);

                    isMoved = true;

                    chessBoardSquares[lastSquare.getMyX()][lastSquare.getMyY()].removePiece();
                    if (isChecked(whosTurn, chessBoardSquares)) {
                        isMoved = false;
                        inDanger = true;
                        if (lastPiece instanceof King) {
                            ((King) lastPiece).setx(lastSquare.getMyX());
                            ((King) lastPiece).sety(lastSquare.getMyY());
                        }
                        ((Square) (e.getSource())).removePiece();
                        ((Square) (e.getSource())).setPiece(piece);
                        lastSquare.setPiece(lastPiece);
                        if (piece.getPieceColor().equals("w")) {


                            outWhitePiecesNum--;
                            outWhitePieces.get(outWhitePiecesNum).remove(imageIcon);

                            outWhitePieces.remove(piece);
                        } else if (piece.getPieceColor().equals("b")) {


                            outBlackPiecesNum--;
                            outBlackPieces.get(outBlackPiecesNum).remove(imageIcon);
                            outBlackPieces.remove(piece);
                        }

                    }
                }
            }

        }

        if (isMoved) {
            changeTurn();
            possibleMoves.clear();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessBoardSquares[i][j].canclePossibility();
                }
            }
            isMoved = false;
        }

        if (wk.isChecked(chessBoardSquares)) {
            turn.setBackground(Color.red);
            turn.setFont(new Font("Arial", Font.PLAIN, 25));
            turn.setText("White King is checked!");
            turn.setForeground(Color.BLACK);
        } else if (bk.isChecked(chessBoardSquares)) {
            turn.setBackground(Color.red);
            turn.setFont(new Font("Arial", Font.PLAIN, 25));
            turn.setForeground(Color.BLACK);
            turn.setText("Black King is checked!");
        } else if (inDanger) {
            if (whosTurn.equals("w")) {
                turn.setFont(new Font("Arial", Font.PLAIN, 25));
                turn.setText("White King is in danger!");
                // inDanger = false;
            } else if (whosTurn.equals("b")) {
                turn.setFont(new Font("Arial", Font.PLAIN, 25));
                turn.setBackground(Color.BLACK);
                turn.setText("Black King is in danger!");
                // inDanger = false;
            }

        } else {
            turn.setText("It's your turn! ");
            turn.setForeground(Color.GRAY);
            if (whosTurn.equals("w")) turn.setBackground(Color.white);
            else turn.setBackground(Color.BLACK);
        }


    }


    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

}
