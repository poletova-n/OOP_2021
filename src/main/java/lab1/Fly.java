package lab1;

public class Fly implements Move {

    @Override
    public void move(Point a, Point b) {
        if (a.equals(b)) {
            System.out.println("- So I'll stand here");
            return;
        }
        System.out.println("- Time to fly...");
        a.setX(b.getX());
        a.setY(b.getY());
    }
    @Override
    public String getMoveWay() {
        return "Fly";
    }
}
