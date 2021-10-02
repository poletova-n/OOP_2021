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

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
