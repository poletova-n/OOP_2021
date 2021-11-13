package lab3;
import lab3.animals.*;

import java.lang.reflect.InvocationTargetException;

public class Queue<T> {

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int curSize = 0;
    private Node<T> start;
    private Node<T> end;
    private final Class<?>[] Animals = new Class[] {Assimilis.class, Badius.class, Nebulosa.class, Aluco.class, Hirsutus.class, Tasmaniensis.class, Agilis.class, Dorsalis.class};

    Queue () {
        this.start = null;
        this.end = null;
    }

    public void add (T value) {
        if (end == null) {
            this.end = new Node<>(value,null);
            this.start = this.end;
        } else {
            this.end.next = new Node<>(value, null);
            this.end = this.end.next;
        }
        this.curSize++;
    }

    public T get () {
        try {
            if (this.start == null) {
                throw new IllegalStateException("Impossible to get an element! The queue is empty!\n");
            }
            T temp = this.start.value;
            this.start = this.start.next;
            this.curSize--;
            if (this.start == null) {
                this.end = null;
            }
            return temp;
        }
        catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean isEmpty() {
        return (this.start == null);
    }

    public void randomFill (int count) {
        final Class<?>[] Animals = new Class[] {Assimilis.class, Badius.class, Nebulosa.class, Aluco.class, Hirsutus.class, Tasmaniensis.class, Agilis.class, Dorsalis.class};
        try {
            for (int i = 0; i < count; i++) {
                this.add((T)Animals[(int) (Math.random() * 8)].getConstructor().newInstance());
            }
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }


    <E> Queue<? extends E> produce (Class<? extends E> type) {

        Queue<E> newQueue = new Queue<>();
        if (this.isEmpty()) {
            this.randomFill(5);
        }

        Node<?> it = this.start;
        while (it != null) {
            Class<?> temp = it.value.getClass();
            boolean cond = true;
            temp = it.value.getClass();
            if (cond) {
                try {
                    newQueue.add((E) temp.getConstructor().newInstance());
                    System.out.print(temp.getSimpleName() + " ");
                }
                catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            it = it.next;
        }
        if (newQueue.isEmpty()) {
            System.out.print("There were no " + type.getSimpleName() + " heirs in the queue");
        }
        System.out.println();
        return newQueue;
    }

    <E> Queue<Queue<Class<? super E>>> consume () {

        Queue<Queue<Class<? super E>>> allQueues = new Queue<>();
        int counter = this.curSize;
        int curNum = 1;
        for (int i = counter; i > 0; i--) {
            Class<?> element = this.get().getClass();

            Class<?> iParent = element.getSuperclass();
            Queue<Class<? super E>> newQueue = new Queue<>();
            while (!iParent.getSimpleName().equals("Chordate")) {
                newQueue.add((Class<E>) iParent);
                iParent = iParent.getSuperclass();
            }
            newQueue.add((Class<E>) iParent);
            allQueues.add(newQueue);

            System.out.print(curNum + ") " + iParent.getSimpleName());
            System.out.println(": " + element.getSimpleName());
            curNum++;
        }
        System.out.println();
        return allQueues;
    }
}