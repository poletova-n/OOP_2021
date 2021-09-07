package lab1;

public class Teleport implements Move
{
    @Override
    public void move(Point currentPosition, Point destPoint)
    {
        if(currentPosition.isPointsEquel(destPoint))
        {
            System.out.println("Wow! That's thing doesn't work");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }

    @Override
    public String getName()
    {
        return "Teleport";
    }
}
