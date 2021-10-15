package lab3;

import lab3.Animal.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.Math;

@SuppressWarnings("unchecked")
public class GenericLinkedQueue<T> {

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int currSize = 0;
    private Node<T> front;
    private Node<T> rear;

    GenericLinkedQueue () {
        this.front = null;
        this.rear = null;
    }

    public void add (T value) {
        if (rear == null) {
            this.rear = new Node<>(value,null);
            this.front = this.rear;
        } else {
            this.rear.next = new Node<>(value, null);
            this.rear = this.rear.next;
        }
        this.currSize++;
    }

    public T get () {
        try {
            if (this.front == null) {
                throw new IllegalStateException("Impossible to get an element! The queue is empty!\n");
            }
            T temp = this.front.value;
            this.front = this.front.next;
            this.currSize--;
            if (this.front == null) {
                this.rear = null;
            }
            return temp;
        }
        catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean isEmpty() {
        return (this.front == null);
    }

    public void randomFill (int count) {
        final Class<?>[] Animals = new Class[] {NapoleonVelvetWeaver.class, FieryVelvetWeaver.class, HermitThrush.class, BicknellsThrush.class, GreyMeekLemur.class, GoldenLemur.class, Baboon.class, Anubis.class};
        try {
            for (int i = 0; i < count; i++) {
                this.add((T)Animals[(int) (Math.random() * 8)].getConstructor().newInstance());
            }
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    <E> GenericLinkedQueue<? extends E> produce (Class<? extends E> type) {

        GenericLinkedQueue<E> newQueue = new GenericLinkedQueue<>();
        if (this.isEmpty()) {
            this.randomFill(5);
        }

        Node<?> it = this.front;
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

    <E> GenericLinkedQueue<Class<? super E>> consume () {

        if (this.isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        GenericLinkedQueue<Class<? super E>> newQueue = new GenericLinkedQueue<>();

        int counter = this.currSize;
        int numerator = 1;
        for (int i = counter; i > 0; i--) {
            Class<?> element = this.get().getClass();
            Class<?> iParent = element.getSuperclass();
            newQueue.add((Class<E>)iParent);
            System.out.print(numerator + ") " + iParent.getSimpleName());
            while (!iParent.getSimpleName().equals("Chordate")) {
                iParent = iParent.getSuperclass();
                System.out.print(" <- " + iParent.getSimpleName());
            }
            System.out.println(": (" + element.getSimpleName() + ")");
            numerator++;
        }
        System.out.println();
        return newQueue;
    }
}