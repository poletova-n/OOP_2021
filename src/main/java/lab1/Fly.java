package lab1;

public class Fly implements Move{
    @Override
    public void move(Point newPoint){
        System.out.println("Now, I'm flying to " + newPoint.toString());

    }
}
