package lab1;

public class Main {
    public static void main(String[] args) {
        Hero newHero = new Hero();
        newHero.setMove("Walk");
        newHero.moveToPoint(new Point(23,73));

        newHero.setMove("Fly");
        newHero.moveToPoint(new Point(1 , 2));

        newHero.setMove("Swim");
        newHero.moveToPoint(new Point(77,11));

        newHero.setMove("Horse");
        newHero.moveToPoint(new Point(812,191));

        newHero.setMove("Fly");
        newHero.moveToPoint(new Point(0,-1));

        newHero.setMove("AAAAAAAAAA");
        newHero.moveToPoint(new Point(-2,-7));

        newHero.setMove("fly");
        newHero.moveToPoint(new Point(999,999));
    }
}
