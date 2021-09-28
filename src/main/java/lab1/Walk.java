package lab1;

public class Walk implements Move {

    @Override
    public void move(Point curPosition, Point newPosition) {
        if(newPosition.equals(curPosition))
        {
            System.out.println("Hero walked a loop");
        }
        else {
            System.out.println("Hero is calmly walking");
            curPosition.setX(newPosition.getX());
            curPosition.setY(newPosition.getY());
            System.out.println("Hero current x position is " + curPosition.getX() +
                    "; current y position is " + curPosition.getY());
        }
    }
}
