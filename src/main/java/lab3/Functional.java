package lab3;

import lab3.classes.*;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

import java.util.ArrayList;


public class Functional {
    public static Queue<Animals> produce() throws QueueUnderflow ,QueueOverflow {
        Queue<Animals> queue = new Queue<>(10);
        queue.add(new Animals("Animal"));
        queue.add(new Chorda("Chorda"));
        queue.add(new Mammals("Mammals"));
        queue.add(new Predators("Predators"));
        queue.add(new Mustelidae("Mustelidae", "small"));
        queue.add(new WeaselsAndFerrets("WeaselsAndFerrets", "small"));
        queue.add(new Weasels("Weasel","small" ,"weasel"));
        queue.add(new Ferret("Ferret", "small", "ferret"));
        return queue;
    }
    public static ArrayList<Animals> upperBound() throws QueueUnderflow, QueueOverflow{
        ArrayList<Animals> sort = new ArrayList<>();
        Queue<Animals> queue = produce();
        while (!queue.isEmty()){
            sort.add(queue.get());
        }
        for (int i = 1; i < sort.size(); i++) {
            if (sort.get(i - 1).getClass().getAnnotation(Deep.class).deep() > sort.get(i).getClass().getAnnotation(Deep.class).deep()){
                Animals temp = sort.get(i-1);
                sort.set(i - 1, sort.get(i));
                sort.set(i, temp);
                i = 0;
            }
        }
        return sort;
    }
    public static ArrayList<Animals> lowerBound() throws QueueUnderflow, QueueOverflow{
        ArrayList<Animals> sort = new ArrayList<>();
        Queue<Animals> queue = produce();
        while (!queue.isEmty()){
            sort.add(queue.get());
        }
        for (int i = 1; i < sort.size(); i++) {
            if (sort.get(i - 1).getClass().getAnnotation(Deep.class).deep() < sort.get(i).getClass().getAnnotation(Deep.class).deep()){
                Animals temp = sort.get(i-1);
                sort.set(i - 1, sort.get(i));
                sort.set(i, temp);
                i = 0;
            }
        }
        return sort;
    }
}
