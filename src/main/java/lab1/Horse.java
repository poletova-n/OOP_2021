package lab1;

public class Horse implements Move{
    @Override
    public void move(Point currentPosition, Point destPoint) {

        if (currentPosition.comparePoints(destPoint)){
            System.out.println("The horse trampled on the spot.");
            return;
        }

        if (currentPosition.getDistance(destPoint) > 50){
            System.out.println("You can't move more than 50 steps using your horse!");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }

    @Override
    public String getName() {
        return "Horse";
    }

}
