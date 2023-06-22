package com.javachess.action;

import pieces.Piece;
import pieces.Queen;

public interface Verification { // interface criada para verificar alguns movimentos

    Queen upgradePiece(Piece peca,int getx,int gety);
    boolean verifyUpgrade(Piece peca , int y);
    boolean confirmaVez(Piece peca); // função usada para ver se a peça selecionada é de acordo com a vez.

    boolean verifyKill(Piece peca, int x,int y);

    boolean isPawn(Piece peca);

}
