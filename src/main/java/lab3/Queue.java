package lab3;

import lab3.classes.Animals;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

public class Queue<T>{
    private int capacity;
    T [] array;
    int lastIndex = 0;
    int firstIndex = 0;
    private Class<T> superclass;
    Queue( int capacity, Class<T> superclass){
        this.capacity = capacity;
        array = (T[])(new Object[capacity]);
        for (int i = 0; i < capacity; i++) {
            array[i] = null;

        }
        this.superclass = (Class<T>) superclass;
    }

    public void add(Animals elem) throws QueueOverflow {
        if (array[lastIndex] != null){
            throw new QueueOverflow("Overflow");
        }
        array[lastIndex] = (T) elem;
        lastIndex++;
        if (lastIndex >= capacity){
            lastIndex = 0;
        }
    }
    public T get()throws QueueUnderflow {
        firstIndex++;
        if (array[firstIndex - 1] == null){
            throw new QueueUnderflow("Underflow");
        }
        T temp = array[firstIndex - 1];
        array[firstIndex - 1] = null;
        if(firstIndex  >= capacity){
            firstIndex = 0;
        }
        return temp;
    }

    public T pick()throws QueueUnderflow {
        if (array[firstIndex] == null){
            throw new QueueUnderflow("Underflow");
        }
        T temp = array[firstIndex];
        return temp;
    }

    public boolean isEmty(){
        return array[firstIndex] == null;
    }

    @Override
    public String toString() {
        String resultString = "";
        for (int i = 0;  i < capacity; i++) {
            if (array[i] != null){
                resultString += array[i].toString();
                resultString += "\n";
            }
        }

        return resultString;
    }
}
