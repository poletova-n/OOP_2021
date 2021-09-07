package lab1.movement;

import lab1.Point;

public class Cycle implements Movement {
    @Override
    public void move( Point currentPoint, Point newPoint) {
        System.out.println("I am cycling!  to "+ newPoint.toString());
        currentPoint.clone(newPoint);
    }
}
