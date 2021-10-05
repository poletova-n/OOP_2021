package lab4;

public class Physculture {
    @About
    private void warmup(){
        System.out.println("Do a warm-up.");
    }

    @About(data = 3)
    private void running(){
        System.out.println("Run a few laps.");
    }

    @About(data = 2)
    private void sparring(){
        System.out.println("Conduct a round.");
    }

    @About(data = 5)
    private void pushups(){
        System.out.println("Do a push-ups.");
    }
}
