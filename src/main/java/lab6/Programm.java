package lab6;

import java.util.Random;

public class Programm  implements Runnable
{
    public enum Status
    {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private Status currentStatus = Status.RUNNING;

    public void setCurrentStatus(Status status)
    {
        synchronized (this)
        {
            currentStatus = status;
            System.out.println("Status: " + currentStatus);
        }
    }

    public Status getCurrentStatus()
    {
        synchronized (this)
        {
            return currentStatus;
        }
    }

    @Override
    public void run() {
        Random random = new Random();

        Thread thread = new Thread(()->{
            while(!Thread.interrupted())
            {
                int pause = 1000 + random.nextInt(2000);

                try
                {
                    Thread.sleep(pause);
                }
                catch (InterruptedException e)
                {
                    break;
                }

                setCurrentStatus(Status.class.getEnumConstants()[random.nextInt(Status.values().length)]);
            }
        });

        thread.setDaemon(true);
        thread.start();

        while(!Thread.interrupted())
        {
            try
            {
                synchronized (this)
                {
                    if ((getCurrentStatus() == Status.UNKNOWN) || (getCurrentStatus() == Status.STOPPING))
                    {
                        wait();
                    }

                    if ((getCurrentStatus() == Status.RUNNING))
                    {
                        notify();
                    }
                }
            }
            catch (InterruptedException er)
            {
                System.out.println("The supervisor has completed the execution of the program");
                thread.interrupt();
                System.exit(0);
            }
        }
    }
}
