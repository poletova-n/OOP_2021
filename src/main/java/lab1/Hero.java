package lab1;

public class Hero {

    private final Point position;
    private MovingMethod moveMethod;

    public Hero(){

        position = new Point();
        moveMethod = new Walk();

    }

    public void moveTo(int xDestination, int yDestination){

        Point destination = new Point(xDestination,yDestination);
        moveMethod.move(position, destination);

    }

    public void changeMovingMethod(String methodName){

        if (methodName.equals(moveMethod.getName())){

            System.out.println("Why are you trying to replace " + moveMethod.getName() + " by " + moveMethod.getName() + "?");

        }

        switch (methodName) {
            case "Walk"      -> moveMethod = new Walk();
            case "Horse"     -> moveMethod = new Horse();
            case "Fly"       -> moveMethod = new Fly();
            case "Spaceship" -> moveMethod = new Spaceship();
            default -> System.out.println("Unknown moving method!\n");
        }

    }

    public String toString(){

        return  "Hero's moving method: " + moveMethod.getName() + "\n" +
                "Hero's position: (" + position.getX() + ';' + position.getY() + ")\n";

    }

}
