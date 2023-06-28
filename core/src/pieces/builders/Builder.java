package pieces.builders;

import pieces.PieceType;
import pieces.strategy.MovementStrategy;

public interface Builder {
    void setActive(boolean active);
    void setColor(PieceType.Color color);
    void setFigure(String figure);
    void setCoord(int posX,int posY);
    void setType(String type);
    void setMovementStrategy(MovementStrategy movementStrategy);
}
