package lab1.movement;

import lab1.Point;

public class Walk implements Movement {
    @Override
    public void move(Point currentPoint, Point newPoint) {
        System.out.println("I am walking!  to "+ newPoint.toString());
        currentPoint.clone(newPoint);
    }
}
