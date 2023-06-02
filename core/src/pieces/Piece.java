package pieces;

import com.badlogic.gdx.graphics.Texture;

public abstract class Piece {
    private boolean active;
    private final PieceType.Color color;
    private Texture figure;

    private int posX;
    private int posY;

    //construtor
    public Piece(boolean active, PieceType.Color color, String figure,int posX,int posY) {
        this.active = active;
        this.color = color;
        this.figure = new Texture(figure);
        this.posX = posX;
        this.posY = posY;
    }

    // esses Metodos abstratos que cada filho tera e será personalizado;
    public boolean validMov(int x, int y) { // Função para verificar se existe uma peca amiga "" na pos
        return true;
    }

    public void move(int x, int y) {

    }

    //Metodos Gets e Setters
    public PieceType.Color getColor() {
        return color;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Texture getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = new Texture(figure);
    }

    public void setFigure(Texture figure) {
        this.figure = figure;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
