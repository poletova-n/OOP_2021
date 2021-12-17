package lab6;

public class Supervisor implements Runnable
{
    Programm app;

    public Supervisor(Programm program)
    {
        app = program;
    }

    @Override
    public void run()
    {
        Thread thread = new Thread(app);
        thread.start();

        while(app.getCurrentStatus() != Programm.Status.FATAL_ERROR)
        {
            if ((app.getCurrentStatus() == Programm.Status.UNKNOWN)
                    || (app.getCurrentStatus() == Programm.Status.STOPPING))
            {
                start();
            }
        }

        thread.interrupt();
    }

    public void start()
    {
        app.setCurrentStatus(Programm.Status.RUNNING);
    }

    public void stop()
    {
        app.setCurrentStatus(Programm.Status.STOPPING);
    }
}