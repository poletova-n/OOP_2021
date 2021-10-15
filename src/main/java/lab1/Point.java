package lab1;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Point {
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;

    Point() {
        setX(0);
        setY(0);
    }

    Point(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object point) {
        if (point == null) {
            return false;
        }
        Point tmp = (Point) point;
        return (this.x == tmp.x && this.y == tmp.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
