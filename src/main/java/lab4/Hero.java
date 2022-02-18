package lab4;


public class Hero {

    @HeroControl
    private void walk() {
        System.out.println("Walking");
    }

    @HeroControl(times = 2)
    private void jump() {
        System.out.println("Jumping");
    }

    @HeroControl(times = 4)
    private void fly() {
        System.out.println("flying");
    }

    private void ride() {
        System.out.println("riding");
    }
}