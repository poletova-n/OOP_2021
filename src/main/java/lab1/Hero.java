package lab1;

public class Hero {
    Move action;
    Point currentPos;

    public Hero() 
    {
        currentPos = new Point(0, 0);
    }
    
	public Hero(int xStart, int yStart) 
    {
        currentPos = new Point(xStart, yStart);
    }
    
    public void setTypeOfActivity(Move type)
    {
    	action = type;
    }
    
    public void moveOut(Point dest)
    {
    	action.move(dest);
    	currentPos = dest;
    }
}
