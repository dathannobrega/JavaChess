package pieces;

import pieces.strategy.MovementStrategy;

public class Knight extends Piece {
    public Knight(MovementStrategy movementStrategy, PieceType.Color color, String figure, int posX, int posY, String type) {
        super(movementStrategy,color, figure,posX,posY,type);
    }
    @Override
    public boolean validMov(int x, int y) {
        x = x*100;
        y = y*100;
        if((getPosX() == x+100 && getPosY()+ 200  == y ) || (getPosX() == x - 100 && getPosY() + 200  == y ) ){// pra frente esquerda ou direita.
            return true;
        }else if((getPosX() == x+100 && getPosY()- 200  == y ) || (getPosX() == x - 100 && getPosY() - 200  == y ) ){// pra traz esquerda ou direita.
            return true;
        } else // pra esquerda cima ou embaixo
            if((getPosX() == x+200 && getPosY() - 100  == y ) || (getPosX() == x + 200 && getPosY() + 100  == y ) ){// pra direta cima ou embaixo
            return true;
        }else return (getPosX() == x - 200 && getPosY() - 100 == y) || (getPosX() == x - 200 && getPosY() + 100 == y);
    }
}
