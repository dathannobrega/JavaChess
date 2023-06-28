package pieces.strategy;

import pieces.Piece;

public class KnightMovementStrategy implements MovementStrategy{
    @Override
    public boolean validMov(Piece piece, int SOURCEx, int SOURCEy, int TARGETx, int TARGETy) {
        TARGETx = TARGETx*100;
        TARGETy = TARGETy*100;
        if((SOURCEx == TARGETx+100 && SOURCEy+ 200  == TARGETy ) || (SOURCEx == TARGETx - 100 && SOURCEy + 200  == TARGETy ) ){// pra frente esquerda ou direita.
            return true;
        }else if((SOURCEx == TARGETx+100 && SOURCEy- 200  == TARGETy ) || (SOURCEx == TARGETx - 100 && SOURCEy - 200  == TARGETy ) ){// pra traz esquerda ou direita.
            return true;
        } else // pra esquerda cima ou embaixo
            if((SOURCEx == TARGETx+200 && SOURCEy - 100  == TARGETy ) || (SOURCEx == TARGETx + 200 && SOURCEy + 100  == TARGETy ) ){// pra direta cima ou embaixo
                return true;
            }else return (SOURCEx == TARGETx - 200 && SOURCEy - 100 == TARGETy) || (SOURCEx == TARGETx - 200 && SOURCEy + 100 == TARGETy);
    }
}
