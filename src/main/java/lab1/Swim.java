package lab1;

public class Swim implements Move 
{
    @Override
    public void move(Point point) 
    {
        System.out.println("Hero is swimming at " + point.toString());
    }
}
