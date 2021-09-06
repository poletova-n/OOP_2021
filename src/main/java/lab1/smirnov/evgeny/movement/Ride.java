package lab1.smirnov.evgeny.movement;

import lab1.smirnov.evgeny.Point;

public class Ride implements Movement {
    @Override
    public void move(Point currentPoint, Point newPoint) {
        System.out.println("I am riding!   to "+ newPoint.toString());
        currentPoint.clone(newPoint);
    }
}
