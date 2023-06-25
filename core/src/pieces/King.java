package pieces;

public class King extends Piece {
    public King(boolean active, PieceType.Color color, String figure,int posX,int posY,String type) {
        super(active, color, figure,posX,posY,type);
    }
    @Override
    public boolean validMov(int x, int y) {

        return !(y > getPosY()/100 + 1 || x > getPosX()/100 + 1 || y < getPosY()/100 - 2 || x < getPosX()/100 - 2);
    }
}
