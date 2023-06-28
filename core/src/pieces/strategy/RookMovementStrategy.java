package pieces.strategy;

import com.javachess.action.CalculateTurn;
import pieces.Piece;

public class RookMovementStrategy implements MovementStrategy{
    @Override
    public boolean validMov(Piece piece, int SOURCEx, int SOURCEy, int TARGETx, int TARGETy) {

        if((TARGETx == SOURCEx/100 || TARGETy == SOURCEy/100) && !CalculateTurn.isPieceBlocked(piece,TARGETx,TARGETy)){
            return true;
        } else
            return false;
    }
}
