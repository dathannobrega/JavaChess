package pieces.strategy;

import com.javachess.board.Tabuleiro;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceType;

public class PawnMovementStrategy implements MovementStrategy{
    @Override
    public boolean validMov(Piece piece, int SOURCEx, int SOURCEy, int TARGETx, int TARGETy) {
        TARGETx = TARGETx * 100;
        TARGETy = TARGETy * 100;

        Pawn pawn = (Pawn)piece;

        //if(CalculateTurn.isPieceBlocked(this,x/100,y/100))
        //    return false;

        if (pawn.isFirst()) {
            if (pawn.getColor() == PieceType.Color.white) {
                return SOURCEx == TARGETx && (SOURCEy + 100 == TARGETy || SOURCEy + 200 == TARGETy);
            } else {
                return SOURCEx == TARGETx && (SOURCEy - 100 == TARGETy || SOURCEy - 200 == TARGETy);
            }
        } else {
            if (pawn.getColor() == PieceType.Color.white) {
                return (SOURCEy + 100 == TARGETy && (SOURCEx == TARGETx || Math.abs(TARGETx - SOURCEx) == 100)) && Tabuleiro.killPawn(piece, TARGETx / 100, TARGETy / 100);
            } else {
                return (SOURCEy - 100 == TARGETy && (SOURCEx == TARGETx || Math.abs(TARGETx - SOURCEx) == 100)) && Tabuleiro.killPawn(piece, TARGETx / 100, TARGETy / 100);
            }
        }
    }
}
