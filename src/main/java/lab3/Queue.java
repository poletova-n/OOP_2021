package lab3;

import lab3.animals.*;
import lab3.exceptions.*;

public class Queue<T> {
	private Node<T> head, tail;
	private final int size;
	private int capacity;
	
	public Queue(int size)
	{
		head = null;
		tail = null;
		this.size = size;
		capacity = 0;
	}
	
	public void print()
	{
		if (isEmpty())
		{
			System.out.println("Queue is empty!");
		}
		
		Node<T> tempHead = head;
		
		while (tempHead != null)
		{
			System.out.print(tempHead.toString() + " ");
			tempHead = tempHead.getNext();
		}
		
		System.out.println();
	}
	
	public void add(Object element) throws QueueOverflow
	{
		try 
		{
			if (capacity == size)
			{
				throw new QueueOverflow("Queue is full!"); 
			}
			
			Node<T> tempTail = tail;
			
			tail = new Node<>();
			tail.setData(element);
			tail.setNext(null);
			
			if (isEmpty())
			{
				head = tail;
			}
			else 
			{
				tempTail.setNext(tail);
			}
			
			capacity++;
		}
		
		catch (QueueOverflow ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public T get() throws QueueUnderflow
	{
		try 
		{
			if (isEmpty())
			{
				throw new QueueUnderflow("Queue is empty!");
			}
			else 
			{
				T tempData = head.getData();
				head = head.getNext();
				capacity--;
				
				if (isEmpty())
				{
					tail.setNext(null);
				}			
				
				return tempData;
			}
		}
		catch (QueueUnderflow ex) 
		{
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public boolean isEmpty()
	{
		return (capacity == 0);
	}
	
	public Queue<? extends Chordates> produce() throws QueueOverflow, QueueUnderflow
	{
		if (size != capacity)
		{
			Queue<? extends Chordates> tempQueue = new Queue<>(this.size);
			Queue<? extends Chordates> hierarchy = getHierarchy();

			if (capacity > 0)
			{
				for (int i = capacity; i > 0; i--)
				{
					T tempData = head.getData();
					head = head.getNext();

					tempQueue.add(tempData);
				}
			}

			while ((tempQueue.capacity != tempQueue.size) & (!hierarchy.isEmpty()))
			{
				tempQueue.add(hierarchy.get());
			}

			return tempQueue;
		}
		else 
		{
			return (Queue<? extends Chordates>) this;
		}
	}
	
	public boolean contains(Class cls)
	{
		Node<T> tempHead = head;
		
		while (tempHead != null)
		{
			if(tempHead.getData().equals(cls))
			{
				return true;
			}
			
			tempHead = tempHead.getNext();
		}
		
		return false;
	}
	
	public void consume(Class cls) throws QueueUnderflow, QueueOverflow
	{
		try 
		{
			if (capacity > 0)
			{
				Queue<? extends T> queueHierarcy = new Queue<>(23);
				
				while (!cls.equals(Chordates.class))
				{
					queueHierarcy.add(cls.getGenericSuperclass());
					cls = (Class) cls.getGenericSuperclass();
				}
				
				Node<T> tempHead = head;
				Queue<? extends T> tempQueue = new Queue<>(size);
				
				while (tempHead != null)
				{
					if(queueHierarcy.contains(tempHead.getData().getClass()))
					{
						tempQueue.add(this.get());;
					}
					else 
					{
						this.get();
					}

					tempHead = tempHead.getNext();
				}
				
				while (!tempQueue.isEmpty())
				{
					this.add(tempQueue.get());
				}
			}
			else 
			{
				throw new QueueUnderflow("Queue is empty!");
			}
		}
		catch (QueueUnderflow ex)
		{
			ex.printStackTrace();
		}
	}
	
	private Queue<? extends Chordates> getHierarchy() throws QueueOverflow
	{
		Queue<? extends Chordates> tempQueue = new Queue<>(23);
		
		tempQueue.add(new Chordates());
		tempQueue.add(new Vertebrates());
		tempQueue.add(new Tunicates());
		tempQueue.add(new Cephalochordate());
		tempQueue.add(new Fishes());
		tempQueue.add(new Mammals());
		tempQueue.add(new Ascidians());
		tempQueue.add(new Salps());
		tempQueue.add(new Lanceolates());
		tempQueue.add(new Osteichthyes());
		tempQueue.add(new Cartilaginous());
		tempQueue.add(new Artiodactyls());
		tempQueue.add(new Carnivores());
		tempQueue.add(new Aplousobranchies());
		tempQueue.add(new Doliolids());
		tempQueue.add(new Amphioxiformes());
		tempQueue.add(new Scyliorhinidaes());
		tempQueue.add(new Deer());
		tempQueue.add(new Clavelinids());
		tempQueue.add(new Doliolunidae());
		tempQueue.add(new Boa());
		tempQueue.add(new Hydropotes());
		tempQueue.add(new Pseudusa());
		
		return tempQueue;
	}
}
