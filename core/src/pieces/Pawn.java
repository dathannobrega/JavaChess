package pieces;

import pieces.builders.PieceBuilder;

public class Pawn extends Piece {
    PieceBuilder pb = new PieceBuilder();
    private boolean isFirst = true;
    public Pawn(boolean active, PieceType.Color color, String figure,int posX,int posY) {
        super(active, color, figure,posX,posY);
    }

    @Override
    public boolean validMov(int x, int y) {
        x = x * 100;
        y = y * 100;

        if(isFirst){
            this.isFirst = false; // ja seta para nunca mais entrar
            if (getColor() == PieceType.Color.BRANCA) {
                if (getPosX() == x && getPosY() + 100 == y || getPosX() == x && getPosY() + 200 == y) { // 200 pois é necessario uma posição completa
                    return true;
                } else {
                    return false;
                }
            }else {
                if (getPosX() == x && getPosY() - 100 == y || getPosX() == x && getPosY() + 200 == y) { // 200 pois é necessario uma posição completa
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (getColor() == PieceType.Color.BRANCA) {
                if (getPosX() == x && getPosY() + 100 == y) { // 100 pois é necessario uma posição completa
                    return true;
                } else {
                    return false;
                }
            }else{
                if (getPosX() == x && getPosY() - 100 == y) { // 100 pois é necessario uma posição completa
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public void move(int x , int y) { // a regra de tranformação fica aqui tmb

        if (getColor() == PieceType.Color.BRANCA) {
            this.setPosX(x);
            this.setPosY(y);
        }else{
            this.setPosX(x);
            this.setPosY(y);
        }
    }
}
