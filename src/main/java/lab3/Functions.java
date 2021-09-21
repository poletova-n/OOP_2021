package lab3;

import lab3.animals.classification.*;
import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Functions {

    public static int SIZE = 13;

    public static Queue<? extends Chorda> produce() throws QueueOverFlow {
        Queue queue = new Queue(SIZE, Chorda.class );

        Chorda[] chordCats = new Chorda[SIZE];
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

        for (int i = 0; i < SIZE; i++)
            queue.add(chordCats[i]);

        System.out.println("Upper bound queue:\n" + queue + "\n");
        return queue;
    }
    public static void consume(Queue<? extends Chorda> queue, Class superClass) throws QueueUnderFlow, QueueOverFlow {
        Queue queueLow = new Queue(SIZE, Chorda.class);
        List<Type> types = getListOfSuperClasses(superClass);

        while (!queue.isEmpty())
            if(types.contains(queue.get().getClass()))
                queueLow.add(queue.pop());
            else
                queue.pop();
        System.out.println("Lower bound queue:\n" + queueLow);
    }
    public static void menu() throws QueueOverFlow, QueueUnderFlow {

        System.out.println("List of accessible Animals:\n" +
                "Amphibian\n" +
                "Cat\n" +
                "Chorda\n" +
                "ColoringTreeFrog\n" +
                "Dartfrog\n" +
                "DomesticCat\n" +
                "Feline\n" +
                "ForestCat\n" +
                "Mammals\n" +
                "Predatory\n" +
                "RedBelliedToad\n" +
                "Tailless\n" +
                "TreeFrog\n" +
                "Enter Animal - a parent for lower bound queue from a list.");

        Scanner sc = new Scanner(System.in);
        String classString = null;
        if (sc.hasNext())
            classString = sc.nextLine();

        Queue<? extends Chorda> queue = produce();

        switch (classString) {
            case "Amphibian" -> consume(queue, Amphibian.class);
            case "Cat" -> consume(queue, Cat.class);
            case "Chorda" -> consume(queue, Chorda.class);
            case "ColoringTreeFrog" -> consume(queue, ColoringTreeFrog.class);
            case "Dartfrog" -> consume(queue, Dartfrog.class);
            case "DomesticCat" -> consume(queue, DomesticCat.class);
            case "Feline" -> consume(queue, Feline.class);
            case "Mammals" -> consume(queue, Mammals.class);
            case "ForestCat" -> consume(queue, ForestCat.class);
            case "Predatory" -> consume(queue, Predatory.class);
            case "RedBelliedToad" -> consume(queue, RedBelliedToad.class);
            case "Tailless" -> consume(queue, Tailless.class);
            case "TreeFrog" -> consume(queue, TreeFrog.class);
            default -> System.out.println("End!");
        }
    }

    private static List<Type> getListOfSuperClasses(Class superClass) {
        List<Type> types = new LinkedList<>();

        Class superc = superClass;
        types.add(superc);
        while(!superc.equals(Object.class)){
            types.add(superc.getGenericSuperclass());
            superc = (Class) superc.getGenericSuperclass();
        }
        return types;
    }

}