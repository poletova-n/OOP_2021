package lab1;

public class Teleport implements Move {

    @Override
    public void move(Point curPosition, Point newPosition) {
        if(newPosition.equals(curPosition))
        {
            System.out.println("Hero just teleported... Up?");
        }
        else {
            System.out.println("Hero just teleported");
            curPosition.setX(newPosition.getX());
            curPosition.setY(newPosition.getY());
            System.out.println("Hero current x position is " + curPosition.getX() +
                    "; current y position is " + curPosition.getY());
        }
    }
}