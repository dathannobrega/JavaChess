package com.javachess.action;

import pieces.King;
import pieces.Piece;
import pieces.PieceType;

//o Calculate Turn é uma classe responsavel por "ver o futuro" é ela que possuiu as funçoes de ver se esta em check,
// ver se aconteceu um check mate e ela que pinta o tabuleiro para as jogadas permitidas
public class CalculateTurn {
    static Piece[][] tabuleiro;
    Piece selectedPiece;

    public CalculateTurn(Piece[][] tabuleiro) {
        CalculateTurn.tabuleiro = tabuleiro;
    }

    public boolean isChecked(boolean vezBranco,Piece[][] tabuleiro1) {

        for (Piece[] peca : tabuleiro1) { //esse for passa por cada camada do tabuleiro buscando o rei
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
        for (Piece[] peca : tabuleiro1) { //esse for passa por cada camada do tabuleiro verificando
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

    public boolean isCheckedMate(int x, int y, boolean vezBranco, Piece selectedPiece){
        Piece[][] tabuleiroTemp = new Piece[8][8];
        

        for(int i = 0; i < 8; i++){
            for(int j = 0; j<8; j++){
                tabuleiroTemp[i][j] = tabuleiro[i][j];
            }
        }
        Piece rei = null; // declaro o rei como nulo
        for (Piece[] peca : tabuleiroTemp) { //esse for passa por cada camada do tabuleiro buscando o rei
            for (int cont = 0; cont < 8; cont++) {
                if (peca[cont] != null && peca[cont] instanceof King) {
                    if (vezBranco && (peca[cont].getColor().name().equals("white"))) // seleciona o rei branco
                        rei = peca[cont]; // seleciono o rei branco
                    else if (!vezBranco && (peca[cont].getColor().name().equals("black")))
                        rei = peca[cont]; // checka o rei preto na vez dele
                }
            }
        };
        int Sourcex = rei.getPosX()/100;
        int Sourcey = rei.getPosY()/100;
        // Verificar se o rei pode escapar do xeque
        for (int row = Sourcex - 1; row <= Sourcex + 1; row++) {
            for (int col = Sourcey  - 1; col <= Sourcey + 1; col++) {
                if (rei.getMovementStrategy().validMov(rei,Sourcex, Sourcey, row, col)) {
                    // Se o rei pode se mover para uma posição segura, não há cheque-mate
                    return false;
                }
            }
        }

        // Verificar se alguma peça pode capturar a peça que está dando xeque ao rei
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = tabuleiroTemp[row][col];
                if(piece != null)
                return false;
                    if (!piece.getColor().equals(rei.getColor()) && !(piece instanceof King)) {
                        for (int targetRow = 0; targetRow < 8; targetRow++) {
                            for (int targetCol = 0; targetCol < 8; targetCol++) {
                                if (piece.getMovementStrategy().validMov(piece, piece.getPosX(), piece.getPosY(), selectedPiece.getPosX()/100,selectedPiece.getPosY()/100) && !isUnderAttack(targetRow, targetCol, selectedPiece.getColor(), tabuleiroTemp)) {
                                    // Se uma peça pode capturar a peça que está dando xeque ao rei,
                                    // então não há cheque-mate
                                    return false;
                                }
                            }
                        }
                    }
            }
        }

        // Se nenhuma das condições acima for verdadeira, então há cheque-mate
        return false;
    }

        // Verificar se uma posição está sob ataque
    private boolean isUnderAttack(int row, int col, PieceType.Color attackerColor, Piece[][] tabuleiro) {
    for (int targetRow = 0; targetRow < 8; targetRow++) {
        for (int targetCol = 0; targetCol < 8; targetCol++) {
            Piece piece = tabuleiro[targetRow][targetCol];
            if (piece != null && piece.getColor() != attackerColor) {
                if (piece.getMovementStrategy().validMov(piece, targetRow, targetCol, row, col)) {
                    return true;
                }
            }
        }
    }
    return false;
}


}
