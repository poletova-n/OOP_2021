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
    Point (int a, int b){
        x=a;
        y=b;
    }
}
