package lab1;

public class Hero {

    public Hero(){

        position = new Point();
        moveMethod = new Run();

    }

    public void moveTo(int x_point, int y_point){

        Point destination = new Point(x_point,y_point);
        moveMethod.move(position, destination);

    }

    public void switchMoveMethod(String methodName){

        if (methodName.equalsIgnoreCase(moveMethod.getName())){

            System.out.println("Why are you trying to replace " + moveMethod.getName() + " by " + moveMethod.getName() + "?");

        }

        switch (methodName) {
            case "Run"      -> moveMethod = new Run();
            case "Ship"     -> moveMethod = new Ship();
            case "Fly"      -> moveMethod = new Fly();
            case "Teleport" -> moveMethod = new Teleport();
            default -> System.out.println("Unknown moving method!\n");
        }

    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Hero's moving method: ").append(moveMethod.getName()).append("\n");
        sb.append("Hero's position: (").append(position.getX()).append(';').append(position.getY()).append(")\n");

        return sb.toString();
    }

    private final Point position;
    private Move moveMethod;
}