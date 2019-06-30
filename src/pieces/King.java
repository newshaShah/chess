package pieces;

import game.Square;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  @author Newsha Shahbodaghkhan
 *  *King class show the King's moves that moves and set its ID imagePath and color
 */

public class King extends Piece {
    private int x,y;
    /**
     *
     * @param ID set ID of king
     * @param imagePath set image king
     * @param color set color of king
     */
    public King(String ID,String imagePath,String color,int x,int y)
    {
        this.x=x;
        this.y=y;
        setPieceId(ID);
        setImage( imagePath);
        setPieceColor(color);
    }

    /**
     *
     * @param x set x coordinate of king
     */

    public void setx(int x)
    {
        this.x=x;
    }

    /**
     *
     * @param y set y coordinate of a king
     */
    public void sety(int y)
    {
        this.y=y;
    }


    /**
     *
     * @return x coordinate of king
     */
    public int getx()
    {
        return x;
    }

    /**
     *
     * @return y coordinate of king
     */
    public int gety()
    {
        return y;
    }
    @Override

    /**
     * @param boardSquare is the current board situation
     * @param x is the x of king in board
     * @param y is the y of king in board
     * @return arraylist of next possible squares of king
     */
    public ArrayList<Square> move(Square[][] squares, int x, int y){
//The java.util.ArrayList.clear() method removes all of the elements from this list.The list will be empty after this call returns.
        ArrayList<Square> possibleSquares=new ArrayList<>();

        int posx[]={x,x,x+1,x+1,x+1,x-1,x-1,x-1};
        int posy[]={y-1,y+1,y-1,y,y+1,y-1,y,y+1};
        for(int i=0;i<8;i++)
            if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
                if((squares[posx[i]][posy[i]].getPiece()==null|| !squares[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor())))
                    possibleSquares.add(squares[posx[i]][posy[i]]);



        return possibleSquares;
    }

    /**
     *
     * @param squares current situation of a board
     * @return true if king is checked
     */
    public boolean isChecked(Square [][] squares){
//Checking for attack from left,right,up and down
        for(int i=x+1;i<8;i++)
        {
            if(squares[i][y].getPiece()==null)
                continue;
            else if(squares[i][y].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if ((squares[i][y].getPiece() instanceof Rook) || (squares[i][y].getPiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        for(int i=x-1;i>=0;i--)
        {
            if(squares[i][y].getPiece()==null)
                continue;
            else if(squares[i][y].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if ((squares[i][y].getPiece() instanceof Rook) || (squares[i][y].getPiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        for(int i=y+1;i<8;i++)
        {
            if(squares[x][i].getPiece()==null)
                continue;
            else if(squares[x][i].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if ((squares[x][i].getPiece() instanceof Rook) || (squares[x][i].getPiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        for(int i=y-1;i>=0;i--)
        {
            if(squares[x][i].getPiece()==null)
                continue;
            else if(squares[x][i].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if ((squares[x][i].getPiece() instanceof Rook) || (squares[x][i].getPiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }

        //checking for attack from diagonal direction
        int tempx=x+1,tempy=y-1;
        while(tempx<8&&tempy>=0)
        {
            if(squares[tempx][tempy].getPiece()==null)
            {
                tempx++;
                tempy--;
            }
            else if(squares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if (squares[tempx][tempy].getPiece() instanceof Bishop || squares[tempx][tempy].getPiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }
        tempx=x-1;tempy=y+1;
        while(tempx>=0&&tempy<8)
        {
            if(squares[tempx][tempy].getPiece()==null)
            {
                tempx--;
                tempy++;
            }
            else if(squares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if (squares[tempx][tempy].getPiece() instanceof Bishop || squares[tempx][tempy].getPiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }
        tempx=x-1;tempy=y-1;
        while(tempx>=0&&tempy>=0)
        {
            if(squares[tempx][tempy].getPiece()==null)
            {
                tempx--;
                tempy--;
            }
            else if(squares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if (squares[tempx][tempy].getPiece() instanceof Bishop || squares[tempx][tempy].getPiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }
        tempx=x+1;tempy=y+1;
        while(tempx<8&&tempy<8)
        {
            if(squares[tempx][tempy].getPiece()==null)
            {
                tempx++;
                tempy++;
            }
            else if(squares[tempx][tempy].getPiece().getPieceColor().equals(this.getPieceColor()))
                break;
            else
            {
                if (squares[tempx][tempy].getPiece() instanceof Bishop || squares[tempx][tempy].getPiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }

        //Checking for attack from the Knight of opposite color
        int posx[]={x+1,x+1,x+2,x+2,x-1,x-1,x-2,x-2};
        int posy[]={y-2,y+2,y-1,y+1,y-2,y+2,y-1,y+1};
        for(int i=0;i<8;i++)
            if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
                if(squares[posx[i]][posy[i]].getPiece()!=null && !squares[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor()) && (squares[posx[i]][posy[i]].getPiece() instanceof Knight))
                {
                    return true;
                }


        //Checking for attack from the Pawn of opposite color
        int pox[]={x+1,x+1,x+1,x,x,x-1,x-1,x-1};
        int poy[]={y-1,y+1,y,y+1,y-1,y+1,y-1,y};
        {
            for(int i=0;i<8;i++)
                if((pox[i]>=0&&pox[i]<8&&poy[i]>=0&&poy[i]<8))
                    if(squares[pox[i]][poy[i]].getPiece()!=null && !squares[pox[i]][poy[i]].getPiece().getPieceColor().equals(this.getPieceColor()) && (squares[pox[i]][poy[i]].getPiece() instanceof King))
                    {
                        return true;
                    }
        }
        if(getPieceColor().equals("w"))
        {
            if(x>0&&y>0&&squares[x-1][y-1].getPiece()!=null&& squares[x - 1][y - 1].getPiece().getPieceColor().equals("b") &&(squares[x-1][y-1].getPiece() instanceof Pawn))
                return true;
            if(x>0&&y<7&&squares[x-1][y+1].getPiece()!=null&& squares[x - 1][y + 1].getPiece().getPieceColor().equals("b") &&(squares[x-1][y+1].getPiece() instanceof Pawn))
                return true;
        }
        else
        {
            if(x<7&&y>0&&squares[x+1][y-1].getPiece()!=null&& squares[x + 1][y - 1].getPiece().getPieceColor().equals("w") &&(squares[x+1][y-1].getPiece() instanceof Pawn))
                return true;
            if(x<7&&y<7&&squares[x+1][y+1].getPiece()!=null&& squares[x + 1][y + 1].getPiece().getPieceColor().equals("w") &&(squares[x+1][y+1].getPiece() instanceof Pawn))
                return true;
        }
        return false;


    }
    public boolean isCheckMate(Square [][] squares){
        return false;
    }

}
