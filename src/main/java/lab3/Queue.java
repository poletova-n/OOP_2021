package lab3;

import lab3.annimals.*;
import lab3.exceptions.*;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Queue<T> {

    class Node {
        private Node next;
        private final T element;

        public Node(T el) {
            element = el;
            next = null;
        }

        public T getElement() {
            return element;
        }
    }

    private final Integer size;
    private Integer capacity = 0;
    private Node head = null;
    private final Class<T> clazz;

    public Queue(int size, Class<T> superclass) {
        this.size = size;
        this.clazz = (Class<T>) superclass.arrayType().componentType();
    }

    public void add(Object el) throws QueueOverflow {

        if (!clazz.isInstance(el))
            throw new ClassCastException("Illegal class casting, " + el + " was not added.");

        if (size.equals(capacity))
            throw new QueueOverflow("Element: " + el.toString() + " was not added, because queue is full");

        if (head == null)
            head = new Node((T) el);

        else {
            Node currentNode = head;
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = new Node((T) el);
        }
        capacity++;
    }
    public T pop() throws QueueUnderflow {
        if (head == null)
            throw new QueueUnderflow("There are no items in the queue.");

        Node temp = head;
        head = head.next;

        capacity--;
        return temp.getElement();
    }
    public T get() {
        return head.getElement();
    }

    public boolean isFull() {
        return size.equals(capacity);
    }
    public boolean isEmpty() {
        return capacity == 0;
    }
    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;
        if (head == null)
            return "Elements=" + "[]";

        while (currentNode.next != null) {
            sb.append(currentNode.getElement().getClass());
            sb.append("\n");
            currentNode = currentNode.next;
        }
        sb.append(currentNode.getElement().getClass());

        return "Elements=[\n" + sb + "\n]";
    }

    public static int SIZE = 4;

    public static Queue<? extends Chordal> produce() throws QueueOverflow {

        Queue<? extends Chordal> queue = new Queue<>(SIZE, Chordal.class );

        Chordal[] animals = new Chordal[SIZE];
        animals[0]  = new BengalOwl();
        animals[1]  = new MagellansOwl();
        animals[2]  = new SilverGibbon();
        animals[3]  = new TheWhiteArmedGibbon();
        for (int i = 0; i < SIZE; i++){
            queue.add(animals[i]);
        }

        return queue;
    }

    public static void consume(Queue<? extends Chordal> queue, Class<?> superClass) throws QueueUnderflow, QueueOverflow {

        Queue<? super Chordal> queueLow = new Queue<>(SIZE, Chordal.class);
        List<Type> types = getListOfSuperClasses(superClass);

        System.out.println(types);

    }

    private static List<Type> getListOfSuperClasses(Class<?> superClass) {

        List<Type> types = new LinkedList<>();

        Class<?> superc = superClass;
        types.add(superc);

        while(!superc.equals(Object.class)){

            types.add(superc.getGenericSuperclass());
            superc = (Class<?>) superc.getGenericSuperclass();
        }

        types.remove(types.size()-1);

        return types;
    }

    public static void selectClass() throws QueueOverflow, QueueUnderflow {

        Queue<? extends Chordal> queue = produce();
        System.out.println("Upper bound queue:\n" + queue + "\n");
        System.out.println("Enter Animal's class name - a parent class for lower bound queue from a list.");

        Scanner sc = new Scanner(System.in);
        String className = null;

        if (sc.hasNext()) {
            className = sc.nextLine();
        }

        switch (className) {
            case "BengalOwl"                    -> consume(queue, BengalOwl.class);
            case "MagellansOwl"                 -> consume(queue, MagellansOwl.class);
            case "SilverGibbon"                 -> consume(queue, SilverGibbon.class);
            case "TheWhiteArmedGibbon"          -> consume(queue, TheWhiteArmedGibbon.class);
            default               -> System.out.println("Unknown class name!");
        }
    }

}