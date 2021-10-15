package lab1;

public class Hero {
    private Move m;
    private Point myPosition = new Point();

    Hero() {
        m = new Walk();
    }

    Hero(int x, int y) {
        m = new Walk();
        myPosition = new Point(x, y);
    }

    Hero(Move moveType) {
        m = moveType;
    }

    Hero(Move moveType, int x, int y) {
        m = moveType;
        myPosition = new Point(x, y);
    }

    public void changeMoveWay(String way) {
        if (way == m.getMoveWay()) {
            System.out.println("- This is already my way of moving");
            return;
        }
        switch (way) {
            case ("Fly"):
                m = new Fly();
                System.out.println("- Now I'm flying");
                break;
            case ("Horse ride"):
                m = new HorseRide();
                System.out.println("- Now I'm riding my horse");
                break;
            case ("Stealth"):
                m = new Stealth();
                System.out.println("- Now I'm sneaking around");
                break;
            case ("Walk"):
                m = new Walk();
                System.out.println("- Now I'm just walking");
                break;
            default:
                System.out.println("- I don't know how to do this yet (Coming soon)");
        }
    }

    public void changeMoveWay(Move move) {
        if (move == m) {
            System.out.println("- This is already my way of moving");
            return;
        }
            m = new Walk();
    }

    public void moving(Point destination) {
        m.move(myPosition, destination);
    }

    public void moving(int xCoordinate, int yCoordinate) {
        Point destination = new Point(xCoordinate, yCoordinate);
        m.move(myPosition, destination);
    }

    public void getPosition() {
        System.out.println("- My current coordinates: (" + myPosition.getX() + ";" + myPosition.getY() + ")");
    }
}
