package pieces;

import game.Square;

import java.util.ArrayList;

public class King extends Piece {
    private int x,y;
    public King(String ID,String imagePath,String color,int x,int y)
    {
        this.x=x;
        this.y=y;
        setPieceId(ID);
        setImage( imagePath);
        setPieceColor(color);
    }
    public void setx(int x)
    {
        this.x=x;
    }
    public void sety(int y)
    {
        this.y=y;
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    public ArrayList<Square> move(Square state[][], int x, int y){
//The java.util.ArrayList.clear() method removes all of the elements from this list.The list will be empty after this call returns.
        possibleSquares.clear();
        int posx[]={x,x,x+1,x+1,x+1,x-1,x-1,x-1};
        int posy[]={y-1,y+1,y-1,y,y+1,y-1,y,y+1};
        for(int i=0;i<8;i++)
            if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
                if((state[posx[i]][posy[i]].getPiece()==null|| !state[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor())))
                    possibleSquares.add(state[posx[i]][posy[i]]);
        return possibleSquares;
    }


}
