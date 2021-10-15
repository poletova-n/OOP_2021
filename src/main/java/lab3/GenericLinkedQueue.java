package lab3;
import lab3.Animal.*;

import java.lang.reflect.InvocationTargetException;

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
    private final Class<?>[] Animals = new Class[] {NapoleonVelvetWeaver.class, FieryVelvetWeaver.class, HermitThrush.class, BicknellsThrush.class, GreyMeekLemur.class, GoldenLemur.class, Baboon.class, Anubis.class};

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

    <E> GenericLinkedQueue<? extends E> produce (Class<? extends E> type) {

        GenericLinkedQueue<E> newQueue = new GenericLinkedQueue<>();

        for (Class<?> i: Animals) {
            Class<?> temp = i;
            boolean cond = true;
            while (!temp.getSimpleName().equals(type.getSimpleName())) {
                if (temp.getName().equals("java.lang.Object")) {
                    cond = false;
                    break;
                }
                temp = temp.getSuperclass();
            }
            if (cond) {
                try {
                    newQueue.add((E) i.getConstructor().newInstance());
                    System.out.print(i.getSimpleName() + " ");
                }
                catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        System.out.println();
        return newQueue;
    }

    <E> GenericLinkedQueue<Class<? super E>> consume () {
        GenericLinkedQueue<Class<? super E>> newQueue = new GenericLinkedQueue<>();
        int counter = this.currSize;
        int numerator = 1;
        Class<?> parent = null;
        for (int i = counter; i > 0; i--) {
            Class<?> element = this.get().getClass();
            Class<?> iParent = element.getSuperclass();
            if (parent != null && iParent.getSimpleName().equals(parent.getSimpleName())) {
                System.out.print(", " + element.getSimpleName());
                if (i == 1) {
                    System.out.print(")");
                }
                continue;
            } else if (i != counter) {
                System.out.println(")");
            }
            parent = iParent;
            newQueue.add((Class<E>)iParent);
            System.out.print(numerator + ") " + iParent.getSimpleName()); //": (" + element.getSimpleName());
            while (!iParent.getSimpleName().equals("Chordate")) {
                iParent = iParent.getSuperclass();
                System.out.print(" <- " + iParent.getSimpleName());
            }
            System.out.print(": (" + element.getSimpleName());
            numerator++;
        }
        System.out.println();
        return newQueue;
    }
}