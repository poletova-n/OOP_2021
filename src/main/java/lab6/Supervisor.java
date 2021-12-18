package lab6;

public class Supervisor implements Runnable
{
    Program AbsProg;

    public Supervisor(Program program)
    {
        AbsProg = program;
    }

    @Override
    public void run()
    {
        Thread thread = new Thread(AbsProg);
        thread.start();

        while(AbsProg.getCurrentStatus() != Program.Status.FATAL_ERROR)
        {
            if ((AbsProg.getCurrentStatus() == Program.Status.UNKNOWN) || (AbsProg.getCurrentStatus() == Program.Status.STOPPING))
            {
                start();
            }
        }

        thread.interrupt();
    }

    public void start()
    {
        AbsProg.setCurrentStatus(Program.Status.RUNNING);
    }

    public void stop()
    {
        AbsProg.setCurrentStatus(Program.Status.STOPPING);
    }
}
