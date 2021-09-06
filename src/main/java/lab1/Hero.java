package lab1_package;

public class Hero {

    public Hero(){

        position = new Point();
        moveMethod = new Walk();

    }

    public void moveTo(int xDestination, int yDestination){

        Point destination = new Point(xDestination,yDestination);
        moveMethod.move(position, destination);

    }

    public void changeMoveMethod(String methodName){

        if (methodName == moveMethod.getName()){

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

        StringBuilder sb = new StringBuilder();

        sb.append("Hero's moving method: " + moveMethod.getName() + "\n");
        sb.append("Hero's position: (" + position.getX() + ';' + position.getY() + ")\n");

        return sb.toString();
    }

    private Point position;
    private Move moveMethod;
}
