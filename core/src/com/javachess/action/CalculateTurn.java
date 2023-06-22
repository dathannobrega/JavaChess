package com.javachess.action;

import pieces.King;
import pieces.Piece;

//o Calculate Turn é uma classe responsavel por "ver o futuro" é ela que possuiu as funçoes de ver se esta em check,
// ver se aconteceu um check mate e ela que pinta o tabuleiro para as jogadas permitidas
public class CalculateTurn {
    static Piece [][] tabuleiro;
    Piece selectedPiece;

    public CalculateTurn(Piece[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean isChecked(boolean vezBranco){

        for (Piece[] peca: tabuleiro){ //esse for passa por cada camada do tabuleiro verificando
            for (int cont = 0; cont < 8; cont++) {
                if(peca[cont] != null && peca[cont] instanceof King){
                    if(vezBranco && (peca[cont].getColor().name() == "white")) // seleciona o rei branco
                        selectedPiece = peca[cont]; // seleciono o rei
                    else
                        selectedPiece = peca[cont];
                }
            }
        }

        //aqui vejo se existe alguma peca do tabuleiro inimiga que pode ir para a posição do rei
        for (Piece[] peca: tabuleiro){ //esse for passa por cada camada do tabuleiro verificando
            for (int cont = 0; cont < 8; cont++) {
                if(peca[cont] != null && (peca[cont].getColor() != selectedPiece.getColor())){
                    if(peca[cont].validMov(selectedPiece.getPosX()/100, selectedPiece.getPosY()/100)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //essa função calcula se a peca esta "passando em cima de outra peca."
    static public boolean isOverwrite(Piece peca,int x,int y){
        int myX = peca.getPosX()/100;//posiçoes da peca convertida
        int muY = peca.getPosY()/100;

            for (int i = myX, j = muY; i <= x && j<=y; i++,j++) {
                if (tabuleiro[i][j] != null) {
                    return true;
                }
                if (i == x)
                    x--;
                if (j == y)
                    j--;
            }

            for (int i = myX, j = muY; i >= x && j >= y; i--,j--) {
                if(tabuleiro[i][j] != null){
                    return true;
                }
                if(i == x)
                    x++;
                if(j== y)
                    j++;
            }

            for (int i = myX, j = muY; i <= x && j >= y; i++,j--) {
                if(tabuleiro[i][j] != null){
                    return true;
                }
                if(i == x)
                    x--;
                if(j== y)
                    j++;
            }

            for (int i = myX, j = muY; i <= x && j >= y; i--,j++) {
                if(tabuleiro[i][j] != null){
                    return true;
                }
                if(i == x)
                    x++;
                if(j== y)
                    j--;
            }
        return false;
    }
}
