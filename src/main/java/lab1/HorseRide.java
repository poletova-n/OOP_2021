package lab1;

public class HorseRide implements Move {

    @Override
    public void move(Point a, Point b) {
        if (a.equals(b)) {
            System.out.println("- Take a rest, Roach");
            return;
        }
        System.out.println("- Move it, Roach");
        a.setX(b.getX());
        a.setY(b.getY());
    }
    @Override
    public String getMoveWay() {
        return "Horse ride";
    }
}
