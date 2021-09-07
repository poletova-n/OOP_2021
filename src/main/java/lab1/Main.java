package lab1;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                Lab work 1
                 Here we have a hero who can travel by some different methods.
                1) He can run
                2) He can fly
                3) He can travel on the ship
                4) And he can teleport
                ------------------------------------------------------------------""");
        Hero Garold = new Hero();

        System.out.println("""
                Testing methods
                ------------------------------------------------------------------
                Starting parameters:\s""");
        System.out.println(Garold);

        System.out.println("Testing running\n");

        System.out.println("Moving to (10;10)");
        Garold.moveTo(10,10);
        System.out.println(Garold);

        System.out.println("Moving to (10;10) again");
        Garold.moveTo(10,10);
        System.out.println(Garold);

        System.out.println("Moving to (1;1) ");
        Garold.moveTo(1,1);
        System.out.println(Garold);

        System.out.println("Testing Ship:\n");
        Garold.switchMoveMethod("Ship");

        System.out.println("Moving to (20;20)");
        Garold.moveTo(20,20);
        System.out.println(Garold);

        System.out.println("Moving to (20;20) again");
        Garold.moveTo(20,20);
        System.out.println(Garold);

        System.out.println("Moving to (1;1)");
        Garold.moveTo(1,1);
        System.out.println(Garold);

        System.out.println("Testing Fly:\n");
        Garold.switchMoveMethod("Fly");

        System.out.println("Moving to (30;30)");
        Garold.moveTo(30,30);
        System.out.println(Garold);

        System.out.println("Moving to (30;30) again");
        Garold.moveTo(30,30);
        System.out.println(Garold);

        System.out.println("Moving to (1;1)");
        Garold.moveTo(1,1);
        System.out.println(Garold);

        System.out.println("Testing Teleport:\n");
        Garold.switchMoveMethod("Teleport");

        System.out.println("Moving to (40;40)");
        Garold.moveTo(40,40);
        System.out.println(Garold);

        System.out.println("Moving to (40;40) again");
        Garold.moveTo(40,40);
        System.out.println(Garold);

        System.out.println("Moving to (1;1)");
        Garold.moveTo(1,1);
        System.out.println(Garold);

        System.out.println("Let's try change to unknown method. It will be flying on the web");
        Garold.switchMoveMethod("flying on the web");


    }
}