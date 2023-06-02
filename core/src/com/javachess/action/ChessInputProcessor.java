package com.javachess.action;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import pieces.Piece;

//classe sera usada para "coletar os clcks da nossa interface."
//baseado em: https://libgdx.com/wiki/input/event-handling
public abstract class ChessInputProcessor implements InputProcessor {
    private static final float CELL_SIZE = 100f;
    private OrthographicCamera camera;
    private Piece[][]pieces;

    public ChessInputProcessor(OrthographicCamera camera, Piece pieces[][]) {
        this.camera = camera;
        this.pieces = pieces;
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            int getX, getY;
            if(Gdx.input.isTouched()){
                getX = (int) Gdx.input.getX()/100;
                getY = (int) Gdx.input.getY()/100;

                for (Piece peca[] : pieces) {
                    for(int cont = 0; cont < 8; cont++){
                        if(peca[cont].getPosX()/100 == getX && peca[cont].getPosY()/100 == getY){
                            System.out.println("Cliquei na peca" + peca[cont].getColor());
                        }
                    }

                }
            }
        return false;
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
        this.pieces = pieces;
    }
}
