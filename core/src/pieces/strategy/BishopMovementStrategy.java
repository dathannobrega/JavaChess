package pieces.strategy;

import com.javachess.action.CalculateTurn;
import pieces.Piece;

public class BishopMovementStrategy implements MovementStrategy{
    @Override
    public boolean validMov(Piece piece, int SOURCEx, int SOURCEy, int TARGETx, int TARGETy) {

        int posx = SOURCEx/100; // por algum motivo essa peca esta multiplicada por 100
        int posy = SOURCEy/100;
        if(CalculateTurn.isPieceBlocked(piece,TARGETx,TARGETy)) //função que verifica se não estou passando em cima de ninguem.
            return false;

        for (int i = posx ,j = posy ; i <= 7 || j <= 7 ; i++, j++){
            if(TARGETx == i && TARGETy == j)
                return true;
        }
        for (int i = posx ,j=posy ; i >= 0 || j >=0 ; i--, j--){
            if(TARGETx == i && TARGETy == j)
                return true;
        }
        for (int i = posx ,j=posy ; i >= 0 || j <= 7 ; i--, j++){
            if(TARGETx == i && TARGETy == j)
                return true;
        }
        for (int i = posx ,j=posy ; i <= 7 || j >= 0  ; i++, j--){
            if(TARGETx == i && TARGETy == j)
                return true;
        }

        return false;
    }
}
