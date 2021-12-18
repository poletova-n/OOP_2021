package lab7;

import java.util.Queue;
import java.util.Random;

public class Writer implements Runnable
{
    private Queue<String> queue;
    private String messageToWrite;
    private int tickRate;

    public Writer(Queue<String> queue, String messageToWrite, int tickRate)
    {
        this.queue = queue;
        this.messageToWrite = messageToWrite;
        this.tickRate = tickRate;
    }

    static int writerCount = 0;

    @Override
    public void run()

    {
        Thread.currentThread().setName("WRITER>> #" + (++writerCount));
        try
        {
            while(!Thread.currentThread().isInterrupted())
            {
                Thread.sleep(tickRate);

                String msg = getMessageToWrite();
                queue.add(msg);
                System.out.println("Thread '" + Thread.currentThread().getName() + "' wrote '" + msg + "'");
            }
        }catch (InterruptedException e)
        {
            System.out.println("Thread '" + Thread.currentThread().getName() + "' is interrupted");
            //e.printStackTrace();
        }
        /*while (!Thread.currentThread().isInterrupted())
        {
            try
            {
                Thread.sleep(tickRate);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            String msg = getMessageToWrite();
            queue.add(msg);
            System.out.println("Thread '" + Thread.currentThread().getName() + "' wrote '" + msg + "'");
        }*/
    }

    private String getMessageToWrite()
    {
        StringBuffer stringBuffer = new StringBuffer(messageToWrite + "_");
        for(int i = 0; i < 3; i++)
        {
            stringBuffer.append((char)((int) ((Math.random() * (92 - 65)) + 65)));
        }
        return stringBuffer.toString();
    }
}
