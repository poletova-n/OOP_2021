package lab7;

import java.util.Queue;

public class Writing implements Runnable
{
    private Queue<String> queue;
    private String write;
    private int tickRate;
    static int threadNumber = 0;

    public Writing(Queue<String> queue, String messageToWrite, int tickRate)
    {
        this.queue = queue;
        this.write = messageToWrite;
        this.tickRate = tickRate;
    }

    @Override
    public void run()
    {
        Thread.currentThread().setName(" Writing #" + (++threadNumber));
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

            String mess = getWrite();
            queue.add(mess);
            System.out.println("Thread '" + Thread.currentThread().getName() + "' wrote '" + mess + "'");
        }
    }

    private String getWrite()
    {
        StringBuffer stringBuffer = new StringBuffer(write + " ");
        for(int i = 0; i < 3; i++)
        {
            stringBuffer.append((char)((int) ((Math.random() * (65 - 45)) + 81)));
        }
        return stringBuffer.toString();
    }
}
