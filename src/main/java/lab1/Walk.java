package lab1;

public class Walk implements Move {
    public void move(Point a, Point b) {
        System.out.println("Hero walk to the point[" + b.getX() + ";" + b.getY() + "]");
    }
}
