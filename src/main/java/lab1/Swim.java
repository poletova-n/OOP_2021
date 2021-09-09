package lab1;

public class Swim implements Move {

    @Override
    public void move(Point currentPoint, Point nextPoint) {

        System.out.println("I am swimming to " + currentPoint.toString());
        System.out.println("\n");
        currentPoint.copyPoint(nextPoint);

    }
}
