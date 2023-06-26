package pieces.builders;

import pieces.*;

//classe imlementada para criar as peças corretas durante a incialização do tabuleiro.
//utiliza o Metodo CriacionalBuilder.
public class PieceBuilder implements Builder,Result{
    private boolean active;
    private PieceType.Color color;
    private String figure, type;

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

    //Nessa sessão retornamos varios tipos de objetos na saida.

    @Override
    public Pawn getResultPawn() {
        return new Pawn(color, figure, posX, posY,type);
    }

    @Override
    public Rook getResultRook() {
        return new Rook(color, figure, posX, posY,type);
    }

    @Override
    public Queen getResultQueen() {
        return new Queen(color, figure, posX, posY,type);
    }

    @Override
    public Knight getResultKnigth() {
        return new Knight(color, figure, posX, posY,type);
    }

    @Override
    public King getResultKing() {
        return new King(color, figure, posX, posY,type);
    }

    @Override
    public Bishop getResultBishop() {
        return new Bishop(color, figure, posX, posY,type);
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }
}
