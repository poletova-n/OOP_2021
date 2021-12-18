package lab7;

import java.util.Queue;

public class Reading implements Runnable
{
    private Queue<String> queue;
    private int tickRate;
    static int threadNumber = 0;

    public Reading(Queue<String> queue, int tickRate)
    {
        this.queue = queue;
        this.tickRate = tickRate;
    }


    @Override
    public void run()
    {
        Thread.currentThread().setName("  Reading # " + (++threadNumber));
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

            String mess = queue.poll();
            if (mess == null)
            {
                System.out.println("Thread '" + Thread.currentThread().getName()+ " empty ");
            }
            else
            {
                System.out.println("Thread " + Thread.currentThread().getName() + " reading " + mess + " ");
            }
        }
    }
}