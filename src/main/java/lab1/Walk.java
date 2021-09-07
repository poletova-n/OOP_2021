package lab1;

public class Walk implements Move 
{
    @Override
    public void move(Point point) 
    {
        System.out.println("Hero is walking at " + point.toString());
    }
}
