package lab3;

import lab3.exceptions.*;
import lab3.annimals.*;

public class Main {
    public static void main(String[] args) throws QueueOverflow, QueueUnderflow
    {
        Queue<? extends Chordal> queue1= new Queue<>(8);
        queue1 = queue1.produce();
        queue1.print();
        queue1.consume(MagellansOwl.class);
        queue1.print();

        System.out.println();

        Queue<? extends Chordal> queue2 = new Queue<>(12);
        queue2.add(new Birds());
        queue2.add(new Bubo());
        queue2.print();
        queue2 = queue2.produce();
        queue2.print();
        queue2.consume(SilverGibbon.class);
        queue2.print();

        System.out.println();
    }
}