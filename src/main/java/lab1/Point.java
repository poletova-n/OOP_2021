package lab1;

public class Point {
    private final int x;
    private final int y;
    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    public String coordinates(){
        return ("{ " + x + " ; " + y + " }");
    }
}
