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
        int getX, getY;
        if(Gdx.input.isTouched()){
            getX = (int) Gdx.input.getX()/100;
            getY = Math.abs((int) Gdx.input.getY()/100 -7); // por algum motivo o y esta errado e esta invertido pois a posicao 0,0 deve ficar no canto inferior esquerdo

            if(selectedPiece == null) { // é pq não tem nada selecionado
                for (Piece[] peca : getPieces()) {
                    for (int cont = 0; cont < 8; cont++) {
                        if (peca[cont] != null)
                            if (peca[cont].getPosX() / 100 == getX && peca[cont].getPosY() / 100 == getY) {
                                selectedPiece = peca[cont];
                            }
                    }

                }
            } else { // tem algo selecionado
                Piece[][] pieces = this.getPieces();
            //AQUI È ONDE ESTOU FAZENDO A TENTATIVA DE PEGAR A PEÇA E MOVER PRA OUTRO LUGAR SUBSTITUINDO A POS
                for (int i =0; i <8;i ++) {
                    for (int j = 0; j < 8; j++) {
                        if (pieces[i][j] != null)
                            if (pieces[i][j] == selectedPiece){ // faz um comparativo para achar a peca selecionada anteriormente
                                if(pieces[i][j].validMov(getX,getY) && this.verifyEntity(selectedPiece,getX,getY)){
                                    pieces[getX][getY] = selectedPiece;
                                    pieces[i][j] = null;
                                    //Aqui vai ficar um observer para coletar os logs
                                    //
                                    //
                                }
                                selectedPiece = null; // limpa para o proximo movimento
                            }

                    }

                }

            }
            System.out.println("Tabuleiro: X = "+ getX + " Y=" + getY);
        }
        return false;
    }


    //ESSA FUNÇÂO QUE VOU UTLIZAR PARA ARASTAR E SOLTAR O OBJETO // quando o OBJETO VAI ANDAR JUNTO COM O MOUSE
//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        int getX, getY;
//            getX = (int) Gdx.input.getX();
//            getY = Math.abs((int) Gdx.input.getY() - 700); // por algum motivo o y esta errado e esta invertido pois a posicao 0,0 deve ficar no canto inferior esquerdo
//
//            for (Piece[] peca : getPieces()) {
//                for(int cont = 0; cont < 8; cont++){
//                    if(peca[cont] != null)
//                        if(peca[cont].getPosX()/100 == getX && peca[cont].getPosY()/100 == getY){
//                            System.out.println("Cliquei na peca" + peca[cont].getColor());
//                            System.out.println("peça: X = "+ peca[cont].getPosX()/100 + " Y=" + peca[cont].getPosY()/100);
//                        }
//                }
//
//      }
//            System.out.println("Tabuleiro: X = "+ getX + " Y=" + getY);
//        return true;
//    }

}
