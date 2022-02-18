package lab1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        Hero hero1 = new Hero();
        hero1.move(new Point(3,2));

        hero1.changeMovingMode(new HorseRiding());
        hero1.move(new Point(-3,2));

        hero1.changeMovingMode(new Walk());
        hero1.move(new Point(5,1));

        hero1.changeMovingMode(new Crouch());
        hero1.move(new Point(-5,-5));
    }
}
