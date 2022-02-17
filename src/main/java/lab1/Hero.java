package lab1;

public class Hero {
    Move m;

    Hero() {

        m = new Fly();
    }

    Hero(Move move) {

        m = move;
    }

    public void changeMovingMode(Move move) {
        m = move;
    }
}