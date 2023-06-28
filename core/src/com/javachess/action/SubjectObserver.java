package com.javachess.action;

import pieces.Piece;

public interface SubjectObserver {
    void notifica(Piece peca, int x, int y);
}