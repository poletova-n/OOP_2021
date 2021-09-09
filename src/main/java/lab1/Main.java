package lab1;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hi, I am Witcher!\n ");

        Hero Witcher = new Hero("fly");
        Witcher.startMovement(new Point(5,7));
        Witcher.startMovement(new Point(2,7));
        Witcher.startMovement(new Point(12,5));

        Witcher.setActivity("swim");
        Witcher.startMovement(new Point(11,8));
        Witcher.startMovement(new Point(10,6));

        Witcher.setActivity("teleport");
        Witcher.startMovement(new Point(15,10));
        Witcher.startMovement(new Point(11,9));

        Witcher.setActivity("ride");
        Witcher.startMovement(new Point(25,12));
        Witcher.startMovement(new Point(17,4));

        Witcher.setActivity("walk");
        Witcher.startMovement(new Point(4,-12));
        Witcher.startMovement(new Point(5,-12));


    }
}
