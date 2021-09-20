package lab3;

import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

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

    private Integer size = 0;
    private Integer capacity = 0;
    private Node    head = null;

    public Queue(int size) {
        this.size = size;
    }

    public void add(Object el) throws QueueOverFlow {
        if (size.equals(capacity))
            throw new QueueOverFlow( "Element: " + el.toString() + " was not added, because queueu is full");

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
            throw new QueueUnderFlow("There are no more items in the queue.");

        Node temp = head;
        head = head.next;

        capacity--;
        return temp.getElement();
    }
    public T get(){
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
            sb.append(currentNode.getElement());
            sb.append(", ");
            currentNode = currentNode.next;
        }
        sb.append(currentNode.getElement());
        return "Elements=" + "[" + sb + "]";
    }
}

