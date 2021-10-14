package lab3;

import lab3.annimals.*;
import lab3.exceptions.*;

public class Queue<T> {

    private Node<T> head, tail;
    private final int size;
    private int capacity;

    public Queue(int size)
    {
        head = null;
        tail = null;
        this.size = size;
        capacity = 0;
    }

    public void print()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
        }

        Node<T> tempHead = head;

        while (tempHead != null)
        {
            System.out.print(tempHead.toString() + " ");
            tempHead = tempHead.getNext();
        }

        System.out.println();
    }

    public void add(Object element) throws QueueOverflow
    {
        try
        {
            if (capacity == size)
            {
                throw new QueueOverflow("Queue is full!");
            }

            Node<T> tempTail = tail;

            tail = new Node<>();
            tail.setData(element);
            tail.setNext(null);

            if (isEmpty())
            {
                head = tail;
            }
            else
            {
                tempTail.setNext(tail);
            }

            capacity++;
        }

        catch (QueueOverflow ex)
        {
            ex.printStackTrace();
        }
    }

    public T get() throws QueueUnderflow
    {
        try
        {
            if (isEmpty())
            {
                throw new QueueUnderflow("Queue is empty!");
            }
            else
            {
                T tempData = head.getData();
                head = head.getNext();
                capacity--;

                if (isEmpty())
                {
                    tail.setNext(null);
                }

                return tempData;
            }
        }
        catch (QueueUnderflow ex)
        {
            ex.printStackTrace();
            return null;
        }

    }

    public boolean isEmpty()
    {
        return (capacity == 0);
    }

    public Queue<? extends Chordal> produce() throws QueueOverflow, QueueUnderflow
    {
        if (size != capacity)
        {
            Queue<? extends Chordal> tempQueue = new Queue<>(this.size);
            Queue<? extends Chordal> hierarchy = getHierarchy();

            if (capacity > 0)
            {
                for (int i = capacity; i > 0; i--)
                {
                    T tempData = head.getData();
                    head = head.getNext();

                    tempQueue.add(tempData);
                }
            }

            while ((tempQueue.capacity != tempQueue.size) & (!hierarchy.isEmpty()))
            {
                tempQueue.add(hierarchy.get());
            }

            return tempQueue;
        }
        else
        {
            return (Queue<? extends Chordal>) this;
        }
    }

    public boolean contains(Class cls)
    {
        Node<T> tempHead = head;

        while (tempHead != null)
        {
            if(tempHead.getData().equals(cls))
            {
                return true;
            }

            tempHead = tempHead.getNext();
        }

        return false;
    }

    public void consume(Class cls) throws QueueUnderflow, QueueOverflow
    {
        try
        {
            if (capacity > 0)
            {
                Queue<? extends T> queueHierarcy = new Queue<>(13);

                while (!cls.equals(Chordal.class))
                {
                    queueHierarcy.add(cls.getGenericSuperclass());
                    cls = (Class) cls.getGenericSuperclass();
                }

                Node<T> tempHead = head;
                Queue<? extends T> tempQueue = new Queue<>(size);

                while (tempHead != null)
                {
                    if(queueHierarcy.contains(tempHead.getData().getClass()))
                    {
                        tempQueue.add(this.get());;
                    }
                    else
                    {
                        this.get();
                    }

                    tempHead = tempHead.getNext();
                }

                while (!tempQueue.isEmpty())
                {
                    this.add(tempQueue.get());
                }
            }
            else
            {
                throw new QueueUnderflow("Queue is empty!");
            }
        }
        catch (QueueUnderflow ex)
        {
            ex.printStackTrace();
        }
    }

    private Queue<? extends Chordal> getHierarchy() throws QueueOverflow
    {
        Queue<? extends Chordal> tempQueue = new Queue<>(13);

        tempQueue.add(new Chordal());
        tempQueue.add(new BengalOwl());
        tempQueue.add(new Birds());
        tempQueue.add(new Bubo());
        tempQueue.add(new Gibbon());
        tempQueue.add(new Mammals());
        tempQueue.add(new GreatApes());
        tempQueue.add(new MagellansOwl());
        tempQueue.add(new Owls());
        tempQueue.add(new Primates());
        tempQueue.add(new SilverGibbon());
        tempQueue.add(new Striginae());
        tempQueue.add(new TheWhiteArmedGibbon());
        return tempQueue;
    }
}
