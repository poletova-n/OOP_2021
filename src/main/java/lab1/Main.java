package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi, there is some rules of testing minigame");

        System.out.println("There is some rules\n" +
                "First - flying can't fly up more than 50, reached distance more than 75 and can't dig\n" +
                "Second - digging can't fly , reached distance more than 75 and can't dig up more than 50\n" +
                "Last - walking can't fly, can't dig and can't reached distance more than 100\n" +
                "Have fun\n");
        System.out.println("How type of animals you wanna choose\nFly\nDig\nWalk\nWright your type in:");
        Scanner in = new Scanner(System.in);
        Hero newHero = new Hero(in.next());
        do {

            System.out.println("Enter x coordinate of moving:");
            double x = in.nextDouble();
            System.out.println("Enter y coordinate of moving:");
            double y = in.nextDouble();
            System.out.println("Enter z coordinate of moving:");
            double z = in.nextDouble();
            newHero.move(new Point(x, y, z));
            System.out.println("do you wanna continue?y/n");
        }while (in.next().equals("y"));
        //System.out.println(newHero.getPosition().getCoordinatesMessage());
        System.out.println("Goodbye");
    }
}
