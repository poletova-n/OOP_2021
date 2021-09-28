package lab1;

import lombok.Getter;
import lombok.Setter;

public class Point {
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;

    @Override
    public boolean equals(Object point) {
        if (point == this) {
            return true;
        }
        if (point == null || point.getClass() != point.getClass()) {
            return false;
        }
        Point otherPoint = (Point) point;
        if (x != otherPoint.x)
            return false;
        if (y != otherPoint.y)
            return false;
        return true;
    }
}

