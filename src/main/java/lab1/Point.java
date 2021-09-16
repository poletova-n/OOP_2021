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

    Point(int initX, int initY) {
        x = initX;
        y = initY;
    }
}
