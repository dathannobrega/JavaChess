package com.javachess.action;

import pieces.Piece;

public interface SubjectObserver {
    public void notifica(Piece peca, int x, int y);
}