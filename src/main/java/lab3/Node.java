package lab3;

public class Node<T> {
	private Node<T> next;
	private T data;
	
	public void setData(Object data)
	{
		this.data = (T) data;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	public T getData()
	{
		return data;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(data);
	}
}
