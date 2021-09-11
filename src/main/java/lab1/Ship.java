package lab1;

public class Ship implements Move{
    @Override
    public void move(Point currentPosition, Point destPoint)
    {
        if(currentPosition.isPointsEquel(destPoint))
        {
            System.out.println("I think your ship is sinking");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }

    @Override
    public String getName()
    {
        return "ship";
    }

}
