package lab1;

public class Run implements Move {

    @Override
    public void move(Point curPosition, Point newPosition) {
        if(newPosition.equals(curPosition))
        {
            System.out.println("Hero is running in circles");
        }
        else {
            System.out.println("Hero is running as fast as he can");
            curPosition.setX(newPosition.getX());
            curPosition.setY(newPosition.getY());
            System.out.println("Hero current x position is " + curPosition.getX() +
                    "; current y position is " + curPosition.getY());
        }
    }
}