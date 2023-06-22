package com.javachess.action;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import pieces.Piece;
public class ImpChessInputProcessor extends ChessInputProcessor{
    private Piece selectedPiece;

    public ImpChessInputProcessor(OrthographicCamera camera, Piece[][] pieces) {
        super(camera, pieces);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int getX, getY,pixX,pixY;
        if(Gdx.input.isTouched()){
            getX = Gdx.input.getX()/100;
            getY = Math.abs( Gdx.input.getY()/100 -7); // por algum motivo o y esta errado e esta invertido pois a posicao 0,0 deve ficar no canto inferior esquerdo
            pixY = getY*100;
            pixX = getX*100;

            if(calculateTurn.isChecked(isVezBranco()))
                System.out.println("esta de Check");

            if(selectedPiece == null) { // é porque não tem nada selecionado
                for (Piece[] peca : getPieces()) {
                    for (int cont = 0; cont < 8; cont++) {
                        if (peca[cont] != null){
                            if (peca[cont].getPosX() / 100 == getX && peca[cont].getPosY() / 100 == getY) {
                                if(confirmaVez(peca[cont])){// se for a vez do branco a peca é selecionada
                                    selectedPiece = peca[cont];
                                    selectedPiece.setFigure("piece/"+peca[cont].getColor().name() + "_"+peca[cont].getType()+"_"+ "selected.png");
                                }
                            }
                        }
                    }
                }
            } else { // tem algo selecionado
                Piece[][] pieces = this.getPieces();
            //AQUI È ONDE ESTOU FAZENDO A TENTATIVA DE PEGAR A PEÇA E MOVER PRA OUTRO LUGAR SUBSTITUINDO A POS
                for (int i =0; i <8;i ++) {
                    for (int j = 0; j < 8; j++) {
                        if (pieces[i][j] != null) {
                            if (pieces[i][j] == selectedPiece) { // faz um comparativo para achar a peca selecionada anteriormente
                                if (pieces[i][j].validMov(getX, getY) && verifyEntity(selectedPiece, getX, getY)) {
                                    if (isPawn(selectedPiece)) {// verifica se a peca é um peao se sim tranforma em queen
                                        if (verifyUpgrade(selectedPiece, getY))
                                            selectedPiece = upgradePiece(selectedPiece,pixX,pixY);
                                    }
                                    pieces[i][j].move(pixX, pixY);
                                    pieces[getX][getY] = selectedPiece;
                                    pieces[i][j] = null;
                                    trocaVez();
                                    //Aqui vai ficar um observer para coletar os logs
                                    //
                                    //
                                }

                            }
                        }
                    }
                }//aqui eu reseto a imagem e retiro a seleçao na peça
                selectedPiece.setFigure("piece/" + selectedPiece.getColor().name() + "_" + selectedPiece.getType() + ".png");
                selectedPiece = null; // limpa para o proximo movimento
            }
            System.out.println("Tabuleiro: X = "+ getX + " Y=" + getY);
        }
        return false;
    }
}
