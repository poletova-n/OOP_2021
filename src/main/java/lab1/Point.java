package lab1;

import lombok.Getter;
import lombok.Setter;

import java.security.PublicKey;

public class Point {
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void copyPoint(Point nextPoint) {
        if (nextPoint != null){
            this.x = nextPoint.x;
            this.y = nextPoint.y;
        }
    }

    @Override
    public String toString() {
        return "Point(" + x + "; " + y + ")";
    }
}
