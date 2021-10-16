package lab3;

public class Node<T>
{
    private Node<T> next;
    private T obj;

    public void setObj(Object obj)
    {
        this.obj = (T) obj;
    }

    public T getObj()
    {
        return obj;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public Node<T> getNext()
    {
        return next;
    }

    @Override
    public String toString()
    {
        return String.valueOf(obj);
    }
}
