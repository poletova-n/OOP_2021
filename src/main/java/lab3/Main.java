package lab3;

import lab3.exeptions.*;
import lab3.animals.*;

public class Main {
    public static void main(String[] args) throws QueueOverflow, QueueUnderflow
    {
        Queue<? extends Chordate> queueFour = new Queue<>(4);
        queueFour = queueFour.produce();
        queueFour.print();
        queueFour.consume(Kangaroos.class);
        queueFour.print();

        System.out.println();

        Queue<? extends Chordate> queueTen = new Queue<>(10);
        queueTen.add(new Mammals());
        queueTen.add(new Cetaceans());
        queueTen.add(new Dolphin());
        queueTen.print();
        queueTen = queueTen.produce();
        queueTen.print();
        queueTen.consume(Afalina.class);
        queueTen.print();

        System.out.println();

        Queue<? extends Chordate> queueFull = new Queue<>(14);
        queueFull = queueFull.produce();
        queueFull.print();
        queueFull.consume(TreeKangaroos.class);
        queueFull.print();
        queueFull = queueFull.produce();
        queueFull.consume(TreeKangaroos.class);
        queueFull.print();
    }
}