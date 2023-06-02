package pieces;

public class Knight extends Piece {
    public Knight(boolean active, PieceType.Color color, String figure,int posX,int posY) {
        super(active, color, figure,posX,posY);
    }
    @Override
    public boolean validMov(int x, int y) {
        if(super.validMov(x,y)){

        }
        x = x*100;
        y = y*100;
        if(getPosX() == x && getPosY()+100  == y ){ // 100 pois é necessario uma posição completa
            move(x,y);
            return true;
        } else {
            System.out.println("MOVIMENTO INVALIDO");
            return false;
        }
    }

    @Override
    public void move(int x , int y) {
        this.setPosX(x);
        this.setPosY(y);
    }
}
