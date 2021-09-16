package lab1;


// 1. move with one point
// 2. add currPosition in Hero
// 3. move from hero, not from Move (incapsulation)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        Hero hero1 = new Hero();
        hero1.move(new Point(10, 20));

        hero1.changeModeOfTransportation(new HorseRiding());
        hero1.move(new Point(20, 10));

        hero1.changeModeOfTransportation(new Walk());
        hero1.move(new Point(-15, -18));
    }
}
