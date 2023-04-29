package domain.pieces;

public abstract class Piece {
    private boolean active;
    private final PieceType.Color color;

    private String figure;

    //construtor
    public Piece(boolean active, PieceType.Color color, String figure) {
        this.active = active;
        this.color = color;
        this.figure = figure;
    }

    // esses Metodos abstratos que cada filho tera e será personalizado;
    abstract void validMov();

    abstract void move();

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

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
