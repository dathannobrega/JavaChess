package pieces.strategy;

import pieces.Piece;

public interface MovementStrategy {
    public abstract boolean validMov(Piece piece, int SOURCEx, int SOURCEy, int TARGETx, int TARGETy);
}
