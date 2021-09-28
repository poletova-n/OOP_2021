package lab1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        Hero LoopHero = new Hero();
        LoopHero.changeMovementType(new Walk());
        LoopHero.movement(1,1);
        LoopHero.changeMovementType(new Fly());
        LoopHero.movement(2,2);
        LoopHero.changeMovementType(new Run());
        LoopHero.movement(3,3);
        LoopHero.changeMovementType(new Teleport());
        LoopHero.movement(4,4);
        LoopHero.movement(4,4);
    }
}
