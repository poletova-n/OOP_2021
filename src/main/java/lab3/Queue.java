package lab3;

import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.function.Supplier;

public class Queue<T>{
    private int capacity;
    T [] array;
    int lastIndex = 0;
    int firstIndex = 0;
    Queue( int capacity){
        this.capacity = capacity;
        array = (T[])(new Object[capacity]);
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
    }

    public void add(T elem) throws QueueOverflow {
        if (array[lastIndex] != null){
            throw new QueueOverflow("Overflow");
        }
        array[lastIndex] = elem;
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

    public boolean isEmty(){
        return array[firstIndex] == null;
    }

    @Override
    public String toString() {
        String resultString = "";
        for (int i = firstIndex; i < lastIndex || i < capacity; i++) {
            if (array[i] != null){
                resultString += array[i].toString();
                resultString += "\n";
            }
        }
        for (int i = 0; i < firstIndex; i++) {
            if (array[i] != null){
                resultString += array.toString();
                resultString += "\n";
            }
        }
        return resultString;
    }
}
