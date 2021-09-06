package lab1_package;

public class Point {

    public Point(){}

    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }

    public Point setPoint(int x, int y){

        this.x = x;
        this.y = y;

        return this;
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

    private int x;
    private int y;

}
