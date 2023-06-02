package com.javachess.action;

import pieces.Piece;

public interface Verification { // interface criada para verificar alguns movimentos

    boolean  verifyEntity(Piece peca, int x,int y);
}
