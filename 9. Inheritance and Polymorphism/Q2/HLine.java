public class HLine extends VectorObject {
    private int length;

    public HLine(int anId, int ax, int ay, int len) {
        super(anId, ax, ay);
        this.length = len;
    }

    @Override
    public void draw(char[][] matrix) {
        for (int i = x; i < x + length && i < matrix[0].length; i++) {
            matrix[y][i] = '*';
        }
    }
}