package lab6;

public class Main {
    public static void main(String[] args) {
        System.out.println("START");
        SuperVisor supervisor = new SuperVisor(new AbstractProgram(1));
        supervisor.start();
    }
}