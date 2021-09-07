package lab1;

public class Spaceship implements MovingMethod {
    @Override
    public void move(Point currentPosition, Point destPoint) {

        if (currentPosition.comparePoints(destPoint)){
            System.out.println("So, I said that you have no limits to move, but you decided to move at the place where you already are.");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }

    @Override
    public String getName() {
        return "Spaceship";
    }

}
