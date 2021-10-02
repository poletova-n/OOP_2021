package lab1;

public class Run implements Move {

    @Override
    public void move(Point newPoint) {
        System.out.println("Hero runs to point (" + newPoint.x + ", " + newPoint.y + ")" );
    }
}