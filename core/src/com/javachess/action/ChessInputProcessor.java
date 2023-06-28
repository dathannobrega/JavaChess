package com.javachess.action;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import pieces.Piece;


//classe sera usada para "coletar os clicks da nossa interface."
//baseado em: https://libgdx.com/wiki/input/event-handling
public abstract class ChessInputProcessor implements InputProcessor,SubjectObserver {

    private static Piece[][]pieces;
    CalculateTurn calculateTurn;

    public ChessInputProcessor(Piece[][] pieces) {
        ChessInputProcessor.pieces = pieces;
        calculateTurn = new CalculateTurn(pieces); // passo o tabuleiro pro calculador.
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) { return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        ChessInputProcessor.pieces = pieces;
    }

}
