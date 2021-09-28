package lab7;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static lab7.Utils.parseIntFromArgs;

public class Main {
    public static void main(String[] args) {
        int N = parseIntFromArgs(args[0]);
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ReadWriteLock common = new ReentrantReadWriteLock();

        ExecutorService executorService = Executors.newFixedThreadPool(2 * N);
        for (int i = 0; i < N; i++) {
            executorService.submit(new QueueProducer(queue,2, common));
            executorService.submit(new QueueConsumer(queue,2, common));
        }
        executorService.shutdown();
    }
}
