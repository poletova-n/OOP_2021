package lab6;

public class Main
{
    public static void main(String[] args)
    {
        Program program = new Program();
        Supervisor supervisor = new Supervisor(program);
        supervisor.run();
    }
}