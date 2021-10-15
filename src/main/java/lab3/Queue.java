import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Queue <T> {
    private final ArrayList<T> queue;
    private int addIndex;
    private int getIndex;

    public Queue() {
        int SIZE_QUEUE = 14;
        this.queue = new ArrayList<>(SIZE_QUEUE);
        addIndex = 0;
        getIndex = 0;
    }

    public Queue(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size can't be less 1");
        }
        queue = new ArrayList<>(size);
        addIndex = 0;
        getIndex = 0;
    }

    public void add(T element) {
        queue.add(addIndex++, element);
    }

    public T get() {
        if (getIndex == addIndex) {
            throw new IllegalStateException("Are you trying to get an empty queue");
        }
        return queue.get(getIndex++);
    }

    public boolean isEmpty() {
        return getIndex == addIndex;
    }

    @Override
    public String toString() {
        return "\nQueue { " + queue + " " + "}\n";
    }
}
