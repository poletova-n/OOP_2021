package Lab1;

public class Hero {
    MoveStrategy moveStrategy;

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move(Point a, Point b) {
        moveStrategy.move(a, b);
    }
}
