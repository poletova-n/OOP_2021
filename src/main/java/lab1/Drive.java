package lab1;

public class Drive implements Move{
    @Override
    public void move(Point point) {
        System.out.println("Hero is driving " + point.coordinates());
    }
}
