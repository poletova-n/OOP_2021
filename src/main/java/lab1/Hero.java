package lab1;

public class Hero {
    private Move newMove;
    private Point currPoint;

    public Hero(){
        currPoint = new Point(0, 0);
    }

    public void setAction(String motion){
        switch (motion.toLowerCase()){
            case "fly" -> newMove = new Fly();
            case "swim" -> newMove = new Swim();
            case "run" -> newMove  = new Run();
            default -> System.out.println("Sorry, i dont understand you");
        }
    }
    public void startAction(Point newPoint){
        newMove.move(newPoint);
        currPoint = newPoint;
    }


}
