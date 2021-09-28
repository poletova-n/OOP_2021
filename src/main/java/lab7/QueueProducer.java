package lab7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static lab7.Utils.getRandomString;

public class QueueProducer implements Runnable {
    private final BlockingQueue<String> queue;
    private final Integer howMuchToProduce;
    private final ReadWriteLock writeLock;

    public QueueProducer(BlockingQueue<String> queue, Integer howMuchToProduce, ReadWriteLock writeLock) {
        this.queue = queue;
        this.howMuchToProduce = howMuchToProduce;
        this.writeLock = writeLock;
    }

    @Override
    public void run() {
        for (int i = 0; i < howMuchToProduce; i++) {
            writeLock.writeLock().lock();
            String message = getRandomString();
            System.out.println("Put message  : " + message);
            try {
                queue.put(message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                writeLock.writeLock().unlock();
            }
        }
    }
}
