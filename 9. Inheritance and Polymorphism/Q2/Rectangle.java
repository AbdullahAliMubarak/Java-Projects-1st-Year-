public class Rectangle extends VectorObject {
    private int xLength, yLength;

    public Rectangle(int anId, int ax, int ay, int xLen, int yLen) {
        super(anId, ax, ay);
        this.xLength = xLen;
        this.yLength = yLen;
    }

    @Override
    public void draw(char[][] matrix) {
        for (int i = y; i < y + yLength && i < matrix.length; i++) {
            for (int j = x; j < x + xLength && j < matrix[0].length; j++) {
                matrix[i][j] = '*';
            }
        }
    }
}