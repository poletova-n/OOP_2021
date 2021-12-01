package lab7;

import java.util.concurrent.*;

public class Main 
{
	public static void main (String[] args)
	{
		int iter;

		if (args.length == 0) 
		{
			iter = 8;
		}
		else 
		{
			iter = Integer.parseInt(args[0]);
		}
		
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		ExecutorService service = Executors.newFixedThreadPool(iter);
		
		for (int i = 0; i < iter; i++)
		{
			int tempI = i;

			service.execute(() -> {
				try 
				{
					queue.put("Message " + Integer.toString(tempI));
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