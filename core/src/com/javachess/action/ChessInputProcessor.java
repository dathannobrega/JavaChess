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
    protected static Piece[][]pieces;
    private boolean vezBranco = true;
    CalculateTurn calculateTurn;

    public boolean isVezBranco() {
        return vezBranco;
    }

    public ChessInputProcessor(OrthographicCamera camera, Piece pieces[][]) {
        this.camera = camera;
        this.pieces = pieces;
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
        this.pieces = pieces;
    }

    public void trocaVez(){
        if(vezBranco){
            vezBranco=false;
        }else{
            vezBranco = true;
        }
    }


    static public boolean verifyEntity(Piece peca, int x, int y) {
        if(pieces[x][y] == null){ // se a posição estiver vazia ele me retorna true
            return true;
        }
        if(pieces[x][y].getColor() == peca.getColor()){
            return false;
        } else{
            return true;
        }
    }
//TODAS OS MOVIMENTOS ESPECIAIS RELACIOANDOS AO PEAO SAO TRATADOS no KILLPawn
    static public boolean killPawn(Piece peca, int x, int y) {
        int myX = peca.getPosX()/100; // pego a posição atual da peca que movo
        int myY = peca.getPosY()/100; // e divido por 100 para ter numeros de 0 a 7

        //Nao deixa matar para frente tanto paro o branco quanto para o preto
        if(pieces[x][y] != null) // se nao tiver peca retorna false
            if(pieces[x][y].getColor() != peca.getColor()) // se for inimiga retorna true
                if(x == myX && Math.abs(y-myY) == 1) // se vou para frente não deixo.
                    return false;

        //Movimentos especiais do peao PRETO
        if(peca.getColor().name() == "white") { // Trato o passant da branca
            //Aqui tratamos o comer pro lado.
            if(pieces[x][y] != null) // se nao tiver peca retorna false
                if(pieces[x][y].getColor() != peca.getColor()) // se for inimiga retorna true
                    if(Math.abs(x-myX) == 1 && myY + 1  == y) // se vou para o lado eu permito se for para matar uma peca
                        return true;

            //Essa parte trataremos o Passant
            if (pieces[x][y] == null  && x != myX) // se nao tiver peca retorna false
                if (pieces[x][y - 1] != null && (pieces[x][y - 1].getColor() != peca.getColor()) ) {//se a pesa embaixo tiver algo
                    pieces[x][y - 1] = null; //mato a peca
                    return true;
                }else {
                    return false; // se nao for retorna false e não deixa
                }
        } else { //Movimentos especiais do peao PRETO

            if(pieces[x][y] != null) // se nao tiver peca retorna false
                if(pieces[x][y].getColor() != peca.getColor()) // se for inimiga retorna true
                    if(Math.abs(x-myX) == 1 && myY - 1  == y) // se vou para o lado eu permito se for para matar uma peca
                        return true;
            if (pieces[x][y] == null && x != myX) // se nao tiver peca retorna false
                if (pieces[x][y + 1] != null && (pieces[x][y + 1].getColor() != peca.getColor())) {//se a pesa embaixo tiver algo
                    pieces[x][y + 1] = null; //mato a peca
                    return true;
                } else {
                    return false;
                }
        }


        return true;
    }
    @Override
    public Queen upgradePiece(Piece peca,int getx,int gety){
        PieceBuilder pb = new PieceBuilder();
        pb.setCoord(peca.getPosX(), peca.getPosY());
        pb.setActive(true);
        pb.setType("queen");
        pb.setFigure("piece/"+peca.getColor().name()+"_queen.png");
        if(peca.getColor() == PieceType.Color.white){
            pb.setColor(PieceType.Color.white);
        }else{
            pb.setColor(PieceType.Color.black);
        }
        return pb.getResultQueen();
    }
    @Override
    public boolean verifyUpgrade(Piece peca,int  y){
        if(y == 7 || y == 0)
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
