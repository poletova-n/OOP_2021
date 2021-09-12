package lab1;

public class Main {
    public static void main(String[] args) {

        Hero hero1 = new Hero();
        hero1.setAction("fly");
        System.out.println("---------------------");
        hero1.startAction(new Point(5,7));
        hero1.startAction(new Point(2,7));
        System.out.println("---------------------");


        hero1.setAction("Run");
        hero1.startAction(new Point(1, 1));
        hero1.startAction(new Point(31, 44));
        System.out.println("---------------------");

        hero1.setAction("swim");
        hero1.startAction(new Point(-2, 22));
        hero1. startAction(new Point(0, 100));
        System.out.println("---------------------");

        hero1.setAction("");
    }
}
