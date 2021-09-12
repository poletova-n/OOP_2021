package lab1;

public interface Move {
    boolean move(Point a, Point b);

    void message();

    boolean errorMessage(int errorCode);
}
