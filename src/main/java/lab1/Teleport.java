package lab1;

public class Teleport implements Move {

    @Override
    public void move(Point currentPoint, Point nextPoint) {

        System.out.println("Let's go. In and out. Two minute adventure to " + currentPoint.toString());
        System.out.println("\n");
        currentPoint.copyPoint(nextPoint);

    }
}
