package lab6;


public class Main {

    public static void main(String[] args) {
        Proga proga = new Proga();
        SuperViz supervisor = new SuperViz(proga);
        supervisor.run();
    }
}
/*
public class Main
{
    public static void main(String[] args)
    {
        Application app = Application.createAndStart();
        Supervisor supervisor = Supervisor.createAndStart(app);
    }
}
 */


