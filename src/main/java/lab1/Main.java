package lab1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        Hero hero1 = new Hero();
        hero1.m.move(new Point(), new Point());

        hero1.changeModeOfTransportation(new HorseRiding());
        hero1.m.move(new Point(), new Point());

        hero1.changeModeOfTransportation(new Walk());
        hero1.m.move(new Point(), new Point());
    }
}
