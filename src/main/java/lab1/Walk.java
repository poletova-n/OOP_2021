package lab1;

public class Walk implements MovingMethod {
    @Override
    public void move(Point currentPosition, Point destPoint) {

        if (currentPosition.comparePoints(destPoint)){
            System.out.println("Are you trying to make a hop?");
            return;
        }

        if (currentPosition.getDistance(destPoint) > 1){
            System.out.println("You can't move more than 1 step using your legs!");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }

    public String getName(){
        return "Walk";
    }

}
