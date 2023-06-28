package pieces;

import com.javachess.board.Tabuleiro;
import pieces.strategy.MovementStrategy;


public class Pawn extends Piece {

    private boolean isFirst = true;
    public Pawn(MovementStrategy movementStrategy, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(movementStrategy,color, figure,posX,posY,type);
    }

    @Override
    public void move(int x , int y) { // a regra de tranformação fica aqui tmb
        isFirst = false; // já define para nunca mais entrar
        this.setPosX(x);
        this.setPosY(y);
    }

    public boolean isFirst() {
        return isFirst;
    }
}
