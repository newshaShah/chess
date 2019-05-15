package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Main extends JFrame implements MouseListener{


    private JButton[][] chessBoardSquares = new JButton[8][8];
//    private Image[][] chessPieceImages = new Image[2][6];
//    private final JLabel message = new JLabel(
//            "Chess Champ is ready to play!");
//    public static final int QUEEN = 0, KING = 1,
//            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
//    public static final int[] STARTING_ROW = {
//            ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK };

private Main()

    {

        JFrame myFrame = new JFrame("Chess");

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
        // eastPanel.setBackground(Color.RED);
        centerpanel.setLayout(new GridLayout(8, 8));
        myFrame.add(centerpanel, BorderLayout.CENTER);
        myFrame.add(westPanel, BorderLayout.WEST);
        myFrame.add(eastPanel, BorderLayout.EAST);
        // JPanel[] myJP = new JPanel[64];
        //  ArrayList<JPanel> myJP=new ArrayList<>(64);
        ArrayList<JButton> myJP = new ArrayList<>(64);
        for (int i = 0; i < 64; i++) {
            JButton j = new JButton();
            // JButton[] buttons = new JButton[8];
//            for(int k=0;k<8;k++){
//                buttons[i]=
//            }i

//            JButton button = new JButton();
//            j.add(button);

//            myJP.add(j);
//            j.addActionListener(new test(j));
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == j % 2) {
                    myJP.get((i * 8) + j).setBackground(new Color(51, 51, 51));
                }
                if (i % 2 != j % 2) {
                    myJP.get((i * 8) + j).setBackground(new Color(204, 204, 204));
                }
            }
        }
//       myJP.add()
//        ArrayList<JButton> button=new ArrayList<>();
//        for(int i=0;i<64;i++){button.get(i)=myJP.get(i)}
        for (int i = 0; i < 64; i++) {
            centerpanel.add(myJP.get(i));
        }


        //  JButton b1 = new JButton();
        myFrame.setVisible(true);
        myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
    @Override
    public void mouseClicked(MouseEvent e){

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
