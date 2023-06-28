package pieces;

import pieces.strategy.MovementStrategy;

public class Knight extends Piece {
    public Knight(MovementStrategy movementStrategy, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(movementStrategy,color, figure,posX,posY,type);
    }

}
