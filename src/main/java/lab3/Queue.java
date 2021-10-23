package lab3;

import lab3.Animals.*;
import lab3.Exceptions.QueueOverFlow;
import lab3.Exceptions.QueueUnderFlow;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

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

    public void add(Object el) throws QueueOverFlow {

        if (!clazz.isInstance(el))
            throw new ClassCastException("Illegal class casting, " + el + " was not added.");

        if (size.equals(capacity))
            throw new QueueOverFlow("Element: " + el.toString() + " was not added, because queue is full");

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
    public T pop() throws QueueUnderFlow {
        if (head == null)
            throw new QueueUnderFlow("There are no items in the queue.");

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
            return "Elements=" + "[<EMPTY>]";

        while (currentNode.next != null) {
            sb.append(currentNode.getElement().getClass());
            sb.append("\n");
            currentNode = currentNode.next;
        }
        sb.append(currentNode.getElement().getClass());

        return "Elements=\n[\n" + sb + "\n]";
    }

    public static int SIZE = 15;
    public static Queue<? extends Chordal> produce() throws QueueOverFlow {

        Queue<? extends Chordal> queue = new Queue<>(SIZE, Chordal.class );

        Chordal[] chordals = new Chordal[SIZE];
        chordals[0]  = new BrownHare();
        chordals[1]  = new Hares();
        chordals[2]  = new Feline();
        chordals[3]  = new Mammals();
        chordals[4]  = new Rodents();
        chordals[5]  = new WhiteHare();
        chordals[6]  = new Chordal();
        chordals[7]  = new Predatory();
        chordals[8]  = new Feline();
        chordals[9]  = new Canines();
        chordals[10] = new Dog();
        chordals[11] = new Fox();
        chordals[12] = new Jackal();
        chordals[13]  = new Panthera();
        chordals[14] = new Wolf();

        for (int i = 0; i < SIZE; i++){

            queue.add(chordals[i]);
        }

        return queue;
    }

    public static void consume(Queue<? extends Chordal> queue, Class<?> cls) throws QueueUnderFlow, QueueOverFlow {

        Queue<? super Chordal> queueLow = new Queue<>(SIZE, Chordal.class);
        List<Type> classes = getClasses(cls);

        System.out.println("Elements=\n[");
        classes.forEach(new Consumer<Type>() {
            @Override
            public void accept(Type t) {
                System.out.println(t);
            }
        });
        System.out.println("]");
    }
    public static void selectClass() throws QueueOverFlow, QueueUnderFlow {

        Queue<? extends Chordal> queue = produce();
        System.out.println("Upper bound queue:\n" + queue + "\n");
        System.out.println("Animal to consume: ");

        Scanner sc = new Scanner(System.in);
        String className = null;

        if (sc.hasNext()) {
            className = sc.nextLine();
        }

        switch (className) {
            case "Brown Hare" -> consume(queue, BrownHare.class);
            case "Hares"      -> consume(queue, Hares.class);
            case "Felidae"    -> consume(queue, Feline.class);
            case "Mammals"    -> consume(queue, Mammals.class);
            case "Rodents"    -> consume(queue, Rodents.class);
            case "White Hare" -> consume(queue, WhiteHare.class);
            case "Chordal"    -> consume(queue, Chordal.class);
            case "Dog"        -> consume(queue, Dog.class);
            case "Canines"    -> consume(queue, Canines.class);
            case "Predatory"     -> consume(queue, Predatory.class);
            case "Fox"        -> consume(queue, Fox.class);
            case "Panthera"   -> consume(queue, Panthera.class);
            case "Jackal"     -> consume(queue, Jackal.class);
            case "Wolf"       -> consume(queue, Wolf.class);
            default           -> System.out.println("didn't have this class ");
        }
    }

    private static List<Type> getClasses(Class<?> superClass) {

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
}