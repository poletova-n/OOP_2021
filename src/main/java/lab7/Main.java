package lab7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        int N = 4;
        if (args.length != 0) {
            N = Integer.parseInt(args[0]);
        }


        BlockingQueue<String> queue = new SynchronousQueue<>();
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < N; i ++) {
            service.execute(() -> {

                try {
                    queue.put("Msg from " + Thread.currentThread());;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            service.execute(() -> {
                try {
                    Utils.pause(1000);
                    String msg = queue.take();
                    System.out.println("Receiver " + Thread.currentThread() + " msg: " + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();

    }
}
