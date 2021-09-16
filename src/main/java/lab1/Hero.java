package lab1;

public class Hero {
    private Move movingMethod;
    public void setMove(String type){
        switch (type) {
            case "Walk" -> movingMethod = new Walk();
            case "walk" -> movingMethod = new Walk();
            case "Swim" -> movingMethod = new Swim();
            case "swim" -> movingMethod = new Swim();
            case "Horse" -> movingMethod = new Horse();
            case "horse" -> movingMethod = new Horse();
            case "Fly" -> movingMethod = new Fly();
            case "fly" -> movingMethod = new Fly();
            case "Drive" -> movingMethod = new Drive();
            case "drive" -> movingMethod = new Drive();
            default -> System.out.println("I don't know what you mean!");
        }
    }
    public void moveToPoint(Point point){
        movingMethod.move(point);
    }
}
