package lab1;

public class Run implements Move{
    public void move(Point a, Point b) {
        System.out.println("Hero run to the point[" + b.getX() + ";" + b.getY() + "]");
    }
}
