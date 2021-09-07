package lab1;

public class Fly implements Move {
    int i = 1;

    @Override
    public void move(Point a, Point b) {
        System.out.println("I believe I can fly");
    }
}
