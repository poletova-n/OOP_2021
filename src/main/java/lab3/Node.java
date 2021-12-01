package lab3;

public class Node<T> {
    T value;
    Node<T> next;

    Node(T val, Node<T> next) {
        this.value = val;
        this.next = next;
    }


    public T getVal()
    {
        return value;
    }

    public Node<T> getNext()
    {
        return next;
    }

}