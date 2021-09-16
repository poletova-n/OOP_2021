package lab3;

import lab3.fauna.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queue<T> {
    private int capacity;
    private int size = 0;
    private T[] q;
    private boolean isEmpty = true;
    private int head, tail = 0;


    public Queue(Class<T> type, int initSize) {
        if (initSize < 1) {
            throw new IndexOutOfBoundsException("Queue size should be >= 1");
        }
        capacity = initSize;

        //i could pass already created array as a parameter, but this way it looks more neat
        q = (T[]) Array.newInstance(type, initSize);
    }


    private static List<Class> getClasses(ClassLoader cl,String pack) throws Exception{

        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<Class>();
        URL upackage = cl.getResource(pack);

        BufferedReader dis = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
        String line = null;
        while ((line = dis.readLine()) != null) {
            if(line.endsWith(".class")) {
                classes.add(Class.forName(dottedPackage+"."+line.substring(0,line.lastIndexOf('.'))));
            }
        }
        return classes;
    }

    public int getSize() {
        return size;
    }


    public <Q> Queue<? extends Q> produce(Class<? extends Q> type)  {

        Queue<Q> newQueue = new Queue<Q>((Class<Q>) type,capacity);
        Q typeInstance = null;

        try {
            typeInstance = type.getDeclaredConstructor().newInstance();
            newQueue.add(typeInstance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }


        List<Class> classes = null;
        try {
            classes = getClasses(Main.class.getClassLoader(),"lab3/fauna");
        } catch (Exception e) {
            e.printStackTrace();
        }


        for(Class c:classes){
            if (!c.isInstance(typeInstance) && Math.random() > 0.3) {
                try {
                    newQueue.add((Q) c.getConstructor().newInstance());
                    System.out.println("Class: "+c + " is added to queue" );
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

        }

        return newQueue;
    }


    public <Q> Queue<Q> consume(Class<Q> type) {

        Queue<Q> lowerQueue = new Queue<Q>((Class<Q>) type,capacity);

        Q typeInstance = null;

        try {
            typeInstance = (Q) type.getDeclaredConstructor().newInstance();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }


        while (size > 0) {
            Q obj = (Q) this.get();
            if (!obj.getClass().isInstance(typeInstance)) {
                lowerQueue.add( obj);
                System.out.println("Class: "+obj.getClass().getName() + " is consumed" );
            }
        }


        return lowerQueue;
    }

    public void add(T obj) {
        size++;

        if (isEmpty) {
            isEmpty = false;
            tail = head = 0;
            q[tail] = obj;
            return;
        }


        if (((tail >= head) && (tail < (capacity - 1))) || (tail < head - 1)) {
            tail++;
        } else if ((tail >= capacity - 1) && head != 0) {
            tail = 0;
        } else {
            throw new IndexOutOfBoundsException("Queue is full");
        }

        q[tail] = obj;


    }

    public T get() {

        if (isEmpty)
            throw new IndexOutOfBoundsException("Queue is empty");

        size--;

        if (head == tail) {
            isEmpty = true;
            return q[head];
        }

        if (tail > head || head < capacity - 1)  {
            head++;
            return q[head - 1];
        } else if ((tail >= capacity - 1) && head != 0) {
            head = 0;
            return q[capacity - 1];
        } else {
            throw new IndexOutOfBoundsException("Queue is empty");
        }


    }



}
