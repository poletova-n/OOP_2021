package lab1;

public class Horse implements Move {
    @Override
    public void move(Point point) {
        System.out.println("Hero is riding " + point.coordinates());
    }
}
