package pieces;

import com.javachess.action.CalculateTurn;

public class Bishop extends Piece {

    public Bishop(boolean active, PieceType.Color color, String figure,int posX,int posY,String type) {
        super(active, color, figure,posX,posY,type);
    }

    @Override
    public boolean validMov(int x, int y) {

        int posx = getPosX()/100; // por algum motivo essa peca esta multiplicada por 100
        int posy = getPosY()/100;
        if(CalculateTurn.isPieceBlocked(this,x,y)) //função que verifica se não estou passando em cima de ninguem.
            return false;

        for (int i = posx ,j = posy ; i <= 7 || j <= 7 ; i++, j++){
            if(x == i && y == j)
                return true;
        }
        for (int i = posx ,j=posy ; i >= 0 || j >=0 ; i--, j--){
            if(x == i && y == j)
                return true;
        }
        for (int i = posx ,j=posy ; i >= 0 || j <= 7 ; i--, j++){
            if(x == i && y == j)
                return true;
        }
        for (int i = posx ,j=posy ; i <= 7 || j >= 0  ; i++, j--){
            if(x == i && y == j)
                return true;
        }

        return false;
    }
}
