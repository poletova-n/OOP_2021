package lab1;

public class Main {
    public static void main(String[] args) {

        Hero Zelda = new Hero();

        //Walking Tests
        System.out.print("Let's move the hero to the point (5;5)\n");
        Zelda.moving(5, 5);
        Zelda.getPosition();
        System.out.print("We are trying to move the hero to the point where he is located\n");
        Zelda.moving(5, 5);
        System.out.print("Let's try to change the type of movement to Walk\n");
        Zelda.changeMoveWay("Walk");

        System.out.print("\n\n");

        //Flying Tests
        System.out.print("Now let's change the way the hero moves to Fly\n");
        Zelda.changeMoveWay("Fly");
        System.out.print("Let's move the hero to the point (-5;-5)\n");
        Zelda.moving(-5, -5);
        Zelda.getPosition();
        System.out.print("We are trying to move the hero to the point where he is located\n");
        Zelda.moving(-5, -5);
        System.out.print("Let's try to change the type of movement to Fly\n");
        Zelda.changeMoveWay("Fly");

        System.out.print("\n\n");

        //Horse riding Tests
        System.out.print("Now let's change the way the hero moves to Horse ride\n");
        Zelda.changeMoveWay("Horse ride");
        System.out.print("Let's move the hero to the point (-5;5)\n");
        Zelda.moving(-5, 5);
        Zelda.getPosition();
        System.out.print("We are trying to move the hero to the point where he is located\n");
        Zelda.moving(-5, 5);
        System.out.print("Let's try to change the type of movement to Horse ride\n");
        Zelda.changeMoveWay("Horse ride");

        System.out.print("\n\n");

        //Stealth Tests
        System.out.print("Now let's change the way the hero moves to Stealth\n");
        Zelda.changeMoveWay("Stealth");
        System.out.print("Let's move the hero to the point (5;-5)\n");
        Zelda.moving(5, -5);
        Zelda.getPosition();
        System.out.print("We are trying to move the hero to the point where he is located\n");
        Zelda.moving(5, -5);
        System.out.print("Let's try to change the type of movement to Stealth\n");
        Zelda.changeMoveWay("Stealth");

        System.out.print("\n\n");

        //*Random word* Tests
        System.out.print("Now let's change the way the hero moves to Run\n");
        Zelda.changeMoveWay("Run");
    }
}
