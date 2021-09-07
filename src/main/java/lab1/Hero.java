package lab1;

public class Hero {
    Move action;
    Point currentPos;

    Hero() 
    {
        currentPos = new Point(0, 0);
    }
    
    public void setTypeOfActivity(Move type)
    {
    	action = type;
    }
    
    public void moveOut(Point dest)
    {
    	currentPos = dest;
    }
}
