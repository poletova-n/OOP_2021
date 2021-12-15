package lab1;

import java.util.Locale;

public class Hero {
    private Move m;
    private Point position;

    Hero() {
        m = new Walk();
        position = new Point(0, 0, 0);
    }

    boolean changeMovementType(String type) {
        switch (type.toLowerCase()) {
            case "fly":
                m = new Fly();
                System.out.println("Now you're flying being");
                return true;
            case "walk":
                m = new Walk();
                System.out.println("Now you're walking being");
                return true;
            case "dig":
                m = new Dig();
                System.out.println("Now you're digging being");
                return true;
            default:
                m = new Walk();
                System.out.println("Wrong movement type\nYou have the same type that was before");
                return false;
        }
    }

    void move(Point a) {
        if (m.move(position, a)) {
            position = a;
        }
    }

    Hero(Move move) {
        m = move;
        position = new Point(0, 0, 0);
    }

    Hero(String move) {
        this.changeMovementType(move);
        position = new Point(0, 0, 0);
    }
}
