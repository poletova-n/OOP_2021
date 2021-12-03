package lab7;

import java.util.Queue;

public class Writer implements Runnable
{
    private Queue<String> queue;
    private String messageToWrite;
    private int tickRate;
    static int threadNumber = 0;

    public Writer(Queue<String> queue, String messageToWrite, int tickRate)
    {
        this.queue = queue;
        this.messageToWrite = messageToWrite;
        this.tickRate = tickRate;
    }

    @Override
    public void run()
    {
        Thread.currentThread().setName(" WRITER >> #" + (++threadNumber));
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

            String msg = getMessageToWrite();
            queue.add(msg);
            System.out.println("Thread '" + Thread.currentThread().getName() + "' wrote '" + msg + "'");
        }
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