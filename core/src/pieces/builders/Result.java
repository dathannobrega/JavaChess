package pieces.builders;

import pieces.*;

public interface Result {
    Pawn getResultPawn();
    Rook getResultRook();
    Queen getResultQueen();
    Knight getResultKnigth();
    King getResultKing();
    Bishop getResultBishop();

}
