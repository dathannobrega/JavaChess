package pieces;

public class Bishop extends Piece {
    public Bishop(boolean active, PieceType.Color color, String figure,int posX,int posY,String type) {
        super(active, color, figure,posX,posY,type);
    }

    @Override
    public boolean validMov(int x, int y) {
        x = x * 100;
        y = y * 100;

        for (int i = getPosX(),j=getPosY(); i < 7 || j< 7 ; i++, j++){
            if(x == i && y ==j)
                return true;
        }
        for (int i = getPosX(),j=getPosY(); i >= 0 || j >=0 ; i--, j--){
            if(x == i && y ==j)
                return true;
        }
        for (int i = getPosX(),j=getPosY(); i >= 0 || j< 7 ; i--, j++){
            if(x == i && y ==j)
                return true;
        }
        for (int i = getPosX(),j=getPosY(); i < 7 || j >= 0  ; i++, j--){
            if(x == i && y ==j)
                return true;
        }

        return false;
    }

    @Override
    public void move(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
    }
}
