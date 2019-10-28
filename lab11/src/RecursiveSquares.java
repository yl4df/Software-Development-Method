
/******************************************************************************
 * Compilation: javac RecursiveSquares.java Execution: java RecursiveSquares N Dependencies: StdDraw.java Plot an order
 * N tree of overlapping gray squares. % java RecursiveSquares 4
 ******************************************************************************/

public class RecursiveSquares {

    // plot a square, centered on (x, y) of the given side length
    // with a light gray background and black border
    public static void drawSquare(double x, double y, double size) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, size / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, size / 2);
    }

    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0)
            return;

        // 2.2 ratio looks good
        double ratio = 2.2;

        // PATTERN A
        // recursively draw 4 smaller trees of order n-1
        drawSquare(x, y, size);
        draw(n - 1, x - size / 2, y - size / 2, size / ratio);    // lower left
        draw(n - 1, x - size / 2, y + size / 2, size / ratio);    // upper left
        draw(n - 1, x + size / 2, y - size / 2, size / ratio);    // lower right
        draw(n - 1, x + size / 2, y + size / 2, size / ratio);    // upper right

        // PATTERN B
        draw(n - 1, x - size / 2, y + size / 2, size / ratio);    // upper left
        draw(n - 1, x + size / 2, y + size / 2, size / ratio);    // upper right
        drawSquare(x, y, size);
        draw(n - 1, x - size / 2, y - size / 2, size / ratio);    // lower left
        draw(n - 1, x + size / 2, y - size / 2, size / ratio);    // lower right

        // PATTERN C
        draw(n - 1, x - size / 2, y + size / 2, size / ratio);    // upper left

        draw(n - 1, x - size / 2, y - size / 2, size / ratio);    // lower left
        draw(n - 1, x + size / 2, y - size / 2, size / ratio);    // lower right
        drawSquare(x, y, size);
        draw(n - 1, x + size / 2, y + size / 2, size / ratio);    // upper right
        // PATTERN D

        draw(n - 1, x - size / 2, y - size / 2, size / ratio);    // lower left
        draw(n - 1, x - size / 2, y + size / 2, size / ratio);    // upper left
        draw(n - 1, x + size / 2, y - size / 2, size / ratio);    // lower right
        draw(n - 1, x + size / 2, y + size / 2, size / ratio);    // upper right
        drawSquare(x, y, size);
    }

    // read in a command-line argument N and plot an order N recursive
    // squares pattern
    public static void main(String[] args) {
        int N = 4;
        double x = 0.5, y = 0.5;   // center of square
        double size = 0.5;         // side length of square
        draw(N, x, y, size);
    }

}
