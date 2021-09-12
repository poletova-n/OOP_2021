package lab1;


public class Point {

    private int a;
    private int b;

    public Point(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void copyPoint(Point newPoint) {
        if (newPoint != null){
            this.a = newPoint.a;
            this.b = newPoint.b;
        }
    }

    @Override
    public String toString() {
        return "position (" + a + "; " + b + ")";
    }
}
