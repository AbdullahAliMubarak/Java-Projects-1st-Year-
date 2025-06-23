public class VLine extends VectorObject {
    private int length;

    public VLine(int anId, int ax, int ay, int len) {
        super(anId, ax, ay);
        this.length = len;
    }

    @Override
    public void draw(char[][] matrix) {
        for (int i = y; i < y + length && i < matrix.length; i++) {
            matrix[i][x] = '*';
        }
    }
}