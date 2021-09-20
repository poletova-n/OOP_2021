package lab3;

import lab3.animals.classification.*;
import lab3.animals.classification.cats.*;
import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

public class Functions {

    public static int size = 7;

    public static Queue<? extends Chorda> produce() throws QueueOverFlow {
        Queue<? extends Chorda> queue = new Queue(2 * size);

        Chorda[] chordCats = new Chorda[size];
        chordCats[0] = new Chorda("c1");
        chordCats[1] = new Mammals("m1");
        chordCats[2] = new Predatory("p1");
        chordCats[3] = new Feline("f1");
        chordCats[4] = new Cat("c1");
        chordCats[5] = new DomesticCat("d1");
        chordCats[6] = new ForestCat("fr1");

        for (int i = 0; i < size; i++)
            queue.add(chordCats[i]);


        System.out.println("Upper bound queue:\n" + queue + "\n");
        return queue;
    }

    public static void consume(Queue<? extends Chorda> queue) throws QueueUnderFlow, QueueOverFlow {
        Queue<? super Feline> superFeline = new Queue(size);

        while (!queue.isEmpty())
            if (!(queue.get() instanceof Feline) || (queue.get()).getClass().equals(Feline.class))
                superFeline.add(queue.pop());
            else
                queue.pop();

        System.out.println("Lower bound queue:\n" + superFeline);
    }
}