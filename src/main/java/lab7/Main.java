package lab7;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int N = 3;
        if (args.length != 0) {
            N = Integer.parseInt(args[0]);
        }
        BlockingQueue<String> queue = new SynchronousQueue<>();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < N; i ++) {
            int num = i;
            service.execute(() -> { // запись потоков
                try {
                    queue.put("№ " + Integer.toString(num));;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            service.execute(() -> { // чтение потоков
                try {
                    System.out.println(Thread.currentThread() + " read " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }
}