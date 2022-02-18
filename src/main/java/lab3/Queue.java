package lab3;

import lab3.animals.*;
import java.lang.Math;
import java.lang.reflect.InvocationTargetException;

public class Queue<T>
{
    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void add(T object){
        if (tail == null) {
            this.tail = new Node<>(object,null);
            this.head = this.tail;
        } else {
            this.tail.next = new Node<>(object, null);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    <E> Queue<Class<? super E>> consume (){
        if (this.isEmpty()) {
            System.out.println("The queue is empty!");
            return null;
        }
        Queue<Class<? super E>> tempQueue = new Queue<>();
        int counter = this.size;
        int num = 1;
        for (int i = counter; i > 0; i--) {
            Class<?> element = this.get().getClass();
            Class<?> parent = element.getSuperclass();
            tempQueue.add((Class<E>)parent);
            System.out.print(num + ") " + parent.getSimpleName());
            while (!parent.getSimpleName().equals("Chordate")) {
                parent = parent.getSuperclass();
                System.out.print(" <- " + parent.getSimpleName());
            }
            System.out.println(": (" + element.getSimpleName() + ")");
            num++;
        }
        System.out.println();
        return tempQueue;
    }

    public T get()
    {
        try {
            if (this.head == null) {
                throw new IllegalStateException("The queue is empty!\n");
            }
            T temp = this.head.value;
            this.head = this.head.next;
            this.size--;
            if (this.head == null) {
                this.tail = null;
            }
            return temp;
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getRandomFill(int count){
        final Class<?>[] animals = new Class[]
                {Flamingo.class, IndianPeafowl.class, WildTurkey.class, BlackNeckedGrebe.class};
        try {
            for (int i = 0; i < count; i++) {
                this.add((T)animals[(int) (Math.random() * 4)].getConstructor().newInstance());
            }
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    <E> Queue<? extends E> produce (Class<? extends E> type){
        Queue<E> newQueue = new Queue<>();
        if (this.isEmpty()) {
            this.getRandomFill(2);
        }
        Node<?> it = this.head;
        while (it != null) {
            Class<?> temp = it.value.getClass();
            boolean cond = true;
            while (!temp.getSimpleName().equals(type.getSimpleName())) {
                if (temp.getName().equals("java.lang.Object")) {
                    cond = false;
                    break;
                }
                temp = temp.getSuperclass();
            }
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
}