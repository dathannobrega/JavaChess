package pieces.builders;

import pieces.Piece;
import pieces.PieceType;

//classe imlementada para criar as peças corretas durante a incialização do tabuleiro.
//utiliza o Metodo CriacionalBuilder.
public class PieceBuilder implements Builder{
    private boolean active;
    private PieceType.Color color;
    private String figure;

    private int posX;
    private int posY;
    @Override
    public void setActive(boolean active){
        this.active = active;
    }

    @Override
    public void setColor(PieceType.Color color){
        this.color = color;
    }
    @Override
    public void setFigure(String figure){
        this.figure = figure;
    }
    @Override
    public void setCoord(int posX,int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public Piece getResult() {
        return new Piece(active, color, figure, posX, posY);
    }
}
