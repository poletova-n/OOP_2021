package lab7;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int N=Integer.parseInt(args[0]);

        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
        ExecutorService service = Executors.newFixedThreadPool(N);

        for(int i=0;i<N;i++){
            int num = i;
            service.execute(()->{
                try {
                    String str = Integer.toString(num);
                    blockingQueue.put("number"+ str);
                    //Utils.pause(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            service.execute(()->{
                try {
                    Utils.pause(3000);
                    System.out.println(Thread.currentThread()+" read "+blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }
}
