package lab1;

public class Fly implements Move {

    @Override
    public void move(Point curPosition, Point newPosition) {
        if(newPosition.equals(curPosition))
        {
            System.out.println("Hero is flying up and down");
        }
        else{
            System.out.println("Hero flew away");
            curPosition.setX(newPosition.getX());
            curPosition.setY(newPosition.getY());
            System.out.println("Hero current x position is " + curPosition.getX() +
                    "; current y position is " + curPosition.getY());
        }
    }
}
