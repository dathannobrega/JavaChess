package pieces;

public class PieceType { // classe usada para atributos gerais das Peças
    public enum Color {
        black(0),
        white(1);
        public int color;
        Color(int color) {
            this.color = color;
        }

    }



}
