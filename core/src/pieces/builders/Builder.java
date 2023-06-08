package pieces.builders;

import pieces.PieceType;

public interface Builder {
    public void setActive(boolean active);
    public void setColor(PieceType.Color color);

    public void setFigure(String figure);
    public void setCoord(int posX,int posY);
    public void setType(String type);
}
