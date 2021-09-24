package lab1;

import java.util.Locale;

public class Hero{
    Move m;
    Point p;

    public Hero(String activity){
        p = new Point(0,0);
        activityType(activity);
    }

    public void activityType(String type){
        switch (type.toUpperCase()){
            case "WALK" -> m = new Walk();
            case "HORSE" -> m = new Horse();
            case "FLY" -> m = new Fly();
            case "RUN" -> m = new Run();
            default -> m = new Walk();
        }
    }

    public void moveToDestination(Point destination){
        m.move(p, destination);
    }
}
