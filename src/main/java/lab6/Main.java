package lab6;


public class Main
{
    public static void main(String[] args)
    {
        Programm program = new Programm();
        Supervisor supervisor = new Supervisor(program);
        supervisor.run();
    }
}
