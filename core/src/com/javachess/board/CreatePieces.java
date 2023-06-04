package com.javachess.board;


import pieces.Piece;
import pieces.PieceType;
import pieces.builders.PieceBuilder;

public class CreatePieces {
    private Piece [][]piece;

    public CreatePieces(Piece[][] piece){
        //criação das peças pretas
        piece = new Piece[8][8];
        this.piece = piece;
    }


    public Piece[][] createPiece(){    //ESSA FUNÇÃO que retonar as peças instanciadas
        PieceBuilder pb = new PieceBuilder(); // builder
        //aqui estou definindo padroes gerais para todas essas peças pretas, eu seto a imagem, cordenada crio um e corndenada dps crio outro.
        pb.setColor(PieceType.Color.white);
        pb.setActive(true);
        //já aqui é personalizado devdo a imagem de cada 1;
        pb.setFigure("piece/white_rook.png");
        pb.setType("rook");
        pb.setCoord(0,0);
        piece[0][0] = pb.getResultRook();
        pb.setCoord(700,0);
        piece[7][0] = pb.getResultRook();
        //Cavalos pretos
        pb.setFigure("piece/white_knight.png");
        pb.setType("knight");
        pb.setCoord(100,0);
        piece[1][0] = pb.getResultKnigth();
        pb.setCoord(600,0);
        piece[6][0] = pb.getResultKnigth();
        //Bispo
        pb.setFigure("piece/white_bishop.png");
        pb.setType("bishop");
        pb.setCoord(200,0);
        piece[2][0] = pb.getResultBishop();
        pb.setCoord(500,0);
        piece[5][0] = pb.getResultBishop();
        //rei
        pb.setFigure("piece/white_king.png");
        pb.setType("king");
        pb.setCoord(400,0);
        piece[4][0] = pb.getResultKing();
        //rainha
        pb.setFigure("piece/white_queen.png");
        pb.setType("queen");
        pb.setCoord(300,0);
        piece[3][0] = pb.getResultQueen();

        //criação das peças preta
        pb.setColor(PieceType.Color.black);
        //já aqui é personalizado devdo a imagem de cada 1;
        pb.setFigure("piece/black_rook.png");
        pb.setType("rook");
        pb.setCoord(0,700);
        piece[0][7] = pb.getResultRook();
        pb.setCoord(700,700);
        piece[7][7] = pb.getResultRook();
        //Cavalos pretos
        pb.setFigure("piece/black_knight.png");
        pb.setType("knight");
        pb.setCoord(100,700);
        piece[1][7] = pb.getResultKnigth();
        pb.setCoord(600,700);
        piece[6][7] = pb.getResultKnigth();
        //Bispo
        pb.setFigure("piece/black_bishop.png");
        pb.setType("bishop");
        pb.setCoord(200,700);
        piece[2][7] = pb.getResultBishop();
        pb.setCoord(500,700);
        piece[5][7] = pb.getResultBishop();
        //rei
        pb.setFigure("piece/black_king.png");
        pb.setType("king");
        pb.setCoord(400,700);
        piece[4][7] = pb.getResultKing();
        //rainha
        pb.setFigure("piece/black_queen.png");
        pb.setType("queen");
        pb.setCoord(300,700);
        piece[3][7] = pb.getResultQueen();

        //criação dos peões
        for (int i = 0; i < 8; i++) {
            pb.setColor(PieceType.Color.white);
            pb.setFigure("piece/white_pawn.png");
            pb.setType("pawn");
            pb.setCoord(i*100,100);
            piece[i][1] = pb.getResultPawn();
            //criação de pecas pretas
            pb.setColor(PieceType.Color.black);
            pb.setFigure("piece/black_pawn.png");
            pb.setType("pawn");
            pb.setCoord(i*100,600);
            piece[i][6] = pb.getResultPawn();
        }
        return piece;
    }


}
