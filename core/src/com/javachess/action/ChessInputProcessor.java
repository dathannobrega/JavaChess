package com.javachess.action;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceType;
import pieces.Queen;
import pieces.builders.PieceBuilder;

//classe sera usada para "coletar os clcks da nossa interface."
//baseado em: https://libgdx.com/wiki/input/event-handling
public abstract class ChessInputProcessor implements InputProcessor,Verification {

    private static final float CELL_SIZE = 100f;
    private OrthographicCamera camera;
    private Piece[][]pieces;
    private boolean vezBranco = true;

    public boolean isVezBranco() {
        return vezBranco;
    }

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
        this.pieces = pieces;
    }

    public void trocaVez(){
        if(vezBranco){
            vezBranco=false;
        }else{
            vezBranco = true;
        }
    }

    @Override
    public boolean verifyEntity(Piece peca, int x, int y) {
        if(pieces[x][y] == null){ // se a posição estiver vazia ele me retorna true
            return true;
        }
        if(pieces[x][y].getColor() == peca.getColor()){
            System.out.println("vc nao pode matar um amigo");
            return false;
        } else{
            return true;
        }
    }
    @Override
    public Queen upgradePiece(Piece peca){
        PieceBuilder pb = new PieceBuilder();
        pb.setCoord(peca.getPosX(), peca.getPosY());
        pb.setActive(true);
        if(peca.getColor() == PieceType.Color.white){
            pb.setColor(PieceType.Color.white);
            pb.setFigure("piece/white_queen.png");
        }else{
            pb.setColor(PieceType.Color.black);
            pb.setFigure("piece/black_queen.png");
        }
        return pb.getResultQueen();
    }
    @Override
    public boolean verifyUpgrade(Piece peca,int  y){
        if(peca instanceof Pawn && (y == 7 || y == 0))
            return true;
        else
            return false;
    }

    public boolean isPawn(Piece peca){ // função para ver se uma pecca é peao
        if(peca instanceof Pawn)
            return true;
        else
            return false;
    }

    @Override
    public boolean confirmaVez(Piece peca){
        if(vezBranco && peca.getColor() == PieceType.Color.white){
            return true;
        } else if(!vezBranco && peca.getColor() == PieceType.Color.black) {
            return true;
        } else {
            return false;
        }
    }

    //função que verifica a Peça PAWN para ver se ela pode mover para o lado e impede que coma de frente
    @Override
    public boolean verifyKill(Piece peca, int x,int y){ // verifica o movimento e se esta matando o amigo
        Piece wantKill = pieces[x][y];
        if(peca.validMov(x,y)){
            if(peca.getPosX()/100 == y - 1) // se for a peça da frente não posso mata(Peão nao come reto)
                return false;
            if(wantKill != null && verifyEntity(wantKill,x,y)){ // se a peça for do lado e não for amiga eu poço matar.
                return true; //se a peça for a do lado eu posso matar!
            }else {
                return false;
            }
        } else{
            return true;
        }
    }
}
