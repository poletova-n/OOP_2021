package lab7;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class Main {
    public static void main(String @NotNull [] args) {

        int N = Integer.parseInt(args[0]);

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(N);

        for (int i = 0; i < N; i++) {

            int num = i+1;
            String someNumber = Integer.toString(num);

            //Producer
            executor.execute(() -> {
                try {
                    queue.put("Some number: " + someNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //Consumer
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Current thread -> " + Thread.currentThread() + "      Taken message -> " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

    }
}
