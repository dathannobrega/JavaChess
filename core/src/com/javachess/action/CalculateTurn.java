package com.javachess.action;

import pieces.King;
import pieces.Piece;

//o Calculate Turn é uma classe responsavel por "ver o futuro" é ela que possuiu as funçoes de ver se esta em check,
// ver se aconteceu um check mate e ela que pinta o tabuleiro para as jogadas permitidas
public class CalculateTurn {
    static Piece[][] tabuleiro;
    Piece selectedPiece;

    public CalculateTurn(Piece[][] tabuleiro) {
        CalculateTurn.tabuleiro = tabuleiro;
    }

    public boolean isChecked(boolean vezBranco) {

        for (Piece[] peca : tabuleiro) { //esse for passa por cada camada do tabuleiro buscando o rei
            for (int cont = 0; cont < 8; cont++) {
                if (peca[cont] != null && peca[cont] instanceof King) {
                    if (vezBranco && (peca[cont].getColor().name().equals("white"))) // seleciona o rei branco
                        selectedPiece = peca[cont]; // seleciono o rei branco
                    else if (!vezBranco && (peca[cont].getColor().name().equals("black")))
                        selectedPiece = peca[cont]; // checka o rei preto na vez dele
                }
            }
        }

        //aqui vejo se existe alguma peca do tabuleiro inimiga que pode ir para a posição do rei
        for (Piece[] peca : tabuleiro) { //esse for passa por cada camada do tabuleiro verificando
            for (int cont = 0; cont < 8; cont++) {
                if (peca[cont] != null && (peca[cont].getColor() != selectedPiece.getColor())) {
                    if (peca[cont].validMov(selectedPiece.getPosX() / 100, selectedPiece.getPosY() / 100)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //essa função calcula se a peca esta "passando em cima de outra peca."
    static public boolean isPieceBlocked(Piece piece, int x, int y) {
        int currentX = piece.getPosX() / 100; // converted piece positions
        int currentY = piece.getPosY() / 100;

        if (currentX == x && currentY == y) {
            return false;
        }

        if (currentY == y && currentX < x) { // if capturing a piece to the right
            for (int i = currentX + 1; i <= x; i++) {
                if (tabuleiro[i][currentY] != null && !(i == x)) {
                    return true;
                }
            }
        } else if (currentY == y && currentX > x) { // if capturing a piece to the left
            for (int i = currentX - 1; i >= x; i--) {
                if (tabuleiro[i][currentY] != null && !(i == x)) {
                    return true;
                }
            }
        } else if (currentY < y && currentX == x) { // if capturing upwards
            for (int j = currentY + 1; j <= y; j++) {
                if (tabuleiro[currentX][j] != null && !(j==y)) {
                    return true;
                }
            }
        } else if (currentY > y && currentX == x) { // if capturing downwards
            for (int j = currentY - 1; j >= y; j--) {
                if (tabuleiro[currentX][j] != null && !(j==y)) {
                    return true;
                }
            }
        } else if (currentY > y && currentX > x) { // if capturing diagonally downwards '/'
            for (int i = currentX - 1, j = currentY - 1; i >= x && j >= y; i--, j--) {
                if (tabuleiro[i][j] != null && !(j==y && i == x)) {
                    return true;
                }
            }
        } else if (currentY < y && currentX < x) { // if capturing diagonally upwards '/'
            for (int i = currentX + 1, j = currentY + 1; i <= x && j <= y; i++, j++) {
                if (tabuleiro[i][j] != null && !(j==y && i == x)) {
                    return true;
                }
            }
        } else if (currentY > y && currentX < x) { // if capturing diagonally downwards (different direction '\')
            for (int i = currentX + 1, j = currentY - 1; i <= x && j >= y; i++, j--) {
                if (tabuleiro[i][j] != null && !(j==y && i == x)) {
                    return true;
                }
            }
        } else if (currentY < y && currentX > x) { // if capturing diagonally downwards (different direction '\')
            for (int i = currentX - 1, j = currentY + 1; i >= x && j <= y; i--, j++) {
                if (tabuleiro[i][j] != null && !(j==y && i == x)) {
                    return true;
                }
            }
        }

        return false;
    }
}
