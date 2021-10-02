package lab1;

public class Main {
    public static void main(String[] args) {

        Hero Gerold = new Hero(0, 0);

        Gerold.setAct(new Fly());
        Gerold.moveOn(new Point(1, 1));

        Gerold.setAct(new Run());
        Gerold.moveOn(new Point(-2, 2));

        Gerold.setAct(new Swim());
        Gerold.moveOn(new Point(3, -3));

        Point castle = new Point(4, 4);

        Gerold.setAct(new Walk());
        Gerold.moveOn(castle);
    }
}
