package lab3;

import lab3.classes.*;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Queue<T>{
    private int capacity;
    T [] array;
    int lastIndex = 0;
    int firstIndex = 0;
    private Class<T> superclass;
    Queue( int capacity  , Class<T> superclass){
        this.capacity = capacity;
        array = (T[])(new Object[capacity]);
        for (int i = 0; i < capacity; i++) {
            array[i] = null;

        }
        this.superclass = (Class<T>) superclass;
    }

    public Queue() {
        this.capacity = 20;
        array = (T[])(new Object[capacity]);
        for (int i = 0; i < capacity; i++) {
            array[i] = null;

        }
    }

    public void add(Object elem) throws QueueOverflow {
        //System.out.println(lastIndex);
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
    <E> Queue<? extends E> produce (Class<? extends E> type) {


        Queue<? extends E> newQueue = new Queue<>();

        Animals[] tmp = new Animals[5];
        final Animals[] Animals = new Animals[] {new Animals("Animal"),new Chorda("Chorda"),new Mammals("Mammals"),new Predators("Predators"),new Mustelidae("Mustelidae", "small"),new WeaselsAndFerrets("WeaselsAndFerrets", "small"),new Weasels("Weasel","small" ,"weasel"),new Ferret("Ferret", "small", "ferret")};
        for (int i = 0; i < 5; i++){
            tmp[i] =  Animals[(int) (Math.random() * 8)];
        }
        for (int i = 0; i < 5; i++){
            newQueue.add(tmp[i]);
        }
        return newQueue;
    }
    public int size(){
        return lastIndex - firstIndex;
    }
    <E> Queue<Queue<Class<? super E>>> consume () {

        Queue<Queue<Class<? super E>>> allQueues = new Queue<>();
        int counter = this.size();
        int curNum = 1;
        for (int i = counter; i > 0; i--) {
            Class<?> el = this.get().getClass();

            Class<?> Parent = el.getSuperclass();
            Queue<Class<? super E>> newQueue = new Queue<>();
            newQueue.add((Class<E>) el);
            System.out.print(curNum + ") " + Parent.getSimpleName());
            System.out.println(": " + el.getSimpleName());
            while (!Parent.getSimpleName().equals("Animals")) {
                newQueue.add((Class<E>) Parent);
                Parent = Parent.getSuperclass();
            }
            newQueue.add((Class<E>) Parent);
            allQueues.add(newQueue);


            curNum++;
        }
        System.out.println();
        return allQueues;
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
