package lab3;

import lab3.animals.classification.Chorda;
import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

public class Queue<T extends Chorda> {

    private Integer   maxSize;
    private Integer   capacity;
    private final T[] elements;

    private Integer pointerR;
    private Integer pointerL;

    {
      maxSize = 100;
      capacity = 0;
      pointerR = 0;
      pointerL = -1;
    }

    public Queue() {
        elements = (T[]) new Chorda[maxSize];
    }

    public Queue(int size) {
        if (size > 0)
            maxSize = size;
        elements = (T[]) new Chorda[maxSize];
    }

    public void add(T o) throws QueueOverFlow {
        if (capacity.equals(maxSize))
            throw new QueueOverFlow("There are no more capacity in the queue to add element.");
        if (pointerL == maxSize - 1) {
            pointerL = -1;
        }

        elements[++pointerL] = o;
        capacity++;
    }
    public T    pop() throws QueueUnderFlow {
        if (capacity.equals(0))
            throw new QueueUnderFlow("There are no more items in the queue.");
        T temp = elements[pointerR++];

        if (pointerR.equals(maxSize)) {
            pointerR = 0;
        }
        capacity--;
        return temp;
    }
    public boolean isFull() {
        return capacity == maxSize - 1;
    }
    public boolean isEmpty() {
        return capacity == 0;
    }
    public Integer getSize() {
        return maxSize;
    }
    public T get(){
        return elements[pointerR];
    }

    @Override
    public String toString() {
        return "Elements=" + preWrite(elements)+ "]";
    }

    private String preWrite(T[] elements){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(T el: elements){
            if (el == null){
                continue;
            }
            sb.append(el.name);
            sb.append(", ");
        }

        return sb.substring(0,sb.toString().length()-2);
    }
}