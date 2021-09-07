package lab1;

public class Point {

    private int x;
    private int y;

    public Point(){}

    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }

    public void setPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean comparePoints(Point other){
        return this.x == other.x & this.y == other.y;
    }

    public int getDistance(Point other){
        return (int) Math.sqrt(Math.pow(other.x - this.x, 2) + (Math.pow(other.y - this.y, 2)));
    }

}
