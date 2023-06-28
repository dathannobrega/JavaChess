package pieces;

import pieces.strategy.MovementStrategy;

public class King extends Piece {
    public King(MovementStrategy movementStrategy, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(movementStrategy,color, figure,posX,posY,type);
    }

}
