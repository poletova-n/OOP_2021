package lab1;

public class Horse implements Move {
    public void move(Point a, Point b) {
        System.out.println("Hero rode his horse to the point[" + b.getX() + ";" + b.getY() + "]");
    }
}
