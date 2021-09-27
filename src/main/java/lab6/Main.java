package lab6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        App app =  new App("locoRoco", 10000);
        Supervisor thread = new Supervisor(app);
        System.out.println("Application testing: " + thread.getNameOfApp());
        thread.start();
    }
}