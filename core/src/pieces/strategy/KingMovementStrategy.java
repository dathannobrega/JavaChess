package pieces.strategy;

import pieces.Piece;

public class KingMovementStrategy implements MovementStrategy{
    @Override
    public boolean validMov(Piece piece, int SOURCEx, int SOURCEy, int TARGETx, int TARGETy) {

        return !(TARGETy > SOURCEy/100 + 1 || TARGETx > SOURCEx/100 + 1 || TARGETy < SOURCEy/100 - 2 || TARGETx < SOURCEx/100 - 2);
    }
}
