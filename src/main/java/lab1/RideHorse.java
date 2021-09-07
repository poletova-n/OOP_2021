package lab1;

public class RideHorse implements Move 
{
    @Override
    public void move(Point point)
    {
        System.out.println("Hero is riding a horse at " + point.toString());
    }
}
