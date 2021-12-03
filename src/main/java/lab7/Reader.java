package lab7;

import java.util.Queue;

public class Reader implements Runnable
{
    private Queue<String> queue;
    private int tickRate;
    static int threadNumber = 0;

    public Reader(Queue<String> queue, int tickRate)
    {
        this.queue = queue;
        this.tickRate = tickRate;
    }


    @Override
    public void run()
    {
        Thread.currentThread().setName(" << READER #" + (++threadNumber));
        while (!Thread.currentThread().isInterrupted())
        {
            try
            {
                Thread.sleep(tickRate);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            String messageToRead = queue.poll();
            if (messageToRead == null)
            {
                System.out.println("Thread '" + Thread.currentThread().getName() + "' read from empty queue");
            }
            else
            {
                System.out.println("Thread '" + Thread.currentThread().getName() + "' read '" + messageToRead + "'");
            }
        }
    }
}