package Lab1;

public class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static boolean isEqual(Point a, Point b) {
        return a.x == b.x && a.y == b.y;
    }
}
