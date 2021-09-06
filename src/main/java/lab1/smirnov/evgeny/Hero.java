package lab1.smirnov.evgeny;

import lab1.smirnov.evgeny.movement.*;

public class Hero {
    private Movement movement;
    private Point currentPoint = new Point(0d,0d);

    public Hero(String moving) {
        setMovement(moving);
    }
    public void setMovement(String moving) {
        switch (moving.toLowerCase()) {
            case "fly" -> movement = new Fly();
            case "walk" -> movement = new Walk();
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
