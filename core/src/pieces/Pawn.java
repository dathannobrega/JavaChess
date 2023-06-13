package pieces;

import com.javachess.action.CalculateTurn;
import com.javachess.action.ChessInputProcessor;
import pieces.builders.PieceBuilder;

public class Pawn extends Piece {
    PieceBuilder pb = new PieceBuilder();
    private boolean isFirst = true;
    public Pawn(boolean active, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(active, color, figure,posX,posY,type);
    }

    @Override
    public boolean validMov(int x, int y) {
        x = x * 100;
        y = y * 100;

        if(CalculateTurn.isOverwrite(this,x,y))
            return false;

        if(isFirst){
            this.isFirst = false; // ja seta para nunca mais entrar
            if (getColor() == PieceType.Color.white) {
                if (getPosX() == x && (getPosY() + 100 == y || getPosY() + 200 == y)) {// 200 pois é necessario uma posição completa
                    return true;
                } else {
                    return false;
                }
            }else {
                if (getPosX() == x && (getPosY() - 100 == y || getPosY() - 200 == y)) { // 200 pois é necessario uma posição completa
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (getColor() == PieceType.Color.white) { // permite q a peça mova para frente e para os lados.
                if ((getPosY() + 100 == y && (getPosX() == x || Math.abs(x-getPosX()) == 100)) && ChessInputProcessor.killPawn(this,x/100,y/100)) {
                    return true;
                } else {
                    return false;
                }
            }else{
                if ((getPosY() - 100 == y && (getPosX() == x || Math.abs(x-getPosX()) == 100)) && ChessInputProcessor.killPawn(this,x/100,y/100)){
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public void move(int x , int y) { // a regra de tranformação fica aqui tmb

        if (getColor() == PieceType.Color.white) {
            this.setPosX(x);
            this.setPosY(y);
        }else{
            this.setPosX(x);
            this.setPosY(y);
        }
    }
}
