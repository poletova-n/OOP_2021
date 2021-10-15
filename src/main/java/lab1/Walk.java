package lab1;

public class Walk implements Move {

    @Override
    public void move(Point newPoint) {
        System.out.println("Hero walks to point (" + newPoint.getX() + ", " + newPoint.getY() + ")" );
    }
}