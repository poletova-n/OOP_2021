package lab3;

import lab3.animals.*;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

public class Main {
    public static void main(String[] args) throws QueueOverflow, QueueUnderflow {
        Queue<? extends Chordate> queueFour = new Queue<>(4);
        queueFour = queueFour.produce();
        queueFour.print();
        queueFour.consume(Caracal.class);
        queueFour.print();

        System.out.println();

        Queue<? extends Chordate> queueTen = new Queue<>(10);
        queueTen.add(new Mammals());
        queueTen.add(new Raccoon());
        queueTen.add(new CommonRacoon());
        queueTen.print();
        queueTen = queueTen.produce();
        queueTen.print();
        queueTen.consume(TresMariasRaccoon.class);
        queueTen.print();

        System.out.println();

        Queue<? extends Chordate> queueFull = new Queue<>(14);
        queueFull = queueFull.produce();
        queueFull.print();
        queueFull.consume(SteppeLynx.class);
        queueFull.print();
        queueFull = queueFull.produce();
        queueFull.consume(SteppeLynx.class);
        queueFull.print();
    }
}
