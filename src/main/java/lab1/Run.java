package lab1;

public class Run implements Move
{
    @Override
    public void move(Point currentPosition, Point destPoint)
    {
        if(currentPosition.isPointsEquel(destPoint))
        {
            System.out.println("You can't run on the same spot, it looks silly");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }

    @Override
    public String getName()
    {
        return "Run";
    }
}
