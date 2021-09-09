package lab1;

public class Fly implements Move {

    @Override
    public void move(Point currentPoint, Point nextPoint) {

        System.out.println("WOW! I am flying to " + currentPoint.toString());
        System.out.println("\n");
        currentPoint.copyPoint(nextPoint);
    }
}
