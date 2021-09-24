package lab1;

public class Stealth implements Move {

    @Override
    public void move(Point a, Point b) {
        if (a.equals(b)) {
            System.out.println("- Blend in with my surroundings...");
            return;
        }
        System.out.println("- I'm starting to sneak around");
        a.setX(b.getX());
        a.setY(b.getY());
    }
    @Override
    public String getMoveWay() {
        return "Stealth";
    }
}