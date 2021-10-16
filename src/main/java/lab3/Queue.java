package lab3;

import lab3.exceptions.QueueOverflow;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class Queue<E>{

    private LinkedList<E> list;
    private int capacity = 0;
    private int size()
    {
        return list.size();
    }

    public Queue()

    public E getHead()
    {
        return list.get(0);
    }

    public void add(E el) throws QueueOverflow
    {
        if (list.size() == capacity)
        {
            throw new QueueOverflow("Overflow exception!");
        }
        list.add(el);
    }

    public void get(int ind)
    {
        list.get(ind);
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public Queue<E> produce(Class<? extends E> cl) throws QueueOverflow {
        Queue<E> newQueue = new Queue<E>();
        for (E elem: list) {
            if (cl.isInstance(elem)) {
                newQueue.add(elem);
            }
        }
        return newQueue;
    }

    public Queue<E> consume(Queue<?> queue, Class<?> superClass)
    {

        List<Type> types = new LinkedList<>();

        Class<?> superc = superClass;
        types.add(superc);
        while(!superc.equals(Object.class)){
            types.add(superc.getGenericSuperclass());
            superc = (Class<?>) superc.getGenericSuperclass();
        }

        while (!queue.isEmpty())
            if(types.contains(queue.getHead().getClass()))
                queueLow.add(queue.pop());
            else
                queue.pop();

    }

    //private LinkedList<T> getListOfSuperclasses()
}
