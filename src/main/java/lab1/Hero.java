package lab1;

public class Hero {
    Move act;
    Point curPos;

    public Hero(int x, int y)
    {
        curPos = new Point(x, y);
    }

    public void setAct(Move type)
    {
        act = type;
    }

    public void moveOn(Point newPoint)
    {
        act.move(newPoint);
        curPos = newPoint;
    }
}
