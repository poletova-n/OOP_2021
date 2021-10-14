package lab3;

import lab3.exceptions.*;

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
}