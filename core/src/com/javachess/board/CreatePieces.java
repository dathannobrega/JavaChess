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
        pb.setColor(PieceType.Color.BRANCA);
        pb.setActive(true);
        //já aqui é personalizado devdo a imagem de cada 1;
        pb.setFigure("piece/white_rook.png");
        pb.setCoord(0,0);
        piece[0][0] = pb.getResult();
        pb.setCoord(700,0);
        piece[7][0] = pb.getResult();
        //Cavalos pretos
        pb.setFigure("piece/white_knight.png");
        pb.setCoord(100,0);
        piece[1][0] = pb.getResult();
        pb.setCoord(600,0);
        piece[6][0] = pb.getResult();
        //Bispo
        pb.setFigure("piece/white_bishop.png");
        pb.setCoord(200,0);
        piece[2][0] = pb.getResult();
        pb.setCoord(500,0);
        piece[5][0] = pb.getResult();
        //rei
        pb.setFigure("piece/white_king.png");
        pb.setCoord(400,0);
        piece[4][0] = pb.getResult();
        //rainha
        pb.setFigure("piece/white_queen.png");
        pb.setCoord(300,0);
        piece[3][0] = pb.getResult();

        //criação das peças preta
        pb.setColor(PieceType.Color.PRETA);
        //já aqui é personalizado devdo a imagem de cada 1;
        pb.setFigure("piece/black_rook.png");
        pb.setCoord(0,700);
        piece[0][7] = pb.getResult();
        pb.setCoord(700,700);
        piece[7][7] = pb.getResult();
        //Cavalos pretos
        pb.setFigure("piece/black_knight.png");
        pb.setCoord(100,700);
        piece[1][7] = pb.getResult();
        pb.setCoord(600,700);
        piece[6][7] = pb.getResult();
        //Bispo
        pb.setFigure("piece/black_bishop.png");
        pb.setCoord(200,700);
        piece[2][7] = pb.getResult();
        pb.setCoord(500,700);
        piece[5][7] = pb.getResult();
        //rei
        pb.setFigure("piece/black_king.png");
        pb.setCoord(400,700);
        piece[4][7] = pb.getResult();
        //rainha
        pb.setFigure("piece/black_queen.png");
        pb.setCoord(300,700);
        piece[3][7] = pb.getResult();

        //criação dos peões
        for (int i = 0; i < 8; i++) {
            pb.setColor(PieceType.Color.BRANCA);
            pb.setFigure("piece/white_pawn.png");
            pb.setCoord(i*100,100);
            piece[i][1] = pb.getResult();
            //criação de pecas pretas
            pb.setColor(PieceType.Color.PRETA);
            pb.setFigure("piece/black_pawn.png");
            pb.setCoord(i*100,600);
            piece[i][6] = pb.getResult();
        }
        return piece;
    }


}
