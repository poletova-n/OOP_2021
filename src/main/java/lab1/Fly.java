package lab1;

public class Fly implements Move {
    @Override
    public void move(Point point) {
        System.out.println("Hero is flying " + point.coordinates());
    }
}
