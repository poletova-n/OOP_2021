package lab1;

import lab1.movement.*;

public class Hero {
    private Movement movement;
    private final Point currentPoint = new Point(0d,0d);

    public Hero(String moving) {
        setMovement(moving);
    }
    public void setMovement(String moving) {
        switch (moving.toLowerCase()) {
            case "fly" -> movement = new Fly();
            case "swim" -> movement = new Swim();
            case "ride" -> movement = new Ride();
            case "cycle" -> movement = new Cycle();
            default -> movement = new Walk();
        }
    }
    public void startMoving(Point newPoint) {
        movement.move(currentPoint, newPoint);
    }
}
