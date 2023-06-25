package pieces;

import com.javachess.action.CalculateTurn;

public class Rook extends Piece {
    public Rook(boolean active, PieceType.Color color, String figure,int posX,int posY,String type) {
        super(active, color, figure,posX,posY,type);
    }

    @Override
    public boolean validMov(int x, int y) {

        if((x == getPosX()/100 || y == getPosY()/100) && !CalculateTurn.isPieceBlocked(this,x,y)){
            return true;
        } else
            return false;
    }
}
