package pieces;

import pieces.strategy.MovementStrategy;

public class Bishop extends Piece {

    public Bishop(MovementStrategy movementStrategy, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(movementStrategy, color, figure,posX,posY,type);
    }

}
