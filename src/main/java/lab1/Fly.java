package lab1;

public class Fly implements Move {

    @Override
    public void move(Point currentPosition, Point destPoint)
    {
        if(currentPosition.isPointsEquel(destPoint))
        {
            System.out.println("You can't fly on the same spot");
            return;
        }

        currentPosition.setPoint(destPoint.getX(), destPoint.getY());
    }
    @Override
    public String getName()
    {
        return "Fly";
    }
}