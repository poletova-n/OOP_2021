package lab4;

public class Cat {

    @RemoteControl(times = 3)
    private void mew() {
        System.out.println("Mew");
    }

    @RemoteControl
    private void jump() {
        System.out.println("Jump");
    }

    @RemoteControl(times = 5)
    private void sleep() {
        System.out.println("Zzz");
    }

    private void run() {
        System.out.println("Run");
    }
}
