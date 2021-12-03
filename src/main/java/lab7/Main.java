package lab7;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main
{
    public static void main(String[] args)
    {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        int N = 3;
        Thread[] writer = new Thread[N];
        Thread[] reader = new Thread[N];

        for (int i = 0; i < N; i++)
        {
            writer[i] = new Thread(new Writer(queue, "msg", 1000));
            reader[i] = new Thread(new Reader(queue, 2000));
        }

        for (int i = 0; i < N; i++)
        {
            writer[i].start();
            reader[i].start();
        }

        Thread queueChecker = new Thread(() ->
        {
            int sleepTime = 1500;//3001
            while (!Thread.currentThread().isInterrupted())
            {
                try
                {
                    Thread.sleep(sleepTime);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Current queue state:" + queue);
            }
        });

        queueChecker.start();

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        for (int i = 0; i < N; i++)
    {
        writer[i].stop();
        reader[i].stop();
    }
        queueChecker.stop();
        System.out.println("Program finished!");
    }
}