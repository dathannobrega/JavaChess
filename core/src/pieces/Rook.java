package pieces;

import com.javachess.action.CalculateTurn;
import pieces.strategy.MovementStrategy;

public class Rook extends Piece {
    public Rook(MovementStrategy movementStrategy, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(movementStrategy,color, figure,posX,posY,type);
    }

    @Override
    public boolean validMov(int x, int y) {

        if((x == getPosX()/100 || y == getPosY()/100) && !CalculateTurn.isPieceBlocked(this,x,y)){
            return true;
        } else
            return false;
    }
}
