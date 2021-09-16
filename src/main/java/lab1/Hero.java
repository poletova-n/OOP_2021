package lab1;

public class Hero {
    private Move m;

    private Point currPosition = new Point(0,0);

    Hero() {
        m = new Fly();
    }

    Hero(Move move) {
        m = move;
    }

    public void move(Point point) {
        currPosition.setX(currPosition.getX() + point.getX());
        currPosition.setY(currPosition.getY() + point.getY());
        System.out.println("X: " + currPosition.getX() + "  Y: " + currPosition.getY());
        m.move(point);
    }

    public void changeModeOfTransportation(Move move) {
        m = move;
    }
}
