package lab7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class QueueConsumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final Integer howMuchToConsume;
    private final ReadWriteLock readLock;
    private final static ReentrantReadWriteLock.WriteLock writeOutLocket = new ReentrantReadWriteLock().writeLock();

    public QueueConsumer(BlockingQueue<String> queue, Integer howMuchToConsume, ReadWriteLock readLock) {
        this.queue = queue;
        this.howMuchToConsume = howMuchToConsume;
        this.readLock = readLock;
    }

    @Override
    public void run() {
        for (int i = 0; i < howMuchToConsume; i++) {
            readLock.readLock().lock();
            try {
                writeOutLocket.lock();
                System.out.println("Consumer take: " + queue.take());
                writeOutLocket.unlock();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                readLock.readLock().unlock();
            }
        }
    }
}
