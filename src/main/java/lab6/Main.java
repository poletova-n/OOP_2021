package lab6;

public class Main {
    public static void main(String[] args) {
        AbstractProgram ap = new AbstractProgram();
        Supervisor supervisor = new Supervisor(ap);
        supervisor.run();


    }
}
