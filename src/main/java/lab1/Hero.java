package lab1;

public class Hero {
    Move m;
    Point curPosition = new Point();
    Hero() {
        m = new Fly();
        curPosition.setX(0);
        curPosition.setY(0);
    }

    Hero(Move move) {
        m = move;
        curPosition.setX(0);
        curPosition.setY(0);
    }
    public void movement(int newX, int newY)
    {
        Point newPosition = new Point();
        newPosition.setX(newX);
        newPosition.setY(newY);
        m.move(curPosition, newPosition);
    }
    public void changeMovementType(Move newMovementType){
        if(m == newMovementType)
        {
            System.out.println("You are trying to use the same movement method!");
        }
        else
        {
            m = newMovementType;
        }
    }
}
