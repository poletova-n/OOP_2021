package Lab1;

public class Fly implements MoveStrategy {

    @Override
    public void move(Point a, Point b) {
        if (Point.isEqual(a, b)) {
            System.out.println("Hero is already in the right place!");
        } else {
            System.out.println("Hero is flying from point ( " + a.getX()
                    + ", " + a.getY() + " ) to point ( " + b.getX() + ", " + b.getY() + " ).");
        }
    }
}
