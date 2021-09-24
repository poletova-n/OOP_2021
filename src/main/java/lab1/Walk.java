package lab1;

public class Walk implements Move {

    @Override
    public void move(Point a, Point b) {
        if (a.equals(b)) {
            System.out.println("- I'll stay here for now");
            return;
        }
        System.out.println("- Walk, walk, walk...");
        a.setX(b.getX());
        a.setY(b.getY());
    }
    @Override
    public String getMoveWay() {
        return "Walk";
    }
}