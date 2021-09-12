package lab1;

public class Walk implements Move{
    @Override
    public void move(Point newPoint) {
        System.out.println("Now, I'm walking to " + newPoint.toString());
    }
}
