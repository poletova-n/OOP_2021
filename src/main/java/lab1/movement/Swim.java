package lab1.movement;

import lab1.Point;

public class Swim implements Movement {
    @Override
    public void move(Point currentPoint, Point newPoint) {
        System.out.println("I am swimming! to "+ newPoint.toString());
        currentPoint.clone(newPoint);
    }
}
