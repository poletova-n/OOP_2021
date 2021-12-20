package lab3;

import lab3.classes.*;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
        newQueue.add(new Ferret("Ferret", "small", "ferret"));
        newQueue.add(new Weasels("Weasel","small" ,"weasel"));
        newQueue.add(new Chorda("Chorda"));
        newQueue.add(new NonChorda("NonChorda"));
        return newQueue;
    }
    public int size(){
        return lastIndex - firstIndex;
    }
    <E> Queue<Queue<Class<? super E>>> consume () {

        Queue<Queue<Class<? super E>>> allQueues = new Queue<>();
        int counter = this.size();
        int curNum = 1;
        ArrayList<ArrayList<Class<? super E>>> arrayLists = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            Class<? super E> el = (Class<? super E>) this.get().getClass();

            Class<?> Parent = el.getSuperclass();
            Queue<Class<? super E>> newQueue = new Queue<>();
            boolean added = false;
            for (int j = 0; j < arrayLists.size(); j++) {
                if (arrayLists.get(j).get(0).getSuperclass() == Parent){
                    arrayLists.get(j).add(el);
                    added = true;
                    break;
                }

            }
            if (!added){
                //newQueue.add((Class<E>)el);
                arrayLists.add(new ArrayList<>());
                arrayLists.get(arrayLists.size() - 1).add(el);
            }


            curNum++;
        }
        for (int i = 0; i < arrayLists.size(); i++) {
            Queue<Class<? super E>> queue = new Queue<>();
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                queue.add(arrayLists.get(i).get(j));
            }
            allQueues.add(queue);
        }
        System.out.println();
        int count = 1;
        System.out.println(allQueues.size());
        while (!allQueues.isEmty()){
            System.out.println("GROUP " + count);
            while(!allQueues.pick().isEmty()){
                System.out.println(allQueues.pick().get().getSimpleName());
            }
            System.out.println();
            allQueues.get();
            count++;
        }
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
