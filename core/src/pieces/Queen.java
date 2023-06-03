package pieces;

public class Queen extends Piece {
    public Queen(boolean active, PieceType.Color color, String figure,int posX,int posY) {
        super(active, color, figure,posX,posY);
    }

    @Override
    public boolean validMov(int x, int y) { // para verificar a rainha, peguei todas as regras do bispo e da torre


        if(x == getPosX()/100 || y == getPosY()/100)
            return true;

        for (int i = getPosX()/100,j=getPosY()/100; i < 7 || j< 7 ; i++, j++){
            if(x == i && y ==j)
                return true;
        }
        for (int i = getPosX()/100,j=getPosY()/100; i >= 0 || j >=0 ; i--, j--){
            if(x == i && y ==j)
                return true;
        }
        for (int i = getPosX()/100,j=getPosY()/100; i >= 0 || j< 7 ; i--, j++){
            if(x == i && y ==j)
                return true;
        }
        for (int i = getPosX()/100,j=getPosY()/100; i < 7 || j >= 0  ; i++, j--){
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
