package pieces;

import com.javachess.board.Tabuleiro;


public class Pawn extends Piece {

    private boolean isFirst = true;
    public Pawn(PieceType.Color color, String figure, int posX, int posY, String type) {
        super(color, figure,posX,posY,type);
    }

    @Override
    public boolean validMov(int x, int y) {
        x = x * 100;
        y = y * 100;

        //if(CalculateTurn.isPieceBlocked(this,x/100,y/100))
        //    return false;

        if (isFirst) {
            if (getColor() == PieceType.Color.white) {
                return getPosX() == x && (getPosY() + 100 == y || getPosY() + 200 == y);
            } else {
                return getPosX() == x && (getPosY() - 100 == y || getPosY() - 200 == y);
            }
        } else {
            if (getColor() == PieceType.Color.white) {
                return (getPosY() + 100 == y && (getPosX() == x || Math.abs(x - getPosX()) == 100)) && Tabuleiro.killPawn(this, x / 100, y / 100);
            } else {
                return (getPosY() - 100 == y && (getPosX() == x || Math.abs(x - getPosX()) == 100)) && Tabuleiro.killPawn(this, x / 100, y / 100);
            }
        }
    }

    @Override
    public void move(int x , int y) { // a regra de tranformação fica aqui tmb
        isFirst = false; // já define para nunca mais entrar
        this.setPosX(x);
        this.setPosY(y);
    }
}
