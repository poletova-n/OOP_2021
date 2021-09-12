package lab1;

public class Swim implements Move{
    @Override
    public void move(Point newPoint){
        System.out.println("Now, i'm swimming to " + newPoint.toString());

    }
}
