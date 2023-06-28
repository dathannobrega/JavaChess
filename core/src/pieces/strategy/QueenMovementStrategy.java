package pieces.strategy;

import com.javachess.action.CalculateTurn;
import pieces.Piece;

public class QueenMovementStrategy implements MovementStrategy{
    @Override
    public boolean validMov(Piece piece, int SOURCEx, int SOURCEy, int TARGETx, int TARGETy) {
        if(!CalculateTurn.isPieceBlocked(piece,TARGETx,TARGETy)){

            if( TARGETx == SOURCEx/100 || TARGETy == SOURCEy/100)
                return true;

            for (int i = SOURCEx/100,j=SOURCEy/100; i < 7 || j< 7 ; i++, j++){
                if(TARGETx == i && TARGETy ==j)
                    return true;
            }
            for (int i = SOURCEx/100,j=SOURCEy/100; i >= 0 || j >=0 ; i--, j--){
                if(TARGETx == i && TARGETy ==j)
                    return true;
            }
            for (int i = SOURCEx/100,j=SOURCEy/100; i >= 0 || j< 7 ; i--, j++){
                if(TARGETx == i && TARGETy ==j)
                    return true;
            }
            for (int i = SOURCEx/100,j=SOURCEy/100; i < 7 || j >= 0  ; i++, j--){
                if(TARGETx == i && TARGETy ==j)
                    return true;
            }
        }
        return false;
    }
}
