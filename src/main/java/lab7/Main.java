package lab7;

import java.util.concurrent.*;

public class Main
{
    public static void main (String[] args)
    {
        int N;

        if (args.length == 0)
        {
            N = 8;
        }
        else
        {
            N = Integer.parseInt(args[0]);
        }

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ExecutorService service = Executors.newFixedThreadPool(N);

        for (int i = 0; i < N; i++)
        {
            int number = i;

            service.execute(() -> {
                try
                {
                    queue.put("Number " + Integer.toString(number));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            });

            service.execute(() -> {
                try
                {
                    Thread.sleep(2000);
                    System.out.println("Thread " + Thread.currentThread().getName() + " read: " + queue.take());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
    }
}