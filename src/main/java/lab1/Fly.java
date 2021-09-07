package lab1;

public class Fly implements Move {
    @Override
    public void move(Point currentPosition, Point destPoint) {

        if (currentPosition.comparePoints(destPoint)){
            System.out.println("Ok, let's imagine that you're trying to fly up...");
            return;
        }

        if (currentPosition.getDistance(destPoint) > 100){
            System.out.println("You can't move more than 100 steps using wings!");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }

    @Override
    public String getName() {
        return "Fly";
    }

}
