package lab1;

public class Hero {
    private Move m;
    private Point currentPosition = new Point(0,0);

    Hero() {

        m = new Fly();
    }

    Hero(Move move) {

        m = move;
    }

    public void move(Point point){
        currentPosition.setX(currentPosition.getX() + point.getX());
        currentPosition.setY(currentPosition.getY() + point.getY());
        m.move(point);
        System.out.println("Position changed to: X: " + currentPosition.getX() + "  Y: " + currentPosition.getY());
    }

    public void changeMovingMode(Move move) {
        m = move;
    }
}