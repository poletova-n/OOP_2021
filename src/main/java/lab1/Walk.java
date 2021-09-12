package lab1;

public class Walk implements Move {
    @Override
    public boolean move(Point a, Point b) {
        if (a.getZ() - b.getZ() > 0) {
            return errorMessage(2);
        } else if (a.getZ() - b.getZ() < 0) {
            return errorMessage(1);
        } else {
            if (Point.getDistance(a, b) > 100) {
                return errorMessage(3);
            } else {
                System.out.println("I walk from Point: " + a.getCoordinatesMessage() + " to Point " + b.getCoordinatesMessage());
                return true;
            }
        }
    }

    @Override
    public void message() {
        System.out.println("I am just walking being");
    }

    @Override
    public boolean errorMessage(int errorCode) {
        switch (errorCode) {
            case 1:
                System.out.println("I can't fly");
                break;
            case 2:
                System.out.println("I can't dig");
                break;
            case 3:
                System.out.println("I can't walk so long");
                break;
        }
        return false;
    }
}
