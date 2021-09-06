package lab1.smirnov.evgeny;

public class Main {

    public static void main(String[] args) {

        Hero knight = new Hero("walk");
        knight.startMoving(new Point(3,3));
        knight.startMoving(new Point(13,5));

        knight.setMovement("swim");
        knight.startMoving(new Point(23,-4));

        knight.setMovement("ride");
        knight.startMoving(new Point(10,1));
        knight.startMoving(new Point(20,2));

        Hero witch = new Hero("fly");
        witch.startMoving(new Point(3,90));
        witch.startMoving(new Point(13,91));
        witch.startMoving(new Point(23,89));

        witch.setMovement("cycle");
        witch.startMoving(new Point(24,2));
        witch.startMoving(new Point(34,3));
    }
}
