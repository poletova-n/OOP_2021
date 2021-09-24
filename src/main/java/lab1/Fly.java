package lab1;

public class Fly implements Move {
    public void move(Point a, Point b) {
        System.out.println("Hero flew to the point[" + b.getX() + ";" + b.getY() + "]");
    }
}
