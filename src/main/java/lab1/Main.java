package lab1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start: ");
        Hero hero = new Hero();

        hero.choise("Horse");
        hero.move();

        hero.choise("Fly");
        hero.move();

        hero.choise("Swim");
        hero.move();

        hero.choise("Avto");
        hero.move();

        hero.choise("Walk");
        hero.move();
    }
}
