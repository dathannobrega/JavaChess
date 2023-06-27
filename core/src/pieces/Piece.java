package pieces;

import com.badlogic.gdx.graphics.Texture;
import pieces.strategy.MovementStrategy;

public abstract class Piece {
    private final PieceType.Color color;
    private MovementStrategy movementStrategy;
    private Texture figure;
    private String type;
    private int posX;
    private int posY;

    //construtor
    public Piece(MovementStrategy movementStrategy,PieceType.Color color, String figure, int posX, int posY, String type) {
        this.movementStrategy = movementStrategy;
        this.color = color;
        this.figure = new Texture(figure);
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }

    // esses Metodos abstratos que cada filho tera e será personalizado;
    public boolean validMov(int x, int y){
        return movementStrategy.validMov(x, y);
    }
    
    public void move(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
    }

    public void upgrade(int x, int y){
        System.out.println("Peca: " + this.getType() + " " + this.getColor());
        System.out.println("De: [" + this.getPosX()/100 + "][" + this.getPosY()/100 + "]");
        System.out.println("Para: [" + x + "][" + y + "]");
    }

    //Metodos Gets e Setters
    public PieceType.Color getColor() {
        return color;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
