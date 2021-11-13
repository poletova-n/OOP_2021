package lab3;

class Node<T> {
    private Node<T> next;
    private T obj;

    public Node<T> getNext() {
        return next;
    }
    public T getObj() {
        return obj;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public void setObj(Object obj) {
        this.obj = (T) obj;
    }
    @Override
    public String toString() {
        return String.valueOf(obj);
    }
}
