package domain.board;

import domain.pieces.Piece;
import domain.pieces.PieceType;
import domain.pieces.Rook;

public class Board {
    private Piece[][] board;


    public Board() {

        //aqui criamos as peças porem não estão estanciadas
        board = new Piece[8][8];
    }

    public void Initialize(){
        //inicia as peças brancas;

        board[0][0] = new Rook(true, PieceType.Color.BRANCA,"resources/images/white_rook.png");s
        board[0][7] = new Rook();

    }
    public void move(Position origin, Position destiny){
    }

    public boolean getXeque(){
        return false;
    }

    public List<Position> (Position Origin){

    }

}
