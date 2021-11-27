package lab6;

public class Supervisor implements Runnable
{
    Programm prog;

    public Supervisor(Programm program)
    {
        prog = program;
    }

    @Override
    public void run()
    {
        Thread thread = new Thread(prog);
        thread.start();

        while(prog.getCurrentStatus() != Programm.Status.FATAL_ERROR)
        {
            if ((prog.getCurrentStatus() == Programm.Status.UNKNOWN)
                    || (prog.getCurrentStatus() == Programm.Status.STOPPING))
            {
                start();
            }
        }

        thread.interrupt();
    }

    public void start()
    {
        prog.setCurrentStatus(Programm.Status.RUNNING);
    }

    public void stop()
    {
        prog.setCurrentStatus(Programm.Status.STOPPING);
    }
}