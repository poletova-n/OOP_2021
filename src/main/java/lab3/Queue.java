package lab3;

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
    private Node head = null;

    public Queue() {
    }

    public void add(Object el) {
        if (head == null)
            head = new Node((T) el);
        else {
            Node currentNode = head;
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = new Node((T) el);
        }
        size++;
    }
    public T pop() throws QueueUnderFlow {
        if (head == null)
            throw new QueueUnderFlow("There are no more items in the queue.");

        Node temp = head;
        head = head.next;

        size--;
        return temp.getElement();
    }

    public T get(){
        return head.getElement();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;
        while (currentNode.next != null) {
            sb.append(currentNode.getElement());
            sb.append(", ");
            currentNode = currentNode.next;
        }
        sb.append(currentNode.getElement());
        return "Elements=" + "[" + sb + "]";
    }

}

