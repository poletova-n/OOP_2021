package lab1;

public class Dig implements Move{
    @Override
    public boolean move(Point a, Point b) {
        if (a.getZ() - b.getZ() > 50) {
            return errorMessage(2);
        } else if (a.getZ() - b.getZ() < 0) {
            return errorMessage(1);
        } else {
            if (Point.getDistance(a, b) > 75) {
                return errorMessage(3);
            } else {
                System.out.println("I digged from "+a.getCoordinatesMessage() + " to "+ b.getCoordinatesMessage());
                return true;
            }
        }
    }
    @Override
    public void message() {
        System.out.println("I am degging being");
    }

    @Override
    public boolean errorMessage(int errorCode) {
        switch (errorCode) {
            case 1:
                System.out.println("I can't fly");
                break;
            case 2:
                System.out.println("I can't dig so deep");
                break;
            case 3:
                System.out.println("I can't move so long");
                break;
        }
        return false;
    }
}
