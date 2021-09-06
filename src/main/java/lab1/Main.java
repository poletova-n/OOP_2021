package lab1_package;

public class Main {
    public static void main(String[] args) {

        System.out.println(
                "   __       _     _                        \n" +
                "  / /  __ _| |__ / |   /\\  /\\___ _ __ ___  \n" +
                " / /  / _` | '_ \\| |  / /_/ / _ \\ '__/ _ \\ \n" +
                "/ /__| (_| | |_) | | / __  /  __/ | | (_) |\n" +
                "\\____/\\__,_|_.__/|_| \\/ /_/ \\___|_|  \\___/ \n");

        System.out.println("Welcome to the lab work 1 \"Hero\".\n" +
                "In this program, you can control the movement of the hero using\ndifferent methods of movement, namely:\n" +
                "- Legs (allow you to move 1 step)\n" +
                "- Horse (allows you to move 50 steps)\n" +
                "- Wings (allow you to move 100 steps)\n" +
                "- Spaceship (allows you to move an unlimited number of steps)");

        Hero theGreatHero = new Hero();


        System.out.println("\n\nLet's test this program:\n\nStarting parameters:");
        System.out.println(theGreatHero);
//Testing Legs
        System.out.println("Testing Legs:\n");

        System.out.println("Moving to (1;1)");
        theGreatHero.moveTo(1,1);
        System.out.println(theGreatHero);

        System.out.println("Moving to (1;1) again");
        theGreatHero.moveTo(1,1);
        System.out.println(theGreatHero);

        System.out.println("Moving to (10;12)");
        theGreatHero.moveTo(10,12);
        System.out.println(theGreatHero);

//Testing Horse

        System.out.println("Testing Horse:\n");
        theGreatHero.changeMoveMethod("Horse");

        System.out.println("Moving to (12;22)");
        theGreatHero.moveTo(12,22);
        System.out.println(theGreatHero);

        System.out.println("Moving to (12;22) again");
        theGreatHero.moveTo(12,22);
        System.out.println(theGreatHero);

        System.out.println("Moving to (-100;123)");
        theGreatHero.moveTo(-100,123);
        System.out.println(theGreatHero);

//Testing Fly

        System.out.println("Testing Fly:\n");
        theGreatHero.changeMoveMethod("Fly");

        System.out.println("Moving to (80;-34)");
        theGreatHero.moveTo(80,-34);
        System.out.println(theGreatHero);

        System.out.println("Moving to (80;-34) again");
        theGreatHero.moveTo(80,-34);
        System.out.println(theGreatHero);

        System.out.println("Moving to (-1000;123)");
        theGreatHero.moveTo(-100,123);
        System.out.println(theGreatHero);

//Testing Spaceship

        System.out.println("Testing Spaceship:\n");
        theGreatHero.changeMoveMethod("Spaceship");

        System.out.println("Moving to (-23443;7322)");
        theGreatHero.moveTo(-23443,7322);
        System.out.println(theGreatHero);

        System.out.println("Moving to (-23443;7322) again");
        theGreatHero.moveTo(-23443,7322);
        System.out.println(theGreatHero);

//Testing unknown moving method

        System.out.println("Trying to make hero swim:\n//theGreatHero.changeMoveMethod(\"Swim\");");
        theGreatHero.changeMoveMethod("Swim");



    }
}
