package lab1;

public class Run implements  Move{
    @Override
    public void move(Point newPoint) {
        System.out.println("Now, i'm running to " + newPoint.toString());

    }
}
