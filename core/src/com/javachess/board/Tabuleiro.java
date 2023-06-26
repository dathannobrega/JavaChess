package com.javachess.board;

import pieces.Piece;


//nessa classe é importada o Singleton para o tabuleiro.
public class Tabuleiro { // essa classe é o tabuleiro jogo e todos as respectivas funcionalidades.
    private static Tabuleiro instance;
    private static Piece[][]pieces;

    public Tabuleiro(){
        CreatePieces create = new CreatePieces(); // cria todas AS PEÇAS NAS SUAS respectivas posições.
        pieces = create.createPiece();;
    }

    public static Tabuleiro getInstance() {
        if (instance == null) {
            instance = new Tabuleiro();
        }
        return instance;
    }

    public static Piece[][] getPieces() {
        return pieces;
    }

    public static void setPieces(Piece[][] pieces) {
        Tabuleiro.pieces = pieces;
    }
}
