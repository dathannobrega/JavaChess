package pieces;

public class Pawn extends Piece {
    public Pawn(boolean active, PieceType.Color color, String figure,int posX,int posY) {
        super(active, color, figure,posX,posY);
    }

    @Override
    public void validMov(int x, int y) {

    }

    @Override
    public void move(int x , int y) {
        if(getPosX() == x && getPosY() == y){
            System.out.println("entrou peao");
            this.setPosX(x);
            this.setPosY(y);
        } else {
            System.out.println("mov Invalido!!");
        }

    }
}
