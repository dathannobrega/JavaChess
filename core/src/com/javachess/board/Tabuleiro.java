package com.javachess.board;

import com.javachess.action.Verification;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceType;
import pieces.Queen;
import pieces.builders.PieceBuilder;


//nessa classe é importada o Singleton para o tabuleiro.
public class Tabuleiro implements Verification { // essa classe é o tabuleiro jogo e todos as respectivas funcionalidades.
    private static Tabuleiro instance;
    private static Piece[][]pieces;
    private boolean vezBranco = true;

    public Tabuleiro(){
        CreatePieces create = new CreatePieces(); // cria todas AS PEÇAS NAS SUAS respectivas posições.
        pieces = create.createPiece();
    }

    public static Tabuleiro getInstance() {
        if (instance == null) {
            instance = new Tabuleiro();
        }
        return instance;
    }

    public boolean isPawn(Piece peca){ // função para ver se uma pecca é peao
        return peca instanceof Pawn;
    }

    public void trocaVez(){
        vezBranco= !vezBranco;
    }

    @Override
    public Queen upgradePiece(Piece peca,int getx,int gety){
        PieceBuilder pb = new PieceBuilder();
        pb.setCoord(getx, gety); // observar se esta dando certo essa transformação
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

    //função que verifica a Peça PAWN para ver se ela pode mover para o lado e impede que coma de frente
    @Override
    public boolean verifyKill(Piece peca, int x,int y){ // verifica o movimento e se esta matando o amigo
        Piece wantKill = pieces[x][y];
        if(peca.validMov(x,y)){
            if(peca.getPosX()/100 == y - 1) // se for a peça da frente não posso mata(Peão nao come reto)
                return false;
            // se a peça for do lado e não for amiga eu poço matar.
            return wantKill != null && verifyEntity(wantKill, x, y); //se a peça for a do lado eu posso matar!
        } else{
            return true;
        }
    }
    @Override
    public boolean confirmaVez(Piece peca){
        if(vezBranco && peca.getColor() == PieceType.Color.white){
            return true;
        } else return !vezBranco && peca.getColor() == PieceType.Color.black;
    }
    @Override
    public boolean verifyUpgrade(Piece peca,int  y){
        return y == 7 || y == 0;
    }
    static public boolean verifyEntity(Piece peca, int x, int y) {
        if(pieces[x][y] == null){ // se a posição estiver vazia ele me retorna true
            return true;
        }
        return pieces[x][y].getColor() != peca.getColor();
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
        if(peca.getColor().name().equals("white")) { // Trato o passant da branca
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



    //Getters and Setters

    public static Piece[][] getPieces() {
        return pieces;
    }

    public static void setPieces(Piece[][] pieces) {
        Tabuleiro.pieces = pieces;
    }

    public boolean isVezBranco() {
        return vezBranco;
    }
}
