package lab3;

import lab3.animals.classification.cats.*;
import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Functions {

    public static int size = 13;

    public static Queue<? extends Chorda> produce() throws QueueOverFlow {
        Queue queue = new Queue(size, Chorda.class );

        Chorda[] chordCats = new Chorda[size];
        chordCats[0] = new Chorda("c1");
        chordCats[1] = new Mammals("m1");
        chordCats[2] = new Predatory("p1");
        chordCats[3] = new Feline("f1");
        chordCats[4] = new Cat("c1");
        chordCats[5] = new DomesticCat("d1");
        chordCats[6] = new ForestCat("fr1");
        chordCats[7] = new Amphibian("amf");
        chordCats[8] = new Tailless("tl1");
        chordCats[9] = new Dartfrog("drf1");
        chordCats[10] = new TreeFrog("trf1");
        chordCats[11] = new ColoringTreeFrog("clr1");
        chordCats[12] = new RedBelliedToad("rbd1");

        for (int i = 0; i < size; i++)
            queue.add(chordCats[i]);

        System.out.println("Upper bound queue:\n" + queue + "\n");
        return queue;
    }

    public static void consume(Queue<? extends Chorda> queue, Class<? extends Chorda> superClass) throws QueueUnderFlow, QueueOverFlow {
        Queue queuelow = new Queue(size, Chorda.class);

        List<Type> types = new LinkedList<>();
        Class superc = superClass;

        types.add(superc);
        while(!superc.equals(Object.class)){
            types.add(superc.getGenericSuperclass());
            superc = (Class) superc.getGenericSuperclass();
        }

        while (!queue.isEmpty())
            if(types.contains(queue.get().getClass()))
                queuelow.add(queue.pop());
            else
                queue.pop();
        System.out.println("Lower bound queue:\n" + queuelow);
    }

    public static void menu() throws QueueOverFlow, QueueUnderFlow {
        Queue<? extends Chorda> queue = produce();

        System.out.println("Choose number - a parent for lower bound queue.");
        System.out.println("Any key - End." +
                "1 - Feline" +
                "2 - Cat" +
                "3 - Tailless" +
                "4 - Amphibian" +
                "5 - DomesticCat");

        Scanner sc = new Scanner(System.in);
        int n = 0;
        if (sc.hasNextInt())
            n = sc.nextInt();


        switch (n) {
            case 1 -> consume(queue, Feline.class);
            case 2 -> consume(queue, Cat.class);
            case 3 -> consume(queue, Tailless.class);
            case 4 -> consume(queue, Amphibian.class);
            case 5 -> consume(queue, DomesticCat.class);
            default -> System.out.println("End!");
        }
    }
}