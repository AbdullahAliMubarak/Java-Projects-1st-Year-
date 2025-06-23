public class PtLine extends VectorObject {
    private int x1, y1;

    public PtLine(int anId, int ax, int ay, int bx, int by) {
        super(anId, ax, ay);
        this.x1 = bx;
        this.y1 = by;
    }

    @Override
    public void draw(char[][] matrix) {
        drawLine(matrix, x, y, x1, y1);
    }

    private void drawLine(char[][] matrix, int x0, int y0, int x1, int y1) {
        boolean steep = Math.abs(y1 - y0) > Math.abs(x1 - x0);
        if (steep) {
            int temp = x0; x0 = y0; y0 = temp;
            temp = x1; x1 = y1; y1 = temp;
        }
        if (x0 > x1) {
            int temp = x0; x0 = x1; x1 = temp;
            temp = y0; y0 = y1; y1 = temp;
        }

        int dx = x1 - x0;
        int dy = Math.abs(y1 - y0);
        int error = dx / 2;
        int ystep = (y0 < y1) ? 1 : -1;
        int y = y0;

        for (int x = x0; x <= x1; x++) {
            if (steep) {
                if (y >= 0 && y < matrix[0].length && x >= 0 && x < matrix.length) {
                    matrix[x][y] = '*';
                }
            } else {
                if (x >= 0 && x < matrix[0].length && y >= 0 && y < matrix.length) {
                    matrix[y][x] = '*';
                }
            }
            error -= dy;
            if (error < 0) {
                y += ystep;
                error += dx;
            }
        }
    }
}