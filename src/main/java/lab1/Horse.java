package lab1;

public class Horse implements Move {

    @Override
    public void move(Point currentPoint, Point nextPoint) {

        System.out.println("Go ahead Plotva, let's go to " + currentPoint.toString());
        System.out.println("\n");
        currentPoint.copyPoint(nextPoint);

    }
}
