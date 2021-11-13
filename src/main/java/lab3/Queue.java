package lab3;

import lab3.animals.*;
import lab3.exceptions.*;

public class Queue<T>
{
    private final int size;
    private int capacity;
    private Node<T> head;
    private Node<T> tail;

    public Queue(int size) {
        this.size = size;
        capacity = 0;
        head = null;
        tail = null;
    }

    public void add(Object object) throws QueueOverflow {
        try {

            if (capacity == size) {
                throw new QueueOverflow("It's full!");
            }

            Node<T> tempTail = tail;
            tail = new Node<>();
            tail.setObj(object);
            tail.setNext(null);

            if (isEmpty()) {
                head = tail;
            }
            else {
                tempTail.setNext(tail);
            }
            capacity++;
        }

        catch (QueueOverflow e) {
            e.printStackTrace();
        }
    }

    public boolean contains(Class cls) {
        Node<T> tempHead = head;

        while (tempHead != null) {
            if(tempHead.getObj().equals(cls)) {
                return true;
            }

            tempHead = tempHead.getNext();
        }

        return false;
    }

    public void consume(Class cl) throws QueueUnderflow, QueueOverflow {
        try {
            if (capacity > 0) {
                Queue<? extends T> queueHierarchy = new Queue<>(23);

                while (!cl.equals(Chordate.class)) {
                    queueHierarchy.add(cl.getGenericSuperclass());
                    cl = (Class) cl.getGenericSuperclass();
                }

                Node<T> tempHead = head;
                Queue<? extends T> tempQueue = new Queue<>(size);

                while (tempHead != null) {
                    if(queueHierarchy.contains(tempHead.getObj().getClass())) {
                        tempQueue.add(this.get());
                    }
                    else {
                        this.get();
                    }

                    tempHead = tempHead.getNext();
                }

                while (!tempQueue.isEmpty()) {
                    this.add(tempQueue.get());
                }
            }
            else {
                throw new QueueUnderflow("Queue is empty!");
            }
        }
        catch (QueueUnderflow ex) {
            ex.printStackTrace();
        }
    }

    public T get() throws QueueUnderflow
    {
        try {
            if (!isEmpty()) {
                T tempData = head.getObj();
                head = head.getNext();
                capacity--;

                if (isEmpty()) {
                    tail.setNext(null);
                }
                return tempData;
            }
            else {
                throw new QueueUnderflow("It's empty!");
            }
        }
        catch (QueueUnderflow e) {
            e.printStackTrace();
            return null;
        }
    }

    private Queue<? extends Chordate> getHierarchy() throws QueueOverflow
    {
        Queue<? extends Chordate> tempQueue = new Queue<>(14);

        tempQueue.add(new Chordate());
        tempQueue.add(new Mammals());
        tempQueue.add(new Feline());
        tempQueue.add(new Raccoon());
        tempQueue.add(new Caracal());
        tempQueue.add(new CommonRacoon());
        tempQueue.add(new SteppeLynx());
        tempQueue.add(new GoldenCat());
        tempQueue.add(new TresMariasRaccoon());
        tempQueue.add(new BahamianRaccoon());
        tempQueue.add(new TurkmenCaracal());
        tempQueue.add(new AsianGoldenCat());
        tempQueue.add(new SomeRacoon());
        tempQueue.add(new SomeRacoonTwo());

        return tempQueue;
    }

    public boolean isEmpty() {
        return (capacity == 0);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("It's empty!");
        }

        Node<T> tempHead = head;

        while (tempHead != null) {
            System.out.print(tempHead.toString() + " ");
            tempHead = tempHead.getNext();
        }

        System.out.println();
    }

    public Queue<? extends Chordate> produce() throws QueueOverflow, QueueUnderflow {
        if (size != capacity) {
            Queue<? extends Chordate> tempQueue = new Queue<>(this.size);
            Queue<? extends Chordate> hierarchy = getHierarchy();

            if (capacity > 0) {
                for (int i = capacity; i > 0; i--) {
                    T tempData = head.getObj();
                    head = head.getNext();

                    tempQueue.add(tempData);
                }
            }

            while ((tempQueue.capacity != tempQueue.size) & (!hierarchy.isEmpty())) {
                tempQueue.add(hierarchy.get());
            }

            return tempQueue;
        }
        else {
            return (Queue<? extends Chordate>) this;
        }
    }
}
