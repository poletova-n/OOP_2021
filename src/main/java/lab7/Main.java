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

    Thread queueOuter = new Thread(() ->
    {
      int sleepTime = 3001;
      try
      {
        while(!Thread.currentThread().isInterrupted())
        {
          Thread.sleep(sleepTime);
          System.out.println("Current queue state:" + queue);
        }
      }catch (InterruptedException e)
      {
        System.out.println("Thread 'queueChecker' is interrupted");
        //e.printStackTrace();
      }
      /*while (!Thread.currentThread().isInterrupted())
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
      }*/
    });
    queueOuter.start();

    try {
      Thread.sleep(3050);
      for (int i = 0; i < N; i++) {
        writer[i].interrupt();
        reader[i].interrupt();
      }
      queueOuter.interrupt();
      System.out.println("Start of interrupting threads :");
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}
