package pieces;

import com.javachess.action.CalculateTurn;

public class Rook extends Piece {
    public Rook(boolean active, PieceType.Color color, String figure,int posX,int posY,String type) {
        super(active, color, figure,posX,posY,type);
    }

    @Override
    public boolean validMov(int x, int y) {
        x = x * 100;
        y = y * 100;

        if((x == getPosX() || y == getPosY()) && !CalculateTurn.isPieceBlocked(this,x,y)){
            return true;
        } else
            return false;
    }

    @Override
    public void move(int x, int y) {
        System.out.println("======DEBUG======");
        System.out.println("DE: X = " + x + " Y = "+y);
        System.out.println("DE: X = " + getPosX() + " Y = "+ getPosY());
        System.out.println("======DEBUG======");
        this.setPosX(x);
        this.setPosY(y);
    }
}
