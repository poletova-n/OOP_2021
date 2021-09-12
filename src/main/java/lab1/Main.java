package Lab1;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero();
        hero1.setMoveStrategy(new Fly());
        hero1.move(new Point(1, 2), new Point(3, 4));
    }
}
