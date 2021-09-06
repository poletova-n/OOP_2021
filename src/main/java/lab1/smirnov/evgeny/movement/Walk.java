package lab1.smirnov.evgeny.movement;

import lab1.smirnov.evgeny.Point;

public class Walk implements Movement {
    @Override
    public void move(Point currentPoint, Point newPoint) {
        System.out.println("I am walking!  to "+ newPoint.toString());
        currentPoint.clone(newPoint);
    }
}
