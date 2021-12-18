package lab3;

import lab3.animals.*;
import lab3.exeptions.*;

public class Queue<T>
{
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
            tail.setObj(element);
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
                T tempData = head.getObj();
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

    public Queue<? extends Chordate> produce() throws QueueOverflow, QueueUnderflow
    {
        if (size != capacity)
        {
            Queue<? extends Chordate> tempQueue = new Queue<>(this.size);
            Queue<? extends Chordate> hierarchy = getHierarchy();

            if (capacity > 0)
            {
                for (int i = capacity; i > 0; i--)
                {
                    T tempData = head.getObj();
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
            return (Queue<? extends Chordate>) this;
        }
    }

    public boolean contains(Class cls)
    {
        Node<T> tempHead = head;

        while (tempHead != null)
        {
            if(tempHead.getObj().equals(cls))
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
                Queue<? extends T> queueHierarcy = new Queue<>(23);

                while (!cls.equals(Chordate.class))
                {
                    queueHierarcy.add(cls.getGenericSuperclass());
                    cls = (Class) cls.getGenericSuperclass();
                }

                Node<T> tempHead = head;
                Queue<? extends T> tempQueue = new Queue<>(size);

                while (tempHead != null)
                {
                    if(queueHierarcy.contains(tempHead.getObj().getClass()))
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


    private Queue<? extends Chordate> getHierarchy() throws QueueOverflow
    {
        Queue<? extends Chordate> tempQueue = new Queue<>(14);

        tempQueue.add(new Chordate());
        tempQueue.add(new Mammals());
        tempQueue.add(new TwoProngedMarsupials());
        tempQueue.add(new Cetaceans());
        tempQueue.add(new Kangaroos());
        tempQueue.add(new Dolphin());
        tempQueue.add(new GiantKangaroos());
        tempQueue.add(new TreeKangaroos());
        tempQueue.add(new Afalina());
        tempQueue.add(new SmallKillerWhales());
        tempQueue.add(new WesternGreyKangaroo());
        tempQueue.add(new BearKangaroo());
        tempQueue.add(new AustralianBottlenoseDolphin());
        tempQueue.add(new SmallOrca());

        return tempQueue;
    }
}
