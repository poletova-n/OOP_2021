package lab1;

public class Hero {

    private Move activity;
    private Point currentPoint = new Point(0, 0);

    public Hero(String moving) {
        setActivity(moving);
    }

    public void setActivity(String moving) {
        switch (moving.toLowerCase()) {
            case "walk" -> activity = new Walk();
            case "ride" -> activity = new Horse();
            case "swim" -> activity = new Swim();
            case "fly" -> activity = new Fly();
            case "teleport" -> activity = new Teleport();
            default -> activity = new Walk();
        }
    }

    public void startMovement(Point nextPoint) {

        activity.move(currentPoint, nextPoint);
    }
}
