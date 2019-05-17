package game;

import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Newsha Shahbodaghkhan
 */

/**
 * This is my Main class GUI is performed in Main
 */



public class Main extends JFrame implements MouseListener{
//I want to make only one instance of Mainboard
    private static Main Mainboard;
  //  private JButton[][] chessBoardSquares ;
    private Square [][] chessBoardSquares;
   private JFrame myFrame;
    private static Rook wr01,wr02,br01,br02;
    private static Knight wk01,wk02,bk01,bk02;
    private static Bishop wb01,wb02,bb01,bb02;
    private static Pawn wp[],bp[];
    private static Queen wq,bq;
    private static King wk,bk;

public static void main(String[] args) {

   // Mainboard.setVisible(true);
    wr01=new Rook("WR01", "src\\game\\White_Rook.png","w");

    wr02=new Rook("WR02", "src\\game\\White_Rook.png","w");
    br01=new Rook("BR01", "src\\game\\Black_Rook.png","b");
    br02=new Rook("BR02", "src\\game\\Black_Rook.png","b");
    wk01=new Knight("WK01", "src\\game\\White_Knight.png","w");
    wk02=new Knight("WK02", "src\\game\\White_Knight.png","w");
    bk01=new Knight("BK01", "src\\game\\Black_Knight.png","b");
    bk02=new Knight("BK02", "src\\game\\Black_Knight.png","b");
    wb01=new Bishop("WB01", "src\\game\\White_Bishop.png","w");
    wb02=new Bishop("WB02", "src\\game\\White_Bishop.png","w");
    bb01=new Bishop("BB01", "src\\game\\Black_Bishop.png","b");
    bb02=new Bishop("BB02", "src\\game\\Black_Bishop.png","b");
    wq=new Queen("WQ", "src\\game\\White_Queen.png","w");
    bq=new Queen("BQ", "src\\game\\Black_Queen.png","b");
    wk=new King("WK", "src\\game\\White_King.png","w",7,3);
    bk=new King("BK", "src\\game\\Black_King.png","b",0,3);
    wp=new Pawn[8];
    bp=new Pawn[8];
    for(int i=0;i<8;i++)
    {
        wp[i]=new Pawn("WP0"+(i+1), "src\\game\\White_Pawn.png","w");
        bp[i]=new Pawn("BP0"+(i+1), "src\\game\\Black_Pawn.png","b");
    }
    Mainboard = new Main();
}


private Main() {
    chessBoardSquares = new Square[8][8];
    myFrame = new JFrame("Chess");

    myFrame.setLayout(new BorderLayout(100, 100));
    JPanel centerpanel = new JPanel();
    JPanel westPanel = new JPanel();
    westPanel.setBackground(Color.BLACK);
    westPanel.setPreferredSize(new Dimension(400, 30));
    westPanel.setLayout(new BorderLayout(3, 1));

    JPanel northOfWest = new JPanel();
    northOfWest.setPreferredSize(new Dimension(400, 100));
    northOfWest.setBackground(new Color(51, 0, 0));

    JPanel centerOfWest = new JPanel();
    centerOfWest.setPreferredSize(new Dimension(400, 100));
    centerOfWest.setBackground(new Color(153, 102, 0));

    JPanel southOfWest = new JPanel();
    southOfWest.setPreferredSize(new Dimension(400, 100));
    southOfWest.setBackground(new Color(51, 0, 0));


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


   // Piece piece;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
           // piece = null;
            if (i == 0 && j == 0) {
                // piece = br01;
                chessBoardSquares[i][j].setPiece(br01);
            }
            else if (i == 0 && j == 7) {
              //  piece = br02;
                chessBoardSquares[i][j].setPiece(br02);
            }
            else if (i == 7 && j == 0) {
                //piece = wr01;
             //  P.setImage("src\\game\\White_Rook.png");
                chessBoardSquares[i][j].setPiece(wr01);
            }
            else if (i == 7 && j == 7) {
                //piece = wr02;
                chessBoardSquares[i][j].setPiece(wr02);
            }
            else if (i == 0 && j == 1) {
                //piece = bk01;
                chessBoardSquares[i][j].setPiece(bk01);
            }
            else if (i == 0 && j == 6) {
                //piece = bk02;
                chessBoardSquares[i][j].setPiece(bk02);
            }
            else if (i == 7 && j == 1) {
                //piece = wk01;
                chessBoardSquares[i][j].setPiece(wk01);
            }
            else if (i == 7 && j == 6) {
                //piece = wk02;
                chessBoardSquares[i][j].setPiece(wk02);

            }
            else if (i == 0 && j == 2) {
                //piece = bb01;
                chessBoardSquares[i][j].setPiece(bb01);

            }
            else if (i == 0 && j == 5) {
                //piece = bb02;
                chessBoardSquares[i][j].setPiece(bb02);
            }
            else if (i == 7 && j == 2) {
                //piece = wb01;
                chessBoardSquares[i][j].setPiece(wb01);
            }
            else if (i == 7 && j == 5) {
                //piece = wb02;
                chessBoardSquares[i][j].setPiece(wb02);
            }
            else if (i == 0 && j == 3) {
                //piece = bk;
                chessBoardSquares[i][j].setPiece(bk);
            }
            else if (i == 0 && j == 4) {
                //piece = bq;
                chessBoardSquares[i][j].setPiece(bq);
            }
            else if (i == 7 && j == 3) {
                //piece = wk;
                chessBoardSquares[i][j].setPiece(wk);
            }
            else if (i == 7 && j == 4) {
                //piece = wq;
                chessBoardSquares[i][j].setPiece(wq);
            }
            else if (i == 1) {
              //  piece = bp[j];
                chessBoardSquares[1][j].setPiece(bp[j]);
            }
            else if (i == 6) {
              //  piece = wp[j];
                chessBoardSquares[6][j].setPiece(wp[j]);
            }
//         Square square = new Square(i, j, P);
//           square.setPiece(P);
          //  piece= wr02;
      //      assert P != null;
           // piece=new Rook("1","src\\\\game\\\\White_Rook.png","w");

           // chessBoardSquares[i][j].setPiece(piece);
        }
    }

//chessBoardSquares[0][0].selectSquare();
    //ImageIcon img = Black_Rook.png;
    //JLabel imgLabel = new JLabel(new ImageIcon("Black_Rook.png"));
    chessBoardSquares[0][0].add(new JLabel(new ImageIcon("src\\game\\Black_Rook.png")));
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            centerpanel.add(chessBoardSquares[i][j]);
        }
    }

            myFrame.setVisible(true);
    myFrame.setResizable(true);
            myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        }
    @Override
    public void mouseClicked (MouseEvent e){

    }
    @Override
    public void mouseEntered (MouseEvent arg0){

    }
    @Override
    public void mouseExited (MouseEvent arg0){

    }
    @Override
    public void mousePressed (MouseEvent arg0){

    }
    @Override
    public void mouseReleased (MouseEvent arg0){

    }

}
