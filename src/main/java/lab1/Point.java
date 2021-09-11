package lab1;

public class Point {

    public Point()
    {}

    public Point(int x_point, int y_point)
    {
        this.x = x_point;
        this.y = y_point;
    }

    public void setPoint(int x_point, int y_point)
    {
        this.x = x_point;
        this.y = y_point;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isPointsEquel(Point point)
    {
        return this.x == point.x & this.y == point.y;
    }
    private int x;
    private int y;
}