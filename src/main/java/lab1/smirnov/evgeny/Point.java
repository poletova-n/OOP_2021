package lab1.smirnov.evgeny;

import lombok.Getter;
import lombok.Setter;

public class Point {
    @Getter
    @Setter
    private double x;

    @Getter
    @Setter
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void clone(Point newPoint) {
        if (newPoint != null) {
            this.x = newPoint.x;
            this.y = newPoint.y;
        }
    }

    @Override
    public String toString() {
        return "Point(" + x + "; " + y + ")";
    }
}