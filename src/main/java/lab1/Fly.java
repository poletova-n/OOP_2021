package lab1;

public class Fly implements Move {

    @Override
    public void move(Point newPoint) {
        System.out.println("Hero flys to point (" + newPoint.getX() + ", " + getY + ")" );
    }
}
