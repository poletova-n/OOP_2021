package lab1;

public class Walk implements Move {

    @Override
    public void move(Point currentPoint, Point nextPoint) {

        System.out.println("It's time to take a walk, let's go to " + currentPoint.toString());
        System.out.println("\n");
        currentPoint.copyPoint(nextPoint);

    }
}
