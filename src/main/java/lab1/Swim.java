package lab1;

public class Swim implements Move {

    @Override
    public void move(Point newPoint) {
        System.out.println("Hero swims to point (" + newPoint.x + ", " + newPoint.y + ")" );
    }
}