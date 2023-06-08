package pieces;

public class King extends Piece {
    public King(boolean active, PieceType.Color color, String figure,int posX,int posY,String type) {
        super(active, color, figure,posX,posY,type);
    }
    @Override
    public boolean validMov(int x, int y) {
        x = x * 100;
        y = y * 100;
        if(y == getPosY() + 100 || getPosX() + 100 == x){
            return true;
        } else
            return false;
    }

    @Override
    public void move(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
    }
}
