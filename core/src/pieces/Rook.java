package pieces;

import com.javachess.action.CalculateTurn;
import pieces.strategy.MovementStrategy;

public class Rook extends Piece {
    public Rook(MovementStrategy movementStrategy, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(movementStrategy,color, figure,posX,posY,type);
    }

}
